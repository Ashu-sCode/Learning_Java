package gui;

import java.awt.*;

public class frame2 extends Frame {


    public frame2() {
        setTitle("Second GUI");
        setSize(400, 400);
        setVisible(true);
        Button button = new Button("Click Me");
        button.setBounds(30, 100, 80, 30);
        add(button);

        setLayout(null);
        

    }

    public static void main(String[] args) {
        
        frame2 obj = new frame2();

    }

}

