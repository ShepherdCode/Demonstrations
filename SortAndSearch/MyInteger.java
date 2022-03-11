public class MyInteger 
implements VerboseCompare {
    private int value;
    private static boolean verbose;
    private static int comparisonCounter;
    public MyInteger (int value) {
        this.value=value;
        //this.comparisonCounter=0;
        //verbose = false;
    }
    
    public int getCount() {
        return comparisonCounter;
    }
    
    public void resetCount () {
        comparisonCounter = 0;
    }
    
    public void setVerbose () {
        verbose = true;
    }
    
    public String toString () {
        return ""+value;
    }

    public int compareTo (Object that) {
        comparisonCounter ++;
        int cmp = -1;        
        if (that instanceof MyInteger) {
            MyInteger thatInteger = (MyInteger) that;
            cmp = this.value - thatInteger.getInt();
        }
        if (verbose) {
            char op= '=';
            if (cmp>0) {
                op = '>';
            } else if (cmp<0) {
                op = '<';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Compare this ");
            sb.append(this);
            sb.append(op);
            sb.append(" that ");
            sb.append(that);
            System.out.println(sb.toString());
        }
        return cmp;
    }
    
    public int getInt() {
        return value;
    }
}
