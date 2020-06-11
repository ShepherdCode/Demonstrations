import java.util.*;
public class History {
    ArrayList<String> dates;
    public History()    {
        int startingSize = 10;
        dates = new ArrayList<String>(startingSize);
    }
    public void add (String str) {
        dates.add(str);
    }
    public String getLast() {
        if (dates.size()==0) {
            return null;
        }
        return dates.get(dates.size()-1);
    }
}
