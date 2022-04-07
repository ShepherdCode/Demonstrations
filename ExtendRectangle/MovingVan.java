import java.awt.Color;

/**
 * Demonstrate the use of ColorfulRectangle.
 */
public class MovingVan {
    private int x;
    private ColorfulRectangle trailer;

    public MovingVan()    {
        trailer = new ColorfulRectangle();
    }

    public String toString ()    {
        return "MovingVan("+trailer+")";
    }
    
    public void setCoords (int x, int y, int w, int h) {
        trailer.move(x,y);
        trailer.setSize(w,h);
    }
    
    public void setColor (Color c) {
        // this is a pass-thru method
        trailer.setColor(c);
    }
    
    public static void main () {
        MovingVan mv = new MovingVan();
        System.out.println("The original moving van: "+mv);
        mv.setCoords (3,4, 20,10);
        mv.setColor (Color.BLUE);
        System.out.println("The modified moving van: "+mv);
    }
}
