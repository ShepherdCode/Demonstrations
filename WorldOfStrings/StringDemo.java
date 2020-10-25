public class StringDemo {
    private String x;
    public StringDemo()    {
        x = "Shepherd University";
    }
    public int positionOf(char c)    {
        return x.indexOf(c);
    }
    public String getWord () {
        return x;
    }
    public static void main ( ) {
        System.out.println("Demo");
        StringDemo sd = new StringDemo();
        String myword = sd.getWord();
        char c = 'u';
        int i = sd.positionOf(c);
        System.out.printf(
            "The position of letter %c in %s is %d.",
            c, myword, i);
    }
}
