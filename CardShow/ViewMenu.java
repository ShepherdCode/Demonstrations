import java.awt.*;
import java.awt.event.*;
public class ViewMenu 
extends MenuBar 

/**
 * Manage the menu portion of the graphical user interface.
 */
implements ActionListener {
    //MenuBar menuBar;
    Menu backMenu;
    MenuItem backColor1;
    MenuItem backColor2;
    MenuItem backColor3;
    View gui;
    public ViewMenu (View gui) {
        this.gui=gui; 
        backMenu=new Menu("Table");  
        backColor1=new MenuItem("White");  
        backColor2=new MenuItem("Black");  
        backColor3=new MenuItem("Green");  
        backMenu.add(backColor1);  
        backMenu.add(backColor2);  
        backMenu.add(backColor3);  
        this.add(backMenu); 
        
        backColor1.addActionListener(this);
        backColor2.addActionListener(this);
        backColor3.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backColor1) {
            gui.setBackground(Color.WHITE);
        } else if (e.getSource()==backColor2) {
            gui.setBackground(Color.BLACK);
        } else if (e.getSource()==backColor3) {
            gui.setBackground(null);  // default
        }
    }
}

