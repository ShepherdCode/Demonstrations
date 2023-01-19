import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 * Manage the graphical user interface.
 * Use sees a menu, buttons, and cards drawn on a canvas.
 */
public class View 
implements ActionListener {
    JFrame frame1; // instance variable
    ViewCanvas canvas;
    CardView cardView;
    TextField text;    
    ViewMenu menu1;
    Model model;
    Button button1,button2;
    public int CANVAS_SIZE_HORIZONTAL = 200;
    public int CANVAS_SIZE_VERTICAL = 200;
    
    public View()    {
        this.model = new Model();
        frame1 = new JFrame();
        cardView = new CardView();
        canvas = new ViewCanvas(cardView);
        canvas.setState(model.getDealerTop(),
            model.getPlayerTop(),
            model.getDealerHeight(),
            model.getPlayerHeight());
        button1 = new Button("BACK");
        button2 = new Button("DEAL");
        button1.addActionListener(this);
        button2.addActionListener(this);
        menu1 = new ViewMenu(this);
        text = new TextField("   ");
    }

    /**
     * After constructor runs,
     * call this to make the user interface visible.
     */
    public void go () {
        frame1.setLayout(new FlowLayout());
        canvas.setSize(CANVAS_SIZE_HORIZONTAL,CANVAS_SIZE_VERTICAL);
        frame1.setMenuBar(menu1);
        frame1.add(canvas);
        frame1.add(button1);
        frame1.add(button2);
        frame1.add(text);
        frame1.pack();
        frame1.setVisible(true);        
    }

    void dealCard() {
        model.dealCard();
        canvas.setState(model.getDealerTop(),
            model.getPlayerTop(),
            model.getDealerHeight(),
            model.getPlayerHeight());
        canvas.repaint();
        sayCard();
    }

    void returnCard() {
        model.returnCard();
        canvas.setState(model.getDealerTop(),
            model.getPlayerTop(),
            model.getDealerHeight(),
            model.getPlayerHeight());
        canvas.repaint();
        sayCard();
    }

    void sayCard () {
        int cardNum = model.getPlayerTop();
        String show = cardView.getShortName(cardNum).toUpperCase();
        text.setText(show);
    }

    public void setBackground (Color c) {
        canvas.setBackground(c);
    }

    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == button1) {
            returnCard();
        } else if (e.getSource() == button2) {
            dealCard();
        } else {
            System.err.println("WARNING: Action from unknown source.");
        }
    }

}
