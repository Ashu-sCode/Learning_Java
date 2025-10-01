package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentResultFX extends Application {

    TextField nameField, rollField;
    TextField[] marksFields = new TextField[5];
    TextArea resultArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Student Result Calculator (JavaFX)");

        // === Top Pane: Name & Roll ===
        GridPane topPane = new GridPane();
        topPane.setHgap(10);
        topPane.setVgap(10);
        topPane.setPadding(new Insets(10));

        topPane.add(new Label("Name:"), 0, 0);
        nameField = new TextField();
        topPane.add(nameField, 1, 0);

        topPane.add(new Label("Roll No:"), 0, 1);
        rollField = new TextField();
        topPane.add(rollField, 1, 1);

        // === Center Pane: Marks ===
        GridPane marksPane = new GridPane();
        marksPane.setHgap(10);
        marksPane.setVgap(10);
        marksPane.setPadding(new Insets(10));

        for (int i = 0; i < 5; i++) {
            marksPane.add(new Label("Subject " + (i + 1) + ":"), 0, i);
            marksFields[i] = new TextField();
            marksPane.add(marksFields[i], 1, i);
        }

        // === Button Pane ===
        HBox btnPane = new HBox(10);
        btnPane.setPadding(new Insets(10));

        Button totalBtn = new Button("Total");
        Button percBtn = new Button("Percentage");
        Button gradeBtn = new Button("Grade");
        Button reportBtn = new Button("Report");
        Button clearBtn = new Button("Clear");

        btnPane.getChildren().addAll(totalBtn, percBtn, gradeBtn, reportBtn, clearBtn);

        // === Result Area ===
        resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(150);

        // === Layout ===
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(topPane, marksPane, btnPane, resultArea);

        // === Event Handlers ===
        totalBtn.setOnAction(e -> calculate("total"));
        percBtn.setOnAction(e -> calculate("percentage"));
        gradeBtn.setOnAction(e -> calculate("grade"));
        reportBtn.setOnAction(e -> calculate("report"));
        clearBtn.setOnAction(e -> clearForm());

        // === Scene and Stage ===
        Scene scene = new Scene(root, 450, 450);
        stage.setScene(scene);
        stage.show();
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
        nameField.clear();
        rollField.clear();
        for (TextField tf : marksFields) tf.clear();
        resultArea.clear();
    }
}
