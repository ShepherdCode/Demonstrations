import java.util.Arrays;
/**
 * Sort algorithm.
 *
 * @author Jason Miller
 * @version v02
 */



//--- Random numbers, sorted ---
// 83 33 94 84 42 20 8 96 99 30
// Found 50 at -8


public class Sorter {
    public static final int DEFAULT=0;
    public static final int MERGESORT=1;
    private int algorithm;
    private boolean verbose;
    private int indentation;

    public Sorter()    {
        algorithm=DEFAULT; 
        verbose = false;
    }

    /**
     * Determine which sort algorithm shall be used.
     * @param a 0=Arrays.sort(), 1=mergesort.
     */
    public void setAlgorithm(int a)    {
        if (a<DEFAULT || a>MERGESORT) {  // invalid
            a=DEFAULT; 
        }
        algorithm = a;
    }
    
    public void setVerbose (boolean v) {
        verbose = v;
    }
    
    public void sort(ArrayOfIntegers ary) {
        MyInteger.resetCounter();
        if (algorithm==MERGESORT) {
            ary.setArray(mergesort(ary.getArray()));
        } else {
            Arrays.sort(ary.getArray());
        }
        if (verbose) {
            System.out.printf("Sorting required %d comparisons.\n",
                MyInteger.resetCounter());
        }
    }

    private MyInteger[] merge (MyInteger [] left, MyInteger [] right) {
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
        System.err.println("left="+Arrays.toString(left));
        System.err.println("right="+Arrays.toString(right));
        System.err.println("sorted="+Arrays.toString(sorted));
        return sorted;
    }

    private MyInteger[] mergesort(MyInteger [] ary) {
        int len = ary.length;
        if (len<=1) {
            return ary;
        }
        indentation ++;
        int half = len/2;
        say("Sort left from half="+half);
        MyInteger[] left = mergesort(Arrays.copyOfRange(ary,0, half));
        say("Sort right from half="+half);
        MyInteger[] right =mergesort(Arrays.copyOfRange(ary,half,len));
        say("Merge from half="+half);
        MyInteger[] merged = merge(left,right);
        System.err.println("merged="+Arrays.toString(merged));
        indentation--;
        return merged;
    }

    private void say (String s) {
        if (verbose) {
            String margin="";
            for (int i=0; i<indentation; i++) {
                margin += " ";
            }
            System.out.println(margin+s);
        }
    }
    
}
