import java.awt.*;
import javax.swing.JFrame;
public class View {
    JFrame frame1; // instance variable
    ViewCanvas canvas;
    CardView cardView;
    ButtonHandler buttons;
    TextField text;    
    ViewMenu menu1;
    Model model;
    int cardIndex;
    public View()    {
        this.model = new Model();
        frame1 = new JFrame();
        cardView = new CardView();
        canvas = new ViewCanvas(cardView);
        canvas.setState(model.getDealerTop(),model.getPlayerTop());
        buttons = new ButtonHandler(this);
        menu1 = new ViewMenu(this);
        text = new TextField("   ");
        cardIndex = 0;
    }
    public void go () {
        frame1.setLayout(new FlowLayout());
        canvas.setSize(200,200);
        //canvas1.setBackground(Color.GREEN);
        frame1.setMenuBar(menu1);
        frame1.add(canvas);
        frame1.add(buttons);
        frame1.add(text);
        frame1.pack();
        sayCard();
        frame1.setVisible(true);        
    }
    
    public void dealCard() {
        model.dealCard();
        canvas.setState(model.getDealerTop(),model.getPlayerTop());
        canvas.repaint();
        sayCard();
    }
    
    public void returnCard() {
        model.returnCard();
        canvas.setState(model.getDealerTop(),model.getPlayerTop());
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
    
}
