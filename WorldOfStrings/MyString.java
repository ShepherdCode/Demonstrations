/**
 * Demonstration of how String works on the inside.
 * This is really great javadoc!
 * No, I think it sucks.
 * @author Jason Miller
 */
public class MyString {
    private String x;
    public MyString()    {
        x = "Shepherd University";
    }
    /**
     * Find the first position of any letter in my string.
     * @param c The letter you wish to find.
     * @return The zero-based position if found, else -1.
     */
    public int indexOf(char c)    {
        int pos;
        char [] characters = x.toCharArray();
        for ( pos=0 ; pos < characters.length; pos++) {
            if (characters[pos] == c) {
                return pos;
            }
        }
        return -1;
    }
    public static void main () {
        MyString ms = new MyString();
        char c = 'e';
        int pos = ms.indexOf(c);
        System.out.printf("The position of letter %c is %d \n",
                            c, pos);
    }
}
