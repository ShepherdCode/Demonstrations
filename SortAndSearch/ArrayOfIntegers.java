import java.util.Random;
import java.util.Arrays;
/**
 * Demonstrate an array of objects using Integers.
 *
 * @author Jason
 * @version v01
 */
public class ArrayOfIntegers
{
    private MyInteger [ ] collection;
    private Random generator;

    /**
     * Constructor for objects of class ArrayOfIntegers
     */
    public ArrayOfIntegers()
    {
        collection = new MyInteger [ 10 ];
        generator = new Random ();
    }

    public void fillRandom () {
        for (int i=0; i<collection.length; i++) {
            int rand = generator.nextInt(100);
            collection[i] = new MyInteger(rand);
        }
    }

    public void displayAll (String msg) {
        System.out.printf("--- %s ---\n", msg);
        for (int i=0; i<collection.length; i++) {
            MyInteger element = collection[i];
            int myint = element.getInt();
            System.out.printf(" %d",myint);
        }
        System.out.println();
    }

    public int find(int q) {
        MyInteger myint = new MyInteger(q);
        return Arrays.binarySearch(collection,myint);
    }

    /**
     * Indicate how many objects in the array.
     * @return    the count
     */
    public int getSize()
    {
        return collection.length;
    }

    MyInteger[] merge (MyInteger [] left, MyInteger [] right) {
        int lLen = left.length;
        int rLen = right.length;
        int sPos = 0, lPos = 0, rPos=0;
        MyInteger [] sorted = new MyInteger[lLen+rLen];
        while (lPos<lLen && rPos<rLen) {
            if (left[lPos].compareTo(right[rPos]) <= 0) {
                sorted[sPos++] = left[lPos++];
            } else {
                sorted[sPos++] = right[rPos++];
            }
        }
        while (lPos<lLen) {
            sorted[sPos++] = left[lPos++];
        }
        while (rPos<rLen) {
            sorted[sPos++] = right[rPos++];
        }
        return sorted;
    }

    MyInteger[] mergesort(MyInteger [] ary) {
        int len = ary.length;
        if (len <= 2) {
            MyInteger [] sorted = Arrays.copyOfRange(ary,0,len);
            if (len==2 && sorted[0].compareTo(sorted[1]) > 0) {
                MyInteger hold = sorted[0];
                sorted[0] = sorted[1];
                sorted[1] = hold;
            }
            return sorted;
        }
        int half = len/2;
        MyInteger[] left = mergesort(Arrays.copyOfRange(ary,0, half));
        MyInteger[] right =mergesort(Arrays.copyOfRange(ary,half,len));
        MyInteger[] merged = merge(left,right);
        return merged;
    }

    public void sort(boolean mergesort) {
        if (mergesort) {
            collection = mergesort(collection);
        } else {
            Arrays.sort(collection);
        }
    }

    public static void main () {
        ArrayOfIntegers ary = new ArrayOfIntegers();
        System.out.println("Size is "+ary.getSize());
        ary.fillRandom();
        ary.displayAll("Random numbers, random order");
        System.out.println("\nSorting by mergesort...");
        ary.sort(true);
        ary.displayAll("Random numbers, sorted");
        System.out.println("Found 50 at "+ary.find(50));
        System.out.println("\nSorting by java utility...");
        ary.sort(false);
        ary.displayAll("Random numbers, sorted");
        System.out.println("Found 50 at "+ary.find(50));
    }
}
