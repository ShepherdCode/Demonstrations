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
        Label label = new Label("Java Movie");
        label.setBackground(Color.yellow);
        frame.add(label);
        canvas = new DrawCanvas();
        canvas.setBackground(Color.white);
        frame.add(canvas);
    }
    
    public DrawCanvas getCanvas() {
        return canvas;
    }

    public void display(int width, int height) {
        canvas.setSize(width,height);
        frame.pack(); // pack frame around canvas
        frame.setVisible(true);
    }

    public static void main () {
        int width = 400;
        int height = 300;
        String title = "Bouncy Ball";
        DrawApp app = new DrawApp(title);
        app.display(width,height);
        DrawAction action = new DrawAction(app.getCanvas());
        action.start();
    }
}
