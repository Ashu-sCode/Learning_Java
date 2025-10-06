import java.awt.*;
import java.awt.event.*;

public class guiCalc{
    void guiCalc(){
        Frame f = new Frame("Calculator");
        f.setSize(400, 800);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        TextField t1 = new TextField(20);
        f.add(t1);  
        Button b1 = new Button("+");
        f.add(b1);
        Button b2 = new Button("-");
        f.add(b2);
        Button b3 = new Button("*");
        f.add(b3);
        Button b4 = new Button("/");
        f.add(b4);
        f.setBackground(Color.cyan);
        f.setFont(new Font("Arial", Font.PLAIN, 20));
        f.setForeground(Color.red);
        f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      
        f.setResizable(false);
        f.setLocation(200, 200);
        f.setState(Frame.NORMAL);
        f.setAlwaysOnTop(true);
        f.validate();
        f.repaint();


    }

    public static void main(String[] args) {
        new guiCalc().guiCalc();
    }
}