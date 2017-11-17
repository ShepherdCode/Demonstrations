/**
 * Model a playing card.
 * A card has a value, 1 to 52, required by the constructor.
 * A card has a SUIT and a RANK, determined by its value.
 * A card can compare itself to another card by value.
 */
public class Card implements Comparable<Card> {
    int value;
    int totalRanks, totalSuits;
   
    public static void demonstrateCard () {
        Card firstCard= new Card(1);
        Card lastCard= new Card(52);
        System.out.println ("First Card: " + firstCard.getValue() + ", " + firstCard);
        System.out.println ("Last Card: " + lastCard.getValue() + ", " + lastCard);
    }
    
    public Card(int i)    {
        totalRanks = RANK.values().length;
        totalSuits = SUIT.values().length;
        value = i; // 1 to 52
    }
    
    public int getValue () {
        return value;
    }
    
    public int compareTo(Card c) {
        if (getValue() > c.getValue()) {
            return +1;
        } else if (getValue() < c.getValue()) {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(Card c) {
        return (getValue() == c.getValue());
    }
    
    public RANK getRank () {
        int c = getValue(); // 1 to 52
        int i = (c-1) % totalRanks; // 0 to 13
        RANK r = RANK.values()[i];
        return r;
    }
    
    public SUIT getSuit () {
        int c = getValue(); // 1 to 52
        int i = (c-1) / totalRanks; // 0 to 3
        SUIT s = SUIT.values()[i];
        return s;
    }
    
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append(getRank().name());
        sb.append("_of_");
        sb.append(getSuit().name());
        return sb.toString();
    }
}
