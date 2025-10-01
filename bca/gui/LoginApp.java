import java.awt.*;
import java.awt.event.*;

public class LoginApp extends Frame implements ActionListener {
    TextField username, password;
    Button loginBtn;

    LoginApp() {
        // Frame settings
        setLayout(new FlowLayout());
        setSize(300, 200);
        setTitle("Login App");

        // Username field
        Label userLabel = new Label("Username:");
        username = new TextField(15);

        // Password field
        Label passLabel = new Label("Password:");
        password = new TextField(15);
        password.setEchoChar('*');

        // Login button
        loginBtn = new Button("Login");

        // Add components
        add(userLabel);
        add(username);
        add(passLabel);
        add(password);
        add(loginBtn);

        // Action Listener for Login button
        loginBtn.addActionListener(this);

        // Trigger login when ENTER is pressed in password field
        password.addActionListener(this);

        setVisible(true);

        // Window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // When login is triggered
    public void actionPerformed(ActionEvent e) {
        String user = username.getText();
        String pass = password.getText();

        if (user.equals("admin") && pass.equals("123")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Credentials!");
        }
    }

    public static void main(String[] args) {
        new LoginApp();
    }
}
