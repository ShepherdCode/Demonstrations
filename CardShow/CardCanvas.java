import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class CardCanvas 
extends Canvas {
    Color cardTableGreen;
    ArrayList<Card> cards;
    int cardWidth, cardHeight;
    int currentCard;
    int minCard;
    int maxCard;
    
    public CardCanvas () {
        setBackground (null);
        minCard = 1;
        maxCard = 52;
        currentCard = minCard - 1;
        cards = new ArrayList<Card>(100);
        setup();
    }
    
    @Override
    public void setBackground (Color c) {
        if (c==null) {
            c=new Color(0x088A4B); // card table green
        }
        super.setBackground(c);
    }
    
    public void dealCard () {
        if (currentCard < maxCard) {
            currentCard++;
            repaint();
        }
        //System.out.println(currentCard);
    }
    
    public void returnCard () {
        if (currentCard >= minCard) {
            currentCard--;
            repaint();
        }
        //System.out.println(currentCard);
    }
    
    public int getCardIndex() {
        return currentCard;
    }
    
    void setup () {
        String cardset = "cardset-oxymoron";
        String suits = "shdc";
        String s; 
        Image i;
        for (int c=0; c<=52; c++) {
            if (c==0) {
                s=String.format("%s/%s.gif",
                    cardset, "back101");
                i = new ImageIcon(s).getImage();
                cardWidth = i.getWidth(null);
                cardHeight = i.getHeight(null);
            } else {
                int rank=(c-1)%13 + 1;
                char suit = suits.charAt((c-1)/13);
                s = String.format("%s/%02d%c.gif",
                    cardset, rank, suit);
                i = new ImageIcon(s).getImage();
            }
            Card card = new Card(c,i);
            cards.add(card);
        }
     }
    
    @Override
    public void paint(Graphics g) {
        int x = 15;
        int y = 10;
        Image i;
        Card c;
        if (currentCard < maxCard) {
            c = cards.get(0);
            i = c.getImage();
            g.drawImage(i, x, y, null);
        }
        x += cardWidth + 15;
        y = 20;
        if (currentCard >= minCard && currentCard <= maxCard) {
            c = cards.get(currentCard);
            i = c.getImage();
            g.drawImage(i, x, y, null);
        }
    }
}
