/**
 * The VerboseSorter can use Sequential Search or Binary Search.
 * Set this.verbose to see step-by-step comentary.
 * Set data.verbose to track number of comparisons.
 */
public class VerboseSearcher {
    private boolean verbose;
    private int indentation;

    public VerboseSearcher(boolean verbose)    {
        this.verbose = verbose;
    }

    public int sequentialSearch (MyInteger[] data, MyInteger qry) {
        int pos = -1;
        for (int i=0; i<data.length && pos<0; i++) {
            say("Look at data["+i+"]="+data[i]);
            if (data[i].compareTo(qry)==0) {
                pos=i;
                say("Found it!");
            }
        }
        return pos;
    }

    public int binarySearch (MyInteger[] data, MyInteger qry) {
        indentation=0;
        int pos = binSearch(data,qry,0,data.length);
        return pos;
    }

    private int binSearch (MyInteger[] data, MyInteger qry, int start, int end) {
        int half = start+(end-start)/2;
        int cmp = qry.compareTo(data[half]);
        say("Search from "+start+" to "+end+" for "+qry);
        say("Halfway is data["+half+"]="+data[half]);
        int pos = half;
        if (cmp==0) {
            say("Found it!");
            return pos;
        } else if (cmp<0 && half==start || cmp>0 && half==end-1) {
            say("Nowhere left to look.");
            return 0-pos;
        } else {
            indentation++;  //optional
            if (cmp<0) {
                say("Go left.");
                pos = binSearch(data,qry,start,half);
            } else {
                say("Go right.");
                pos = binSearch(data,qry,half,end);
            }
        }
        return pos; 
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
