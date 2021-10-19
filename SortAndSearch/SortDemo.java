import java.util.Arrays; // delete with find()
import java.util.Random;
/**
 * Demonstrate sorting an array.
 *
 * @author Jason
 * @version v03
 */
public class SortDemo {
    public SortDemo() {
    }

    public MyInteger[] generateRandomData (int len, int max) {
        Random generator = new Random();
        int rand;
        MyInteger[] ary = new MyInteger[len];
        for (int i=0; i<ary.length; i++) {
            rand = generator.nextInt(max);
            ary[i] = new MyInteger(rand);
        }
        return ary;
    }

    public void displayAll (String msg, MyInteger[] ary) {
        System.out.printf("--- %s ---\n", msg);
        String disp = Arrays.deepToString(ary);
        System.out.println(disp);
    }

    public int find(int q, MyInteger[] ary) {
        MyInteger myint = new MyInteger(q);
        return Arrays.binarySearch(ary,myint);
    }

    public void demoMergeSort 
    (MyInteger[] data, boolean countCompares, boolean showSteps) {
        MyInteger [] buffer = new MyInteger [data.length];
        VerboseSorter sorter = new VerboseSorter(buffer,showSteps);
        if (countCompares) {
            data[0].resetCount();
        }
        sorter.sort(data);
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Sorting took "+c+" comparisons.");
        }
    }

    public void demoJavaSort
    (MyInteger[] data, boolean countCompares) {
        if (countCompares) {
            data[0].resetCount();
        }
        Arrays.sort(data);
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Sorting took "+c+" comparisons.");
        }
    }

    public static void main (String [] args) {
        SortDemo demo = new SortDemo();
        MyInteger [] copy;
        int c;
        MyInteger[] data = demo.generateRandomData(10,100);
        demo.displayAll("Random numbers, random order:",data);
        copy = data.clone();
        demo.demoJavaSort(copy,true);
        demo.displayAll("Sorted by Java",copy);
        copy = data.clone(); 
        demo.demoMergeSort(copy,true,false);
        demo.displayAll("Sorted by mergesort",copy);

    }
}
