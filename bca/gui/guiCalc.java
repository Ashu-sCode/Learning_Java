import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class guiCalc {

    private TextField display;

    public guiCalc() {
        Frame f = new Frame("Java Calculator");
        f.setSize(350, 500);
        f.setLayout(new BorderLayout(10, 10));
        f.setBackground(new Color(240, 240, 240));
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // === Display ===
        display = new TextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        f.add(display, BorderLayout.NORTH);

        // === Buttons Panel ===
        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 4, 10, 10));
        p.setBackground(new Color(220, 220, 220));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "⌫"
        };

        for (String txt : buttons) {
            Button b = new Button(txt);
            b.setFont(new Font("Arial", Font.BOLD, 22));
            b.setBackground(Color.WHITE);
            b.addActionListener(this::buttonClick);
            p.add(b);
        }

        f.add(p, BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void buttonClick(ActionEvent ae) {
        String cmd = ((Button) ae.getSource()).getLabel();

        switch (cmd) {
            case "C":
                display.setText("");
                break;
            case "⌫":
                String text = display.getText();
                if (!text.isEmpty()) {
                    display.setText(text.substring(0, text.length() - 1));
                }
                break;
            case "=":
                try {
                    String expr = display.getText();
                    double result = evaluateExpression(expr);
                    display.setText(formatResult(result));
                } catch (Exception e) {
                    display.setText("Error");
                }
                break;
            default:
                display.setText(display.getText() + cmd);
        }
    }

    private String formatResult(double result) {
        if (result == (int) result)
            return String.valueOf((int) result);
        else
            return String.valueOf(result);
    }

    // ==============================
    // Expression Evaluator (No ScriptEngine)
    // ==============================
    private double evaluateExpression(String expr) {
        if (expr.isEmpty()) return 0;

        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        char[] chars = expr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == ' ') continue;

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && (Character.isDigit(chars[i]) || chars[i] == '.')) {
                    sb.append(chars[i++]);
                }
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (isOperator(c)) {
                while (!ops.isEmpty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    private double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Divide by zero");
                return a / b;
        }
        return 0;
    }

    // ==============================
    // Main
    // ==============================
    public static void main(String[] args) {
        new guiCalc();
    }
}
