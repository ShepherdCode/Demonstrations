import java.util.Arrays;
/**
 * Sort algorithm.
 *
 * @author Jason Miller
 * @version v02
 */
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
            Comparable[] cary = (Comparable[]) ary.getArray();
            mergesort(cary);
            MyInteger[] iary = (MyInteger[]) cary;
            ary.setArray(iary);
        } else {
            Arrays.sort(ary.getArray());
        }
        if (verbose) {
            System.out.printf("Sorting required %d comparisons.\n",
                MyInteger.resetCounter());
        }
    }

    private Comparable[] merge (Comparable [] left, Comparable [] right) {
        int lLen = left.length;
        int rLen = right.length;
        int sPos = 0, lPos = 0, rPos=0;
        Comparable [] sorted = new Comparable[lLen+rLen];
        //MyInteger [] sorted = new MyInteger[lLen+rLen];
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

    private Comparable[] mergesort(Comparable [] ary) {
        int len = ary.length;
        if (len<=1) {
            return ary;
        }
        indentation ++;
        int half = len/2;
        say("Sort left from half="+half);
        Comparable[] left = mergesort(Arrays.copyOfRange(ary,0, half));
        say("Sort right from half="+half);
        Comparable[] right =mergesort(Arrays.copyOfRange(ary,half,len));
        say("Merge from half="+half);
        Comparable[] merged = merge(left,right);
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
