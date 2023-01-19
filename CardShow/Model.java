
/**
 * Retain the current state.
 */
public class Model {
    int cardPlayed;
    final int FIRST_CARD = 1;
    final int LAST_CARD = 52;
    public final int NO_CARD = 0;
    /**
     * Constructor for objects of class Model
     */
    public Model()    {
        cardPlayed = NO_CARD;
    }

    int getNoCard () {
        return NO_CARD;
    }
    
    public int getCardPlayed () {
        return cardPlayed;
    }
    
    public int getDealerTop () {
        if (cardPlayed == LAST_CARD) {
            return NO_CARD;
        }
        return cardPlayed + 1;
    }
    
    public int getPlayerTop () {
        return cardPlayed;
    }
    
    public void dealCard() {
        if (cardPlayed != LAST_CARD) {
            cardPlayed++;
        }
    }
    
    public void returnCard() {
        if (cardPlayed != NO_CARD) {
            cardPlayed--;
        }
    }
}
