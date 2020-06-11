import java.awt.*;
/**
 * GameView is a canvas containing a matrix of rectangles.
 * Every rectangle has a position.
 * Rectangles do not overlap.
 * Every rectangle has a state: on or off.
 * When the canvas paints, rectangles are colored by their state.
 */
public class GameView extends Canvas {
    public final static int PIXEL_SIZE = 10;
    Rectangle [][] arrayOfRect;
    Color liveColor, deadColor;
    int rows, cols;
    GameModel model;

    public GameView (GameModel model) {
        this.liveColor = Color.blue;
        this.deadColor = Color.white;
        this.model = model;
        this.rows = model.getNumRows();
        this.cols = model.getNumCols();
        // Call the setSize() method on my parent, the Canvas.
        setSize(rows*PIXEL_SIZE, cols*PIXEL_SIZE); 
        setup();
    }

    void setup() {
        int r,c, x,y, width,height;
        width = PIXEL_SIZE-1; 
        height = PIXEL_SIZE-1; 
        this.arrayOfRect = new Rectangle [rows] [cols];
        for (r=0; r<rows; r++) {
            for (c=0; c<cols; c++) {
                x = c*PIXEL_SIZE;
                y = r*PIXEL_SIZE;
                Rectangle rec = new Rectangle (x,y,width,height);
                arrayOfRect[r][c] = rec;
            }
        }
    }

    public Rectangle getRect (int row, int col) {
        return arrayOfRect [ row ] [ col ];
    }

    public void paint (Graphics g) {
        int r,c;
        Rectangle rec;
        boolean state;
        for (r=0; r<rows; r++) {
            for (c=0; c<cols; c++) {
                rec = getRect (r,c);
                state = model.getCurrentStateOfCell (r,c);
                if (state) {
                    g.setColor(liveColor);
                } else {
                    g.setColor(deadColor);
                }
                g.fillRect(rec.x, rec.y, rec.width, rec.height);
            }
        }
    }

    /** 
     * Find the cell of the matrix that intersects the given point.
     * The Point is a canvas position specified by a MouseEvent.
     * The return value indicates row & column of a cell in the grid.
     * The return type is Point just to encapsulate the row and column numbers.
     * @param p A point designating a pixel on the canvas.
     * @return A point designating a cell in the grid.
     */
    public Point findCellAtPoint (Point p) {
        int r,c;
        for (r=0; r<rows; r++) {
            for (c=0; c<cols; c++) {
                if (getRect(r,c).contains(p)) {
                    return new Point (r,c);
                }
            }
        }
        return null;
    }
}

