import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Draws two piles of cards on a card table background.
 */

public class ViewCanvas 
extends Canvas {
    Color CARD_TABLE_GREEN = new Color(0x088A4B);
    Image cardBack;
    CardView cardView;
    int dealerTop;
    int playerTop;
    int dealerCards;
    int playerCards;
    int cardWidth;
    int cardHeight;

    /**
     * Constructor.
     * @param Object describing how to draw a card.
     */
    public ViewCanvas (CardView cardView) {
        this.cardView = cardView;
        this.cardBack = cardView.getImage(0);
        this.cardWidth = cardBack.getWidth(null);
        this.cardHeight = cardBack.getHeight(null);
        this.setBackground (this.CARD_TABLE_GREEN);
    }

    /**
     * Describe the card piles.
     * This determines what the canvas will draw.
     * @param Object describing current game state.
     */
    public void setState (Status s) {
        this.dealerTop = s.dealerTop;
        this.playerTop = s.playerTop;
        this.dealerCards = s.dealerHeight;
        this.playerCards = s.playerHeight;
    }

    @Override
    public void setBackground (Color c) {
        if (c==null) {
            c=this.CARD_TABLE_GREEN;
        }
        super.setBackground(c);
    }

    @Override
    public void paint(Graphics g) {
        int TOP = 10; // pixels from canvas top to card top
        int BETWEEN = 15; // pizels between card piles
        int SHIFT = 2; // pixels between 1st and 2nd card in pile
        int x = BETWEEN;
        int y = TOP;
        if (dealerTop != Model.NO_CARD) {
            if (dealerCards > 1) {
                g.drawImage(cardBack, x, y, null);
                x+=SHIFT;
                y+=SHIFT;
            }
            g.drawImage(cardBack, x, y, null);
        }
        x = BETWEEN + cardWidth + BETWEEN;
        y = TOP;
        if (playerTop != Model.NO_CARD) {
            Image img = cardView.getImage(playerTop);
            if (playerCards > 1) {
                g.drawImage(img, x, y, null);
                x+=SHIFT;
                y+=SHIFT;
            }
            g.drawImage(img, x, y, null);
        }
    }
}

