package gui;

import java.awt.*;

public class awtl {
   
    public  awtl() {
    
    Frame frame = new Frame("First GUI");
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setLayout(null);
    frame.setBackground(Color.cyan);
    frame.setForeground(Color.red);
    frame.setResizable(false);
    frame.setLocation(200, 200);
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
    frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    frame.setFont(new Font("Arial", Font.BOLD, 20));
    frame.setTitle("My First GUI Application");
    frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            System.exit(0);
        }
    });    
    }

      public static void main(String[] args) {
        awtl obj = new awtl();

    }
}