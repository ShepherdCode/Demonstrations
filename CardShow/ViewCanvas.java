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
    CardView cardView;
    int dealerTop;
    int playerTop;
    int dealerCards;
    int playerCards;
    int cardWidth;
    int cardHeight;

    public ViewCanvas (CardView cardView) {
        this.cardView = cardView;
        this.cardBack = cardView.getImage(0);
        this.cardWidth = cardBack.getWidth(null);
        this.cardHeight = cardBack.getHeight(null);
        this.setState(0,0,0,0);
        this.cardTableGreen=new Color(0x088A4B); 
        this.setBackground (this.cardTableGreen);
    }

    public void setState (int dealerTop, int playerTop,
    int dealerCards, int playerCards) {
        this.dealerTop = dealerTop;
        this.playerTop = playerTop;
        this.dealerCards = dealerCards;
        this.playerCards = playerCards;
    }
    
    @Override
    public void setBackground (Color c) {
        if (c==null) {
            c=this.cardTableGreen;
        }
        super.setBackground(c);
    }

    @Override
    public void paint(Graphics g) {
        int LEFT = 15;
        int TOP = 10;
        int BETWEEN = 15;
        int x = LEFT;
        int y = TOP;
        if (dealerTop != 0) {
            if (dealerCards > 1) {
                g.drawImage(cardBack, x, y, null);
                x+=1;
                y+=1;
            }
            g.drawImage(cardBack, x, y, null);
        }
        x = LEFT + cardWidth + BETWEEN;
        y = LEFT;
        if (playerTop != 0) {
            Image img = cardView.getImage(playerTop);
            if (playerCards > 1) {
                g.drawImage(img, x, y, null);
                x+=1;
                y+=1;
            }
            g.drawImage(img, x, y, null);
        }
    }
}

