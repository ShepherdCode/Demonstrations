import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ViewCanvas 
extends Canvas {
    Color cardTableGreen;
    Image cardBack;
    int dealerTop;
    int playerTop;
    int cardWidth;
    int cardHeight;
    final int NO_CARD = 0;

    public ViewCanvas () {
        this.setState(NO_CARD,NO_CARD);
        this.cardTableGreen=new Color(0x088A4B); 
        this.setBackground (this.cardTableGreen);
        this.cardBack = getImage(0);
        this.cardWidth = cardBack.getWidth(null);
        this.cardHeight = cardBack.getHeight(null);
    }

    public void setState (int dealerTop, int playerTop) {
        this.dealerTop = dealerTop;
        this.playerTop = playerTop;
    }
    
    @Override
    public void setBackground (Color c) {
        if (c==null) {
            c=this.cardTableGreen;
        }
        super.setBackground(c);
    }

    Image getImage (int cardNum) {
        String cardset = "cardset-oxymoron";
        String suits = "shdc";
        String s; 
        Image i = null;
        if (cardNum==0) {
            s=String.format("%s/%s.gif",
                cardset, "back101");
            return new ImageIcon(s).getImage();
        } else if (cardNum>=1 && cardNum<=52) {
            int rank=(cardNum-1)%13 + 1;
            char suit = suits.charAt((cardNum-1)/13);
            s = String.format("%s/%02d%c.gif",
                cardset, rank, suit);
            return new ImageIcon(s).getImage();
        }
        System.err.println("ERROR: No image for card number "+cardNum);
        return null;
    }

    @Override
    public void paint(Graphics g) {
        int x = 15;
        int y = 10;
        if (dealerTop != NO_CARD) {
            g.drawImage(cardBack, x, y, null);
        }
        x += cardWidth + 15;
        y = 20;
        if (playerTop != NO_CARD) {
            Image img = getImage(playerTop);
            g.drawImage(img, x, y, null);
        }
    }
}

