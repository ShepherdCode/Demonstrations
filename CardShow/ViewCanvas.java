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
    int cardWidth;
    int cardHeight;
    final int NO_CARD = 0;

    public ViewCanvas (CardView cardView) {
        this.cardView = cardView;
        this.cardBack = cardView.getImage(0);
        this.cardWidth = cardBack.getWidth(null);
        this.cardHeight = cardBack.getHeight(null);
        this.setState(NO_CARD,NO_CARD);
        this.cardTableGreen=new Color(0x088A4B); 
        this.setBackground (this.cardTableGreen);
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
            Image img = cardView.getImage(playerTop);
            g.drawImage(img, x, y, null);
        }
    }
}

