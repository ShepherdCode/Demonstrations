import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

public class MyCanvas 
extends Canvas {
    Color dotColor;
    
    public void setColor (Color dotColor) {
        this.dotColor = dotColor;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(dotColor);
        g.drawOval(50,50,100,100);
    }
}
