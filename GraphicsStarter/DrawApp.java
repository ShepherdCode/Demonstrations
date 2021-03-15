import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
public class DrawApp {
    JFrame frame;
    String appName;
    DrawCanvas canvas;

    public DrawApp (String appName) {
        this.appName = appName;
        frame= new JFrame(appName); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.red);
        Label label = new Label("Art");
        label.setBackground(Color.cyan);
        frame.add(label);
        canvas = new DrawCanvas();
        canvas.setBackground(Color.white);
        frame.add(canvas);
    }

    public void display(int width, int height) {
        canvas.setSize(width,height);
        frame.pack(); // pack frame around canvas
        frame.setVisible(true); 
    }

    public static void main () {
        int width = 400;
        int height = 400;
        String title = "CIS 211 App";
        DrawApp app = new DrawApp(title);
        app.display(width,height);
    }
}
