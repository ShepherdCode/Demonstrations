import java.awt.*;
import java.awt.event.*;
public class Listener 
implements ActionListener {
    Object stopButton;
    Object startButton;
    Control control;
    public Listener ( Control c ) {
        this.control = c;
    }

    public void setStarter (Object o) {
        this.startButton = o;
    }

    public void setStopper (Object o) {
        this.stopButton = o;
    }

    public void actionPerformed (ActionEvent e) {
        Object source = e.getSource();
        if (source == stopButton) {
            System.out.println("Button pressed: Stop");
            control.stop();
        } else if (source == startButton) {
            System.out.println("Button pressed: Start");
            control.go();
        }
    }


}