/**
 * BigStore represents a retail store like Amazon.
 * BigStore has an array of items for sale.
 */
public class BigStore {
    StoreItem items [];
    int numItems;
    /**
     * Amazon has millions of items for sale.
     * This store has only two items for sale.
     */
    public BigStore()    {
        items = new StoreItem[2];
        numItems = 0;
    }

    /**
     * This method accepts an OBJECT
     * defined by the StoreItem class,
     * which is not part of Java, but
     * was written in CIS211.
     */
    public void addItem ( StoreItem item ) {
        items[numItems++] = item;
    }

    /**
     * This method returns an OBJECT
     * defined by the StoreItem class,
     * which is not part of Java, but
     * was written in CIS211.
     */
    public StoreItem getMostExpensiveItem () {
        int i;
        double highestPrice = 0.0;
        StoreItem expensive = null;
        for (i=0; i<items.length; i++) {
            StoreItem item = items[i];
            if (item.getPrice() > highestPrice) {
                highestPrice = item.getPrice();
                expensive = item;
            }
        }
        return expensive;
    }

    public static void main () {
        BigStore store = new BigStore();
        StoreItem shoes = new StoreItem("SHOES",100.0);
        StoreItem shirt = new StoreItem("SHIRT",50.0);
        store.addItem(shoes);
        store.addItem(shirt);
        // Prove I can receive a StoreItem OBJECT.
        StoreItem expensive = store.getMostExpensiveItem();
        // Prove I can call methods on the OJBECT.
        System.out.printf(
            "Most expensive item: $%6.2f\n",
            expensive.getPrice());
        // Prove that expensive is an ALIAS for shoes.
        System.out.println(
            "Do I have two references to the same object? "
            +
            (shoes==expensive));
    }
}
