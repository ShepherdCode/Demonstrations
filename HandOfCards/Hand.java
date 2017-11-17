/**
 * Model a hand of playing cards.
 * A hand is-a deck.
 * A hand starts with zero cards.
 * A hand can add a given card. 
 * A hand can remove the equivalent to any given card.
 */
public class Hand extends Deck {
    public static void demonstrateHand () {
        Hand hand1 = new Hand();
        Card card1,card2;
        card1 = new Card(1);
        card2 = new Card(52);
        hand1.addCard(card1);
        hand1.addCard(card2);
        System.out.println("This hand contains two cards: " + hand1);
        hand1.removeCard(card1);
        System.out.println("Noew remove a specific card: " + hand1);        
    }
        public int initialize() {
        return 0; // a hand is empty by default
    }
    public void addCard (Card newCard) {
        cards.add(newCard); // would be better to guard against duplicates
    }
    public boolean removeCard (Card oldCard) {
        return cards.remove(oldCard); // null if not found
    }
}
