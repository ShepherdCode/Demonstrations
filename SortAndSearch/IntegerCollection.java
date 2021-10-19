import java.util.Random;
import java.util.Arrays;
/**
 * Demonstrate collection of objects using Integer.
 *
 * @author Jason
 * @version v01
 */
public class IntegerCollection
{
    private Integer [ ] collection;

    /**
     * Constructor for objects of class IntegerCollection
     */
    public IntegerCollection()
    {
        collection = new Integer [ 10 ];
    }

    public void fillArray() {
        for (int i=0; i<collection.length; i++) {
            Integer obj = new Integer(i);
            collection[i] = obj;
        }
    }

    public void fillRandom() {
        Random generator = new Random ();
        for (int i=0; i<collection.length; i++) {
            int rand = generator.nextInt(100);
            Integer bigRand = new Integer(rand);
            collection[i] = bigRand;
        }
    }
    
    /**
     * Report the size of the array.
     * @return    the size of the array
     */
    public int getSize()
    {
        return collection.length;
    }
    
    public void displayAll(String msg) {
        System.out.printf("--- %s---\n",msg);
        for (int i=0; i<collection.length; i++) {
            System.out.printf(" %d",collection[i]);
        }
        System.out.println();
    }
    
    public int binarySearch(int query) {
        Arrays.sort(collection);
        return Arrays.binarySearch(collection,query);
    }
    
    public static void main () {
        IntegerCollection collection = new IntegerCollection();
        int size = collection.getSize();
        System.out.println("Size is "+size);
        collection.fillArray();
        collection.displayAll("The original array");
        collection.fillRandom();
        collection.displayAll("The random array");
        int answer = collection.binarySearch(50);
        collection.displayAll("The sorted array");
        System.out.println("Where is 50? "+answer);
    }
}
