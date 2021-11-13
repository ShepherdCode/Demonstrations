import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {
    int card;
    Image image;
    public Card (int card, Image i) {
        this.card=card;
        this.image=i;
    }
    public Image getImage() {
        return image;
    }
}
