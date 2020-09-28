import java.awt.*;
public class MyCanvas extends Canvas {
    public MyCanvas () {
        setSize(400,300);
        setBackground(Color.WHITE);
    }
    public void paint (Graphics g) {
        System.out.println("paiting");
        g.setColor(Color.RED);
        g.drawLine(10,20,200,100);
        g.setColor(Color.BLUE);
        g.drawOval(50,50,100,100);
    }
}
