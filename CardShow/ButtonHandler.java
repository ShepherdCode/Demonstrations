import java.awt.*;
import java.awt.event.*;
public class ButtonHandler 
extends Panel 
implements ActionListener {
    Button button1, button2; // instance variables
    TextField text;
    View gui;
    int card;
    
    public ButtonHandler(View gui)    {
        this.gui = gui;
        button1 = new Button("BACK");
        button2 = new Button("DEAL");
        this.add(button1);
        this.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == button1) {
            gui.returnCard();
        } else if (e.getSource() == button2) {
            gui.dealCard();
        } else {
            System.err.println("WARNING: Action from unknown source.");
        }
    }
    
}
