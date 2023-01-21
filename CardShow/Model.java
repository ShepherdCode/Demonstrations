
/**
 * Manage the state of the game.
 * One deck is used by two actors called dealer and player.
 * Cards move one-at-a-time between actors.
 * At all times, every card belongs to one actor.
 */
public class Model {
    int cardInPlay;
    int FIRST_CARD = 1;
    int LAST_CARD = 52;
    
    /**
     * Indicator value: says an actor has no cards.
     */
    public static final int NO_CARD = 0; 

    public Model()    {
        cardInPlay = NO_CARD;
    }

    /**
     * Generate a representation of the game state.
     * Compute the heights of both card piles.
     * Compute the top card for each pile.
     * @return A new status object.
     */
    public Status getStatus() {
        // All status depends on cardInPlay.
        Status status = new Status();
        status.playerTop = cardInPlay;
        if (cardInPlay == LAST_CARD) {
            status.dealerTop = NO_CARD;
        } else {
            status.dealerTop = cardInPlay + 1;
        }
        status.playerHeight = cardInPlay;
        status.dealerHeight = LAST_CARD - cardInPlay;
        return status;
    }
    
    /**
     * Change the total number of cards.
     * Most card game applications should not call this.
     * The default value is 52 i.e. a normal deck of cards.
     */
    public void setLastCard (int last) {
        this.LAST_CARD = last;
    }

    /**
     * Take dealer's top card, make it player's top card.
     */
    public void dealCard() {
        if (cardInPlay != LAST_CARD) {
            cardInPlay++;
        }
    }

    /**
     * Take player's top card, make it dealer's top card.
     */
    public void returnCard() {
        if (cardInPlay != NO_CARD) {
            cardInPlay--;
        }
    }
}
