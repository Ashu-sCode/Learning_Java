import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AsciiGUI {
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("ASCII Value Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        JLabel label = new JLabel("Enter text: ");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Show ASCII");
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(button);

        // Output area
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button Action
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter some text!");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                int sum = 0;

                sb.append("Character → ASCII Value\n");
                sb.append("------------------------\n");

                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    int ascii = (int) ch;
                    sb.append(ch + " → " + ascii + "\n");
                    sum += ascii;
                }

                sb.append("\nTotal ASCII Sum: " + sum);

                outputArea.setText(sb.toString());
            }
        });

        // Show Frame
        frame.setVisible(true);
    }
}
