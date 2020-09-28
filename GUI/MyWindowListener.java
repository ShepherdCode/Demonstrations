import java.awt.*;
import java.awt.event.*;
public class MyWindowListener 
implements WindowListener {
    Frame frame;
    
    public MyWindowListener (Frame frame) {
        this.frame=frame;
    }
    
    // The following methods are required 
    // to implement WindowListener.
    
    public void windowClosing(WindowEvent e) {  
        frame.dispose();  
    }  

    public void windowActivated(WindowEvent e) {}  

    public void windowClosed(WindowEvent e) {}  

    public void windowDeactivated(WindowEvent e) {}  

    public void windowDeiconified(WindowEvent e) {}  

    public void windowIconified(WindowEvent e) {}  

    public void windowOpened(WindowEvent arg0) {}  

}
