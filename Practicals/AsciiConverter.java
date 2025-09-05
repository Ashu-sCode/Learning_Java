import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AsciiConverter {
    private JFrame frame;
    private JTextArea inputArea;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> modeBox;
    private JCheckBox liveUpdate;
    private JLabel status;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AsciiConverter::new);
    }

    public AsciiConverter() {
        buildUI();
    }

    private void buildUI() {
        frame = new JFrame("Language → ASCII / Encoding Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // ==== Top: Input Panel ====
        JPanel top = new JPanel(new BorderLayout(8, 8));
        JLabel title = new JLabel("Enter text below and choose an encoding mode:");
        title.setBorder(BorderFactory.createEmptyBorder(8, 8, 0, 8));
        top.add(title, BorderLayout.NORTH);

        inputArea = new JTextArea(5, 40);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Input"));
        top.add(inputScroll, BorderLayout.CENTER);

        frame.add(top, BorderLayout.NORTH);

        // ==== Center: Table ====
        String[] cols = { "#", "Char", "Code Point", "ASCII (0-127)", "ISO-8859-1", "UTF-8 Bytes", "ASCII (bin)" };
        model = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        table.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        table.setRowHeight(22);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Per-character mapping"));
        frame.add(tableScroll, BorderLayout.CENTER);

        // ==== Bottom: Controls ====
        JPanel bottom = new JPanel(new BorderLayout());

        JPanel controls = new JPanel();
        modeBox = new JComboBox<>(new String[] {
                "ASCII (0-127)",
                "ISO-8859-1 (Latin-1)",
                "UTF-8 bytes"
        });
        liveUpdate = new JCheckBox("Live update", true);
        JButton convertBtn = new JButton("Convert");
        JButton clearBtn = new JButton("Clear");
        JButton copyBtn = new JButton("Copy table as text");
        JButton exportBtn = new JButton("Export CSV…");

        controls.add(new JLabel("Mode:"));
        controls.add(modeBox);
        controls.add(liveUpdate);
        controls.add(convertBtn);
        controls.add(clearBtn);
        controls.add(copyBtn);
        controls.add(exportBtn);

        bottom.add(controls, BorderLayout.NORTH);

        status = new JLabel("Ready");
        status.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 8));
        bottom.add(status, BorderLayout.SOUTH);

        frame.add(bottom, BorderLayout.SOUTH);

        // ==== Actions ====
        convertBtn.addActionListener(this::doConvert);
        clearBtn.addActionListener(e -> {
            inputArea.setText("");
            model.setRowCount(0);
            status.setText("Cleared");
        });
        copyBtn.addActionListener(e -> copyTableAsText());
        exportBtn.addActionListener(e -> exportCSV());

        inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (liveUpdate.isSelected())
                    doConvert(null);
            }
        });
        modeBox.addActionListener(e -> {
            if (liveUpdate.isSelected())
                doConvert(null);
        });

        frame.setVisible(true);
    }

    private void doConvert(ActionEvent e) {
        model.setRowCount(0);
        String text = inputArea.getText();
        if (text.isEmpty()) {
            status.setText("No input");
            return;
        }

        String mode = (String) modeBox.getSelectedItem();
        int index = 1;
        int asciiCount = 0;
        int nonAsciiCount = 0;

        // Iterate code points to correctly handle emojis and non-BMP chars
        int[] cps = text.codePoints().toArray();
        for (int cp : cps) {
            String chStr = new String(Character.toChars(cp));
            String display = printableLabel(cp, chStr);
            String codePoint = String.format("U+%04X", cp);

            String asciiDec = (cp <= 0x7F) ? Integer.toString(cp) : "N/A";
            String asciiBin = (cp <= 0x7F) ? String.format("%8s", Integer.toBinaryString(cp)).replace(' ', '0') : "";
            String latin1 = (cp <= 0xFF) ? Integer.toString(cp) : "N/A";
            String utf8Hex = toHexBytes(chStr.getBytes(StandardCharsets.UTF_8));

            if (cp <= 0x7F)
                asciiCount++;
            else
                nonAsciiCount++;

            model.addRow(new Object[] { index++, display, codePoint, asciiDec, latin1, utf8Hex, asciiBin });
        }

        status.setText(
                String.format("Chars: %d  |  ASCII: %d  |  Non-ASCII: %d", cps.length, asciiCount, nonAsciiCount));
    }

    private String printableLabel(int cp, String chStr) {
        switch (cp) {
            case '\n':
                return "\\n (LF)";
            case '\r':
                return "\\r (CR)";
            case '\t':
                return "\\t (TAB)";
            case ' ':
                return "␠ (space)";
            default:
                if (cp < 32 || (cp >= 127 && cp < 160)) {
                    // Control characters
                    return String.format("CTRL U+%04X", cp);
                }
                return chStr;
        }
    }

    private String toHexBytes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i] & 0xFF));
            if (i < bytes.length - 1)
                sb.append(' ');
        }
        return sb.toString();
    }

    private void copyTableAsText() {
        int rows = model.getRowCount();
        int cols = model.getColumnCount();
        StringBuilder sb = new StringBuilder();
        // header
        for (int c = 0; c < cols; c++) {
            sb.append(model.getColumnName(c));
            if (c < cols - 1)
                sb.append('\t');
        }
        sb.append('\n');
        // rows
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Object val = model.getValueAt(r, c);
                sb.append(val == null ? "" : val.toString());
                if (c < cols - 1)
                    sb.append('\t');
            }
            sb.append('\n');
        }
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(new StringSelection(sb.toString()), null);
        status.setText("Copied table to clipboard (TSV)");
    }

    private void exportCSV() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Export as CSV");
        chooser.setSelectedFile(new File("ascii_export.csv"));
        if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try (FileWriter fw = new FileWriter(f)) {
                // header
                for (int c = 0; c < model.getColumnCount(); c++) {
                    fw.write(escapeCSV(model.getColumnName(c)));
                    if (c < model.getColumnCount() - 1)
                        fw.write(",");
                }
                fw.write("\n");
                // rows
                for (int r = 0; r < model.getRowCount(); r++) {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        Object val = model.getValueAt(r, c);
                        fw.write(escapeCSV(val == null ? "" : val.toString()));
                        if (c < model.getColumnCount() - 1)
                            fw.write(",");
                    }
                    fw.write("\n");
                }
                status.setText("Exported: " + f.getAbsolutePath());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to export: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String escapeCSV(String s) {
        boolean needsQuotes = s.contains(",") || s.contains("\n") || s.contains("\"");
        if (!needsQuotes)
            return s;
        return '"' + s.replace("\"", "\"\"") + '"';
    }
}
