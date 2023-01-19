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
        // TO DO: FIX THIS
        //int i = gui.getCardIndex();
        //Card card = new Card(i, null);
        //String s = String.format("Card: %2s", card);
        //text.setText(s);
        text.setText("to do");
    }
}
