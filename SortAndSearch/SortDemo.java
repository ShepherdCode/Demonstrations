import java.util.Arrays;
import java.util.Random;
/**
 * Demonstrate sorting an array.
 *
 * @author Jason
 * @version v04
 */
public class SortDemo {
    boolean countCompares;
    boolean showSteps;
    
    public SortDemo(
    boolean countCompare, 
    boolean verboseCompare,
    boolean showSteps) {
        MyInteger dummy = new MyInteger(0);
        if (verboseCompare) {
            dummy.setVerbose();
        }
        if (countCompare) {
            this.countCompares = true;
            dummy.resetCount();
        }
        this.showSteps = showSteps;
    }

    public void showCount () {
        if (this.countCompares) {
            MyInteger dummy = new MyInteger(0);
            int c = dummy.getCount();
            System.out.println("That took "+c+" comparisons.");    
        }
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

    public void demoMergeSort (MyInteger[] data) {
        MyInteger [] buffer = new MyInteger [data.length];
        VerboseSorter sorter = new VerboseSorter(buffer,this.showSteps);
        sorter.sort(data);
        showCount();
    }

    public void demoJavaSort (MyInteger[] data) {
        Arrays.sort(data);
        showCount();
    }

    public void demoSequentialSearch (MyInteger[] data, MyInteger qry) {
        System.out.println("Sequential search for "+qry);
        VerboseSearcher searcher = new VerboseSearcher(this.showSteps);
        int pos = searcher.sequentialSearch(data,qry);
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s.\n",qry);
        }
        showCount();
    }
    
    public void demoBinarySearch (MyInteger[] data, MyInteger qry) {
        System.out.println("Binary search for "+qry);
        VerboseSearcher searcher = new VerboseSearcher(this.showSteps);
        int pos = searcher.binarySearch(data,qry);
        if (pos>=0) {
            System.out.printf("Found %s at %d.\n",qry,pos);
        } else {
            System.out.printf("Did not find %s.\n",qry);
        }
        showCount();
    }
    
    public static void main () { // (String [] args) {
        SortDemo demo = new SortDemo(true,true,true); // change these!
        MyInteger[] data = demo.generateRandomData(16,100);
        MyInteger missing = new MyInteger(101);
        MyInteger sample = data[(data.length-1)/2]; // middle
        System.out.println("--- Random data:");
        System.out.println(Arrays.deepToString(data));
        System.out.println("--- Sequential search for "+sample);
        data[0].resetCount();
        demo.demoSequentialSearch(data,sample);
        System.out.println("--- Search for a missing element:");
        data[0].resetCount();
        demo.demoSequentialSearch(data,missing);
        
        System.out.println("\n--- Sort the data:");
        data[0].resetCount();
        demo.demoMergeSort(data);
        System.out.println(Arrays.deepToString(data));
        System.out.println("--- Binary search for "+sample);
        data[0].resetCount();
        demo.demoBinarySearch(data,sample);
        System.out.println("--- Binary search for "+missing);
        data[0].resetCount();
        demo.demoBinarySearch(data,missing);
    }
}
