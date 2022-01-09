
public class ArrayOfString {
    // instance variables - replace the example below with your own
    private String x [];

    public ArrayOfString()    {
        // initialise instance variables
        x = new String[10];
    }
    /**
     * Setter
     */
    public void setString (int i, String value) {
        x[i]=value;
    }
    /**
     * Getter
     */
    public String getString (int i) {
        return x[i];
    }
}
