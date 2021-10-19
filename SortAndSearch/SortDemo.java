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

    public void demoSequentialSearch
    (MyInteger[] data, MyInteger qry, 
    boolean countCompares, boolean showSteps) {
        System.out.println("Sequential search for "+qry);
        VerboseSearcher searcher = new VerboseSearcher(showSteps);
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = searcher.sequentialSearch(data,qry);
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s.\n",qry);
        }
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Sequential search took "+c+" comparisons.");
        }
        
    }
    
    public void demoBinarySearch
    (MyInteger[] data, MyInteger qry, 
    boolean countCompares, boolean showSteps) {
        System.out.println("Binary search for "+qry);
        VerboseSearcher searcher = new VerboseSearcher(showSteps);
        if (countCompares) {
            data[0].resetCount();
        }
        int pos = searcher.binarySearch(data,qry);
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s.\n",qry);
        }
        if (countCompares) {
            int c = data[0].getCount();
            System.out.println("Binary search took "+c+" comparisons.");
        }
        
    }
    
    public static void main (String [] args) {
        SortDemo demo = new SortDemo();
        MyInteger[] data = demo.generateRandomData(16,100);
        MyInteger missing = new MyInteger(101);
        MyInteger sample = data[data.length-1];
        System.out.println("--- Dealing with shuffled data:");
        System.out.println(Arrays.deepToString(data));
        demo.demoSequentialSearch(data,sample,true,true);
        demo.demoSequentialSearch(data,missing,true,true);
        
        System.out.println("\n--- Dealing with sorted data:");
        demo.demoMergeSort(data,false,false);
        System.out.println(Arrays.deepToString(data));
        demo.demoBinarySearch(data,sample,true,true);
        demo.demoBinarySearch(data,missing,true,true);
    }
}
