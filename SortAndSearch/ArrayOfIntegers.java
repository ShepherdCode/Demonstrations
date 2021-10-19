import java.util.Arrays; // delete with find()
import java.util.Random;
/**
 * Demonstrate an array of objects using Integers.
 *
 * @author Jason
 * @version v03
 */
public class ArrayOfIntegers {
    private MyInteger [ ] collection;
    private Random generator;
    private boolean verbose = false;
    private boolean isSorted = true;
    private int SIZE=10;

    /**
     * Constructor for objects of class ArrayOfIntegers
     */
    public ArrayOfIntegers() {
        collection = new MyInteger [ SIZE ];
        generator = new Random ();
    }

    public ArrayOfIntegers clone () {
        ArrayOfIntegers c = new ArrayOfIntegers();
        c.collection = this.collection;
        c.generator = this.generator;
        c.verbose = this.verbose;
        c.isSorted = this.isSorted;
        return c;
    }
    
    public void setVerbose (boolean v) {
        verbose = v;
    }
    
    public void fillRandom () {
        for (int i=0; i<collection.length; i++) {
            int rand = generator.nextInt(100);
            collection[i] = new MyInteger(rand);
        }
        isSorted = false;
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

    /**
     * Indicate how many objects in the array.
     * @return    the count
     */
    public int getSize() {
        return collection.length;
    }

    public int find(int q) {
        MyInteger myint = new MyInteger(q);
        return Arrays.binarySearch(collection,myint);
    }

    protected MyInteger [] getArray () {
        return collection;
    }
    
    protected void setArray (MyInteger [] ary) {
        this.collection = ary;
    }
    
    public static void main () {
        MyInteger.setVerbose(false);
        ArrayOfIntegers ary1 = new ArrayOfIntegers();
        ary1.setVerbose(false);
        Sorter sorts = new Sorter();
        sorts.setVerbose(false);
        System.out.println("Size is "+ary1.getSize());
        ary1.fillRandom();

        ArrayOfIntegers ary2 = ary1.clone(); 
        ary2.displayAll("Random numbers, random order");
        System.out.println("Sorting by mergesort...");
        sorts.setAlgorithm(Sorter.MERGESORT);
        sorts.sort(ary2);
        ary2.displayAll("Random numbers, sorted");

        ArrayOfIntegers ary3 = ary1.clone(); 
        ary3.displayAll("Random numbers, random order");
        System.out.println("Found 50 at "+ary3.find(50));
        System.out.println("Sorting by java utility...");
        sorts.setAlgorithm(Sorter.DEFAULT);
        sorts.sort(ary3);
        ary3.displayAll("Random numbers, sorted");
        System.out.println("Found 50 at "+ary3.find(50));
    }
}
