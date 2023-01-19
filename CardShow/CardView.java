import java.awt.Image;
import javax.swing.ImageIcon;

public class CardView {
    String cardset;
    String SUITS;
    String RANKS;

    public CardView () {
        cardset = "cardset-oxymoron";
        SUITS = "shdc";
        RANKS = "A23456789TJQK";
    }

    public Image getImage (int cardNum) {
        String filename = "BadCardNum";
        if (cardNum==0) {
            filename = String.format("%s/%s.gif",
                    cardset, "back101");
        } else if (cardNum>=1 && cardNum<=52) {
            int rank=(cardNum-1)%13 + 1;
            char suit = SUITS.charAt((cardNum-1)/13);
            filename = String.format("%s/%02d%c.gif",
                    cardset, rank, suit);
        }
        return new ImageIcon(filename).getImage();
    }
    
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
