package gui;

import java.awt.*;
import java.awt.event.*;

public class Login {

    public Login() {
        Frame frame = new Frame("Login App");

        frame.setSize(400, 300);
        frame.setLayout(null); // absolute positioning
        frame.setVisible(true);

        Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 80, 80, 30);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 130, 80, 30);

        TextField userText = new TextField();
        userText.setBounds(150, 80, 150, 30);
        TextField passText = new TextField();
        passText.setBounds(150, 130, 150, 30);
        passText.setEchoChar('*'); // hide password input
        Button loginBtn = new Button("Login");
        loginBtn.setBounds(150, 180, 80, 30);
        Label resultLabel = new Label("");
        resultLabel.setBounds(50, 230, 250, 30);

        ActionListener loginAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = passText.getText();

                if (username.equals("admin") && password.equals("1234")) {
                    resultLabel.setText("✅ Login Successful!");
                } else {
                    resultLabel.setText("❌ Invalid Credentials");
                }
            }
        };

        loginBtn.addActionListener(loginAction);
        passText.addActionListener(loginAction); 

        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userText);
        frame.add(passText);
        frame.add(loginBtn);
        frame.add(resultLabel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new Login();

    }

}
