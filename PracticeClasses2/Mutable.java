/**
 * Hmmm, this class doesn't work the way its name implies.
 * Can you fix it?
 * Hint: add a method.
 */
public class Mutable {
    private int x;
    public Mutable(int setting)    {
        x = setting;
    }
    /**
     * Setter
     */
    public void setValue (int newVal) {
        x=newVal;
    }
    /**
     * Getter
     * 
     */
    public int getValue() {
        return x;
    }
    
    public Mutable sampleMethod(int y)    {
        return new Mutable (x+y);
    }
}
