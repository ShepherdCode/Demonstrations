
/**
 * Manage the state of the game.
 * One deck is used by two actors called dealer and player.
 * Cards move one-at-a-time between actors.
 * At all times, every card belongs to one actor.
 */
public class Model {
    int cardPlayed;
    int FIRST_CARD = 1;
    int LAST_CARD = 52;
    
    /**
     * Indicator value: says an actor has no cards.
     */
    public static final int NO_CARD = 0; 

    public Model()    {
        cardPlayed = NO_CARD;
    }

    /**
     * Change the total number of cards.
     * The default value is 52.
     * Most card game applications should not call this.
     */
    public void setLastCard (int last) {
        this.LAST_CARD = last;
    }

    /**
     * Return the special value that indicates 
     * a dealer or player has no cards.
     */
    int getNoCard () {
        return NO_CARD;
    }

    /**
     * Identify the top card on the dealer's deck.
     * By default, cards are numbered 1 to 52.
     * Returns an indicator value if dealer has no cards.
     * @see getNoCard
     */
    public int getDealerTop () {
        if (cardPlayed == LAST_CARD) {
            return NO_CARD;
        }
        return cardPlayed + 1;
    }

    /**
     * Identify the number of cards in the dealer's deck.
     */
    public int getDealerHeight () {
        return 52 - cardPlayed ;
    }

    /**
     * Identify the top card on the player's deck.
     * By default, cards are numbered 1 to 52.
     * Returns an indicator value if player has no cards.
     * @see getNoCard
     */
    public int getPlayerHeight () {
        return cardPlayed ;
    }

    /**
     * Identify the number of cards in the player's deck.
     */
    public int getPlayerTop () {
        return cardPlayed;
    }

    /**
     * Take dealer's top card, make it player's top card.
     */
    public void dealCard() {
        if (cardPlayed != LAST_CARD) {
            cardPlayed++;
        }
    }

    /**
     * Take player's top card, make it dealer's top card.
     */
    public void returnCard() {
        if (cardPlayed != NO_CARD) {
            cardPlayed--;
        }
    }
}
