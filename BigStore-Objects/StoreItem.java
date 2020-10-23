/**
 * StoreItem is an OBJECT defined by CIS211.
 */
public class StoreItem {
    private String description;
    private Double price;
    public StoreItem(String desc, double price)    {
        description = desc;
        this.price = price;
    }
    public String getDescription()    {
        return description;
    }
    public double getPrice() {
        return price;
    }

    /**
     * This demo shows how StoreItem works.
     * This demo does not use the BigStore class.
     */
    public static void demo () {
        StoreItem shoes = new StoreItem("SHOES",100.0);
        StoreItem shirt = new StoreItem("SHIRT",50.0);
        System.out.print(shoes.getPrice());
        System.out.println (" "+shoes.getDescription());
        System.out.print(shirt.getPrice());
        System.out.println (" "+shirt.getDescription());
    }
}
