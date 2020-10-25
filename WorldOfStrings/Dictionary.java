import java.util.*;
public class Dictionary {
    private int x;
    Hashtable<String, String> table;
    public Dictionary()    {
        table = new Hashtable<String, String>();
    }
    public void put(String key, String value)    {
        table.put(key,value);
    }
    public String get(String key) {
        return table.get(key);
    }
    public static void main () {
        Dictionary d = new Dictionary();
        d.put("CPU","central processing unit");
        d.put("ALU","arithmetic logic unit");
        d.put("FPU","floating point unit");
        String def = d.get("CPU");
        System.out.print("The definition of ");
        System.out.print("CPU");
        System.out.println(" is "+def);
    }
}
