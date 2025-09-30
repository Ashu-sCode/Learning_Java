package gui;

import java.awt.*;
import java.awt.event.*;


public class first {
    public static void main(String[] args) {
        
        Frame frame = new Frame("First GUI");

        Button button = new Button("Click Me");
        button.setBounds(100, 100, 80, 30);

        frame.add(button);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {

            int click;
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
                click++;
                button.setLabel("Clicked " + click + " times");
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });



    }

  

}
