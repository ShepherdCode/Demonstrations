import java.awt.*;
import java.awt.event.*;
public class MyMenu 
extends MenuBar 
implements ActionListener {
    //MenuBar menuBar;
    Menu backMenu;
    MenuItem backColor1;
    MenuItem backColor2;
    GUI gui;
    public MyMenu (GUI gui) {
        this.gui=gui; 
        backMenu=new Menu("Background");  
        backColor1=new MenuItem("White");  
        backColor2=new MenuItem("Yellow");  
        backMenu.add(backColor1);  
        backMenu.add(backColor2);  
        this.add(backMenu); 
        
        backColor1.addActionListener(this);
        backColor2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backColor1) {
            gui.setBackground(Color.WHITE);
        } else if (e.getSource()==backColor2) {
            gui.setBackground(Color.YELLOW);
        }
    }
}

