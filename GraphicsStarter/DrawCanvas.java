import java.awt.*;
public class DrawCanvas extends Canvas {
    // When AWT draws a Canvas, it calls Canvas.paint()
    // and passes in the Graphics context for drawing.
    @Override 
    public void paint (Graphics g) { 
        //g.setColor(Color.YELLOW);
        //g.fillRect(100, 100, 200, 200);
        //g.setColor(Color.BLUE);
        //g.drawRect(50,50,100,200);
        //g.setColor(Color.RED);
        //drawCenterPoint(g);
    } 
    public void drawCenterPoint (Graphics g) {
        Rectangle r = new Rectangle(this.getBounds());
        int radius = 3;
        int diameter = 2 * radius;
        int x = r.x + r.width/2 - radius;
        int y = r.y + r.height/2 - radius;
        g.fillOval(x,y,diameter,diameter);
    }
}