/**
 * This class tries to run in separate thread
 * but it isn't working so far. Can you fix it?
 */
public class NonBlocking extends Thread{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class NonBlocking
     */
    public NonBlocking()
    {
        // initialise instance variables
        x = 0;
    }
    
    public void run () {
        System.out.println("I'm a thread!");
        System.out.println(this.getId());
    }
    
    public static void main () {
        NonBlocking nb = new NonBlocking();
        nb.start();
        System.out.println("Main");
    }
}
