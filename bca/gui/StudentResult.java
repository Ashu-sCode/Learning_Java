package gui;

import java.awt.*;
import java.awt.event.*;

public class StudentResult {

    public StudentResult() {

        Frame frame = new Frame("Student Result Calculator");

        frame.setSize(500, 500);
        frame.setLayout(null);

        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 50, 80, 30);
        TextField nameField = new TextField();
        nameField.setBounds(150, 50, 200, 30);

        Label rollLabel = new Label("Roll No:");
        rollLabel.setBounds(50, 90, 80, 30);
        TextField rollField = new TextField();
        rollField.setBounds(150, 90, 200, 30);

        Label marksLabel = new Label("Marks (5 Subjects):");
        marksLabel.setBounds(50, 130, 120, 30);
        TextField[] marksFields = new TextField[5];
        for (int i = 0; i < 5; i++) {

            marksFields[i] = new TextField();
            marksFields[i].setBounds(180 + (i * 50), 130, 40, 30);
            frame.add(marksFields[i]);

        }

        Button totalBtn = new Button("Total");
        totalBtn.setBounds(150, 180, 100, 30);

        Button percBtn = new Button("Percentage");
        percBtn.setBounds(270, 180, 100, 30);

        Button gdButton = new Button("Grade");
        gdButton.setBounds(390, 180, 60, 30);

        TextArea resultArea = new TextArea();
        resultArea.setBounds(50, 230, 400, 120);

        // Action Listeners

        // total
        totalBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    String name = nameField.getText();
                    String roll = rollField.getText();
                    int total = 0;
                    for (TextField tf : marksFields) {

                        total += Integer.parseInt(tf.getText());

                    }

                    resultArea.setText("Total Marks for " + name + " Roll No: " + roll + "\n"
                            + " is " + total + "\n"

                    );

                } catch (Exception ex) {

                    resultArea.setText("Please enter valid marks!");

                }

            }

        });

        // percentage
        percBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    String name = nameField.getText();
                    String roll = rollField.getText();
                    int total = 0;
                    for (TextField tf : marksFields) {

                        total += Integer.parseInt(tf.getText());

                    }
                    float perc = (total / 500.0f) * 100;
                    resultArea.setText("Percentage for " + name + "Roll No: " + roll + "\n"
                            + " is " + perc + "\n"

                    );

                } catch (Exception ex) {

                    resultArea.setText("Please enter valid marks!");

                }

            }

        });

        // grade
        gdButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    String name = nameField.getText();
                    String roll = rollField.getText();
                    int total = 0;
                    for (TextField tf : marksFields) {

                        total += Integer.parseInt(tf.getText());

                    }
                    float perc = (total / 500.0f) * 100;
                    String grade;
                    if (perc >= 90) {
                        grade = "A+";
                    } else if (perc >= 80) {
                        grade = "A";
                    } else if (perc >= 70) {
                        grade = "B+";
                    } else if (perc >= 60) {
                        grade = "B";
                    } else if (perc >= 50) {
                        grade = "C";
                    } else {
                        grade = "F";
                    }
                    resultArea.setText("Grade for " + name + "Roll No: " + roll + "\n"
                            + " is " + grade + "\n"

                    );

                } catch (Exception ex) {

                    resultArea.setText("Please enter valid marks!");

                }

            }

        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollLabel);
        frame.add(rollField);
        frame.add(marksLabel);
        frame.add(totalBtn);
        frame.add(percBtn);
        frame.add(gdButton);
        frame.add(resultArea);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }

        });

    }

    public static void main(String[] args) {

        new StudentResult();

    }

}