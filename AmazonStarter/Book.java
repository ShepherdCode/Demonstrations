public class Book {
    String title;
    int pages;
    double price;
    public Book () {
        title = "none";
        pages = 0;
        price = 0.0;
    }
    public Book (String t, int i, double d) {
        title = t;
        pages = i;
        price = d;
    }
    public double getPrice () {
        return price;
    }
}
