import java.awt.*;
import java.awt.event.*;
public class MyButtons 
extends Panel 
implements ActionListener {
    Button button1, button2; // instance variables
    TextField text;
    GUI gui;
    int card;
    
    public MyButtons(GUI gui)    {
        this.gui = gui;
        text = new TextField();
        sayCard();
        button1 = new Button("BACK");
        button2 = new Button("DEAL");
        this.add(button1);
        this.add(button2);
        this.add(text);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == button1) {
            gui.returnCard();
        } else if (e.getSource() == button2) {
            gui.dealCard();
        } else {
            // unknown source
        }
        sayCard();
    }
    
    void sayCard() {
        int card = gui.getCardIndex();
        String s = String.format("Card: %02d", card);
        text.setText(s);
    }
}
