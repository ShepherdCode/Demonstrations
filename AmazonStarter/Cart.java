import java.util.ArrayList;
import java.util.Iterator;
public class Cart {
    ArrayList<Object> myStuff; 
    double total;
    public Cart () {
        myStuff = new ArrayList<Object>();
    }
    public void addBook (Book s) {
        myStuff.add(s);
        total += s.getPrice();
    }
    public void addShoe (Shoe s) {
        myStuff.add(s);
        total += s.getPrice();
    }
    public double getTotal () {
        return 0.0;        
    }
    public String toString () {
        Iterator i = myStuff.iterator();
        String view = "";
        while (i.hasNext()) {
            view += i.next().toString() + "\n";
        }
        return view;
    }
}
