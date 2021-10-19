import java.util.Arrays; // delete with find()
import java.util.Random;
/**
 * Demonstrate sorting an array.
 *
 * @author Jason
 * @version v03
 */
public class SortDemo {
    public SortDemo(int size) {
    }

    public static void fillRandom (MyInteger[] ary) {
        Random generator = new Random();
        for (int i=0; i<ary.length; i++) {
            int rand = generator.nextInt(100);
            ary[i] = new MyInteger(rand);
        }
    }

    public static void displayAll (String msg, MyInteger[] ary) {
        System.out.printf("--- %s ---\n", msg);
        String disp = Arrays.deepToString(ary);
        System.out.println(disp);
    }

    public int find(int q, MyInteger[] ary) {
        MyInteger myint = new MyInteger(q);
        return Arrays.binarySearch(ary,myint);
    }

    public static void main () {
        int SIZE = 10;
        MyInteger [] ary1 = new MyInteger [SIZE];
        MyInteger [] buffer = new MyInteger [SIZE];
        Sorter sorter = new Sorter(buffer);
        fillRandom(ary1);

        MyInteger [] ary2 = ary1.clone(); 
        displayAll("Random numbers, random order",ary2);
        System.out.println("Sorting by mergesort...");
        sorter.sort(ary2);
        displayAll("Random numbers, sorted",ary2);

    }
}
