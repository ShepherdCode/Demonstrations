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

    public int sequentialSearch
    (MyInteger[] data, int qry, boolean countCompares) {
        MyInteger myint = new MyInteger(qry);
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = -1;
        for (int i=0; i<data.length && pos<0; i++) {
            if (data[i].compareTo(myint)==0) {
                pos=i;
            }
        }
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Sequential search took "+c+" comparisons.");
        }
        if (pos>=0) {
            System.out.printf("Found %d at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %d.\n",qry);
        }
        return pos;
    }

    public int binarySearch
    (MyInteger[] data, int qry, boolean countCompares) {
        MyInteger myint = new MyInteger(qry);
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = Arrays.binarySearch(data,myint);
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Binary search took "+c+" comparisons.");
        }
        if (pos>=0) {
            System.out.printf("Found %d at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %d at %d.\n",qry,0-pos);
        }
        return pos;
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
            System.out.println("Merge sort took "+c+" comparisons.");
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
            System.out.println("Java sort took "+c+" comparisons.");
        }
    }

    public static void main (String [] args) {
        SortDemo demo = new SortDemo();
        MyInteger [] copy;
        int c;
        MyInteger[] data = demo.generateRandomData(10,100);
        int missing = 101;
        int sample = data[data.length-1].getInt();
        System.out.println("Random:");
        System.out.println(Arrays.deepToString(data));

        demo.sequentialSearch(data,sample,true);
        demo.sequentialSearch(data,missing,true);
        //copy = data.clone();
        //demo.demoJavaSort(copy,true);
        //demo.displayAll("Sorted:",copy);
        copy = data.clone(); 
        System.out.println("Sorted:");
        demo.demoMergeSort(copy,true,false);
        System.out.println(Arrays.deepToString(copy));
        demo.binarySearch(copy,sample,true);
        demo.binarySearch(copy,missing,true);
    }
}
