public class MyInteger implements Comparable<MyInteger> {
    private int value;
    private static boolean verbose = false;
    private static int comparisonCounter;
    public MyInteger (int value) {
        this.value=value;
    }
    
    public static int resetCounter () {
        int oldValue = comparisonCounter;
        comparisonCounter = 0;
        return oldValue;
    }
    
    public static void setVerbose (boolean v) {
        verbose = v;
    }
    
    public String toString () {
        return ""+value;
    }
    
    public int compareTo (MyInteger that) {
        int cmp = this.getInt() - that.getInt();
        comparisonCounter++;
        if (verbose) {
            char op= ' ';
            if (cmp==0) {
                op = '=';
            } else if (cmp>0) {
                op = '>';
                cmp = 1;
            } else {
                op = '<';
                cmp = -1;
            }
            System.out.printf("Comparison: this %d %c that %d\n",
            this.value, op, that.value);
        }
        return cmp;
    }
    
    public int getInt() {
        return value;
    }
}
