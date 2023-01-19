import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Draw two piles of cards on a card table background.
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

    public ViewCanvas (CardView cardView) {
        this.cardView = cardView;
        this.cardBack = cardView.getImage(0);
        this.cardWidth = cardBack.getWidth(null);
        this.cardHeight = cardBack.getHeight(null);
        this.setState(0,0,0,0);
        this.setBackground (this.CARD_TABLE_GREEN);
    }

    /**
     * Determine what the canvas will draw.
     * @param dealerTop Card atop the dealer pile.
     * @param playerTop Card atop the player pile.
     * @param dealerCards Number of cards in dealer pile.
     * @param playerCards Number of cards in player pile.
     */
    public void setState (int dealerTop, 
    int playerTop,
    int dealerCards, int playerCards) {
        this.dealerTop = dealerTop;
        this.playerTop = playerTop;
        this.dealerCards = dealerCards;
        this.playerCards = playerCards;
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

