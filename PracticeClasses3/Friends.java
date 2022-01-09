
public class Friends {
    // instance variables - replace the example below with your own
    private SaysHello[] ary;

    /**
     * Constructor for objects of class Friends
     */
    public Friends()
    {
        // initialise instance variables
        ary = new SaysHello[10];
    }

    public void sampleMethod()
    {
        for (SaysHello friend : ary) {
            friend.sayHello();
        }
    }
}
