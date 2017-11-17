import java.util.ArrayList;
import java.util.Collections;
public class Deck  implements Sortable {
    ArrayList<Card> cards;  // not private! that would hide it from derived classes

    public static void demonstrateDeck () {
        Deck d = new Deck();
        d.initialize();
        System.out.println("Card 0 is " + d.getCard(0));
        System.out.println("Card 1 is " + d.getCard(1));
        System.out.println("Card 52 is " + d.getCard(52));
        System.out.println("Card 53 is " + d.getCard(53));
        System.out.println("Sorting...");
        d.sort();
        System.out.println(d);
    }
    
    public Deck()    {
        cards = new ArrayList<Card>();  // Create empty instance
    }
    
    public int initialize() {  // Derived classes should change this
        int total = 52;
        int i;
        Card card;
        for (i=1; i<=total; i++) {
            card = new Card(i);
            cards.add(card);
        }
        return countCards();
    }

    public int countCards()    {
        return cards.size();
    }
    
    public void sort ()  {
        Collections.sort(cards); // Requires elements implement Comparable
    }
    
    public Card getCard ( int i ) {
        if (i<1 || i>countCards()) {
            return null;
        }
        return cards.get(i-1);
    }
    
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
