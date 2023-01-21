import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Knows how to draw individual cards.
 */
public class CardView {
    String CARDSET = "cardset-oxymoron";
    String SUITS;
    String RANKS;

    public CardView () {
        SUITS = "shdc";
        RANKS = "A23456789TJQK";
    }

    /**
     * Generate an image to represent one card face.
     * An image of the card back is returned for number zero.
     * @param cardNum Between 1 and 52 for most card games.
     */
    public Image getImage (int cardNum) {
        // Crashes if parameter is bad number, such as 53.
        String filename = "BadCardNum"; 
        // The image files in our cardset
        // have names like 13h.gif for king-of-hearts.
        if (cardNum==0) {
            filename = String.format("%s/%s.gif",
                    CARDSET, "back101");
        } else if (cardNum>=1 && cardNum<=52) {
            int rank=(cardNum-1)%13 + 1;
            char suit = SUITS.charAt((cardNum-1)/13);
            filename = String.format("%s/%02d%c.gif",
                    CARDSET, rank, suit);
        }
        return new ImageIcon(filename).getImage();
    }
    
    /**
     * Generate a short string to represent one card face.
     * @param cardNum Between 1 and 52 for most card games.
     * @return A 2-letter string like 'TH' for ten-of-hearts.
     */
    public String getShortName (int cardNum) {
        String name = "--";
        if (cardNum>0) {
            char suit = SUITS.charAt((cardNum-1)/13);
            char rank = RANKS.charAt((cardNum-1)%13);
            name = "" + rank + suit;
        }
        return name;
    }
}
