public class Shoe {
    String title;
    int size;
    double price;
    public Shoe () {
        title = "none"; size = 0; price = 0.0;
    }
    public Shoe (String t, int i, double d) {
        title = t; size = i; price = d;
    }
    public double getPrice () {
        return price;
    }

}
