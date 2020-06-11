import java.awt.event.*;
import java.awt.*;
/**
 * GridListener responds to mouse clicks on the grid.
 * If the mouse click hits a rectangle on the grid,
 * then tell the grid to toggle that rectangle.
 */
public class GridListener extends MouseAdapter implements ActionListener{
    GameController master;
    public GridListener (GameController master) {
        this.master = master;
    }
    public void mouseClicked(MouseEvent me)    {
        Point p = me.getPoint();
        master.handleMouseClick(p);
    }
    public void actionPerformed (ActionEvent e) {
        Object src = e.getSource();
        master.handleButtonPress (src);
    }
}