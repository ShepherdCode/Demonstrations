import java.awt.*;
public class DrawCanvas extends Canvas {
    Point ballCoord;
    int BALLSIZE;
    Color ballColor;
    int horizontal_direction = +1;
    int vertical_direction = +1;
    
    public DrawCanvas () {
        ballCoord = new Point(0,0);
        BALLSIZE = 20;
        ballColor = new Color(0,0,255);
    }
    
    public void pushBall(int pixels) {
        double x = ballCoord.x;
        double y = ballCoord.y;
        if (x<0 || x+BALLSIZE>this.getWidth()) {
            horizontal_direction *= (-1);
        }
        if (y<0 || y+BALLSIZE>this.getHeight()) {
            vertical_direction *= (-1);
        }
        int horizontal_move = pixels*horizontal_direction;
        int vertical_move = pixels*vertical_direction;
        ballCoord.translate(horizontal_move,vertical_move);
    }
    
    @Override 
    public void paint (Graphics g) { 
        g.setColor(ballColor);
        int x = ballCoord.x;
        int y = ballCoord.y;
        int w = BALLSIZE;
        int h = BALLSIZE;
        g.fillOval(x,y,w,h);
    } 

}