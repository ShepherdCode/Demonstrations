import java.awt.*;
import javax.swing.JFrame;
public class GUI {
    JFrame frame1; // instance variable
    MyCanvas canvas1;
    MyButtons buttons;
    MyMenu menu1;
    public GUI()    {
        frame1 = new JFrame();
        canvas1 = new MyCanvas();
        buttons = new MyButtons(this);
        menu1 = new MyMenu(this);
    }
    public void go () {
        frame1.setLayout(new FlowLayout());
        canvas1.setSize(200,200);
        canvas1.setBackground(Color.GREEN);
        frame1.setMenuBar(menu1);
        frame1.add(canvas1);
        frame1.add(buttons);
        frame1.pack();
        frame1.setVisible(true);        
    }
    public void setColor (Color dotColor) {
        canvas1.setColor (dotColor);
        canvas1.repaint();
    }
    
    public void setBackground (Color c) {
        canvas1.setBackground(c);
    }

    public static void main () {
        GUI gui = new GUI (); // constructor
        gui.go();
    }
}
