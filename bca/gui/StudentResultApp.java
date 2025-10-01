package gui;

import java.awt.*;
import java.awt.event.*;

public class StudentResultApp {

    TextField nameField, rollField;
    TextField[] marksFields = new TextField[5];
    TextArea resultArea;

    public StudentResultApp() {
        Frame frame = new Frame("Student Result Calculator");
        frame.setSize(600, 450);
        frame.setLayout(new BorderLayout(10, 10));

        // === TOP PANEL: Student Info ===
        Panel topPanel = new Panel(new GridLayout(2, 2, 10, 10));
        topPanel.add(new Label("Name:"));
        nameField = new TextField();
        topPanel.add(nameField);
        topPanel.add(new Label("Roll No:"));
        rollField = new TextField();
        topPanel.add(rollField);

        // === CENTER PANEL: Marks Input ===
        Panel marksPanel = new Panel(new GridLayout(5, 2, 10, 10));
        for (int i = 0; i < 5; i++) {
            marksPanel.add(new Label("Subject " + (i + 1) + ":"));
            marksFields[i] = new TextField();
            marksPanel.add(marksFields[i]);
        }

        // === BOTTOM PANEL: Buttons ===
        Panel btnPanel = new Panel(new FlowLayout());
        Button totalBtn = new Button("Total");
        Button percBtn = new Button("Percentage");
        Button gradeBtn = new Button("Grade");
        Button reportBtn = new Button("Report");
        Button clearBtn = new Button("Clear");

        btnPanel.add(totalBtn);
        btnPanel.add(percBtn);
        btnPanel.add(gradeBtn);
        btnPanel.add(reportBtn);
        btnPanel.add(clearBtn);

        // === RESULT AREA ===
        resultArea = new TextArea();
        resultArea.setEditable(false);

        // === Add panels to frame ===
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(marksPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.add(resultArea, BorderLayout.EAST);

        // === Event Listeners ===
        totalBtn.addActionListener(e -> calculate("total"));
        percBtn.addActionListener(e -> calculate("percentage"));
        gradeBtn.addActionListener(e -> calculate("grade"));
        reportBtn.addActionListener(e -> calculate("report"));
        clearBtn.addActionListener(e -> clearForm());

        // === Frame Settings ===
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void calculate(String mode) {
        try {
            String name = nameField.getText();
            String roll = rollField.getText();
            int total = 0;

            for (TextField tf : marksFields) {
                int marks = Integer.parseInt(tf.getText());
                if (marks < 0 || marks > 100) {
                    resultArea.setText("⚠️ Marks must be between 0–100");
                    return;
                }
                total += marks;
            }

            float perc = (total / 500.0f) * 100;
            String grade;
            if (perc >= 90) grade = "A+";
            else if (perc >= 80) grade = "A";
            else if (perc >= 70) grade = "B+";
            else if (perc >= 60) grade = "B";
            else if (perc >= 50) grade = "C";
            else grade = "F";

            switch (mode) {
                case "total":
                    resultArea.setText("Total Marks: " + total);
                    break;
                case "percentage":
                    resultArea.setText("Percentage: " + perc + "%");
                    break;
                case "grade":
                    resultArea.setText("Grade: " + grade);
                    break;
                case "report":
                    resultArea.setText(
                            "📋 Report for " + name + " (Roll: " + roll + ")\n" +
                            "Total: " + total + "\n" +
                            "Percentage: " + perc + "%\n" +
                            "Grade: " + grade);
                    break;
            }

        } catch (Exception ex) {
            resultArea.setText("⚠️ Please enter valid numeric marks!");
        }
    }

    private void clearForm() {
        nameField.setText("");
        rollField.setText("");
        for (TextField tf : marksFields) tf.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        new StudentResultApp();
    }
}
