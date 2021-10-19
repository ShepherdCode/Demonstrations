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
    (MyInteger[] data, MyInteger qry, boolean countCompares) {
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = -1;
        for (int i=0; i<data.length && pos<0; i++) {
            if (data[i].compareTo(qry)==0) {
                pos=i;
            }
        }
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s.\n",qry);
        }
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Sequential search took "+c+" comparisons.");
        }
        return pos;
    }

    public int binarySearch
    (MyInteger[] data, MyInteger qry, boolean countCompares) {
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = Arrays.binarySearch(data,qry);
        //int pos = binSearch(data,qry,0,data.length);
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s at %d.\n",qry,0-pos);
        }
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Binary search took "+c+" comparisons.");
        }
        return pos;
    }

    private int binSearch (MyInteger[] data, MyInteger qry, int start, int end) {
        int half = (end-start)/2;
        return 0;
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
        MyInteger[] data = demo.generateRandomData(16,100);
        MyInteger missing = new MyInteger(101);
        MyInteger sample = data[data.length-1];
        System.out.println("--- Dealing with shuffled data:");
        System.out.println(Arrays.deepToString(data));

        demo.sequentialSearch(data,sample,true);
        demo.sequentialSearch(data,missing,true);
        //copy = data.clone();
        //demo.demoJavaSort(copy,true);
        //demo.displayAll("Sorted:",copy);
        copy = data.clone(); 
        System.out.println("--- Dealing with sorted data:");
        demo.demoMergeSort(copy,true,false);
        System.out.println(Arrays.deepToString(copy));
        demo.binarySearch(copy,sample,true);
        demo.binarySearch(copy,missing,true);
    }
}
