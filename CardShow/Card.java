import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {
    int card;
    Image image;
    static final char[] ranks = {'S','H','D','C'};
    static final char[] suits = {'A','1','2','3','4','5',
        '6','7','8','9','T','J','Q','K'};
    String twoLetterName;
    
    public Card (int card, Image i) {
        this.card=card;
        this.image=i;
        int rank = card/13;
        int suit = card%13;
        //System.out.println("c" + card + " r" + rank + " s" + suit);
        //this.twoLetterName = ""+ranks[rank]+suits[suit];
    }
    
    public String toString() {
        return twoLetterName;
    }
    
    public Image getImage() {
        return image;
    }
}
