import java.awt.Rectangle;
import java.awt.Color;

/**
 * ColorfulRectangle
 * is-a java.awt.Rectange plus a java.awt.Color
 * The setter method makes this mutable. 
 */
public class ColorfulRectangle extends Rectangle {
    private Color color;

    public ColorfulRectangle()    {
        color = Color.BLACK;  // default
    }

    public void setColor (Color c)    {
        this.color = c; // setter
    }
    
    public String toString () {
        // show my color plus the Rectangle super class
        return super.toString() + " " + this.color;
    }
}
