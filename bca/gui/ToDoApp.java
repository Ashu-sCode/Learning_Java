package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp {

    private java.util.List<String> tasks = new ArrayList<>();
    private List taskList; // AWT List to display tasks

    public ToDoApp() {

        Frame frame = new Frame("ToDo List");
        frame.setSize(500, 500);
        frame.setLayout(null);

        Label nameLabel = new Label("Task:");
        nameLabel.setBounds(50, 50, 80, 30);

        TextField nameField = new TextField();
        nameField.setBounds(150, 50, 200, 30);

        Button addTask = new Button("Add Task");
        addTask.setBounds(150, 100, 100, 30);

        Button delTask = new Button("Remove Task");
        delTask.setBounds(270, 100, 100, 30);

        Button markDone = new Button("Mark Done");
        markDone.setBounds(390, 100, 80, 30);

        // List component to display tasks
        taskList = new List();
        taskList.setBounds(50, 150, 400, 250);

        // Action Listeners

        // Add task
        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = nameField.getText().trim();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    taskList.add(task);
                    nameField.setText("");
                } else {
                    taskList.add("⚠️ Please enter a task!");
                }
            }
        });

        // Remove selected task
        delTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index >= 0) {
                    tasks.remove(index);
                    taskList.remove(index);
                }
            }
        });

        // Mark task as done
        markDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index >= 0) {
                    String task = tasks.get(index);
                    if (!task.startsWith("✔️")) {
                        task = "✔️ " + task; // add check mark
                        tasks.set(index, task);
                        taskList.replaceItem(task, index);
                    }
                }
            }
        });

        // Add components to frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(addTask);
        frame.add(delTask);
        frame.add(markDone);
        frame.add(taskList);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
