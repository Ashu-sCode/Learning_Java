package gui;

import java.awt.*;
import java.awt.event.*;

public class LoginApp {

    // Constructor to build GUI
    public LoginApp() {
        // Create Frame (window)
        Frame frame = new Frame("Login App");

        // Create Labels
        Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 80, 80, 30);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 130, 80, 30);

        // Create TextFields
        TextField userText = new TextField();
        userText.setBounds(150, 80, 150, 30);

        TextField passText = new TextField();
        passText.setBounds(150, 130, 150, 30);
        passText.setEchoChar('*'); // hide password input

        // Create Button
        Button loginBtn = new Button("Login");
        loginBtn.setBounds(150, 180, 80, 30);

        // Create Label for result
        Label resultLabel = new Label("");
        resultLabel.setBounds(50, 230, 250, 30);

        // Add ActionListener to button
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = passText.getText();

                if (username.equals("admin") && password.equals("1234")) {
                    resultLabel.setText("✅ Login Successful!");
                } else {
                    resultLabel.setText("❌ Invalid Credentials");
                }
            }
        });

        // Add components to frame
        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userText);
        frame.add(passText);
        frame.add(loginBtn);
        frame.add(resultLabel);

        // Frame properties
        frame.setSize(400, 300);
        frame.setLayout(null); // absolute positioning
        frame.setVisible(true);

        // Close window properly
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new LoginApp(); // Run the app
    }
}
