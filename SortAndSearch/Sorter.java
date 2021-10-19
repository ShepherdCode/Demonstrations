import java.util.Arrays;
/**
 * Sort algorithm.
 *
 * @author Jason Miller
 * @version v02
 */
public class Sorter {
    private boolean verbose;
    private int indentation;
    private VerboseCompare[] data;
    private VerboseCompare[] buffer;

    public Sorter(VerboseCompare[] buffer)    {
        this.buffer = buffer;
        verbose = false;
    }

    public void setVerbose () {
        verbose = true;
    }
    
    private void merge (int begin, int half, int end) {
        int lPos = begin;
        int rPos = half;
        int sPos = begin;
        while (lPos<half && rPos<end) {
            if (data[lPos].compareTo(data[rPos]) <= 0) {
                buffer[sPos++] = data[lPos++];
            } else {
                buffer[sPos++] = data[rPos++];
            }
        }
        while (lPos<half) {
            buffer[sPos++] = data[lPos++];
        }
        while (rPos<end) {
            buffer[sPos++] = data[rPos++];
        }
        for (int i=begin; i<end; i++) {
            data[i]=buffer[i];
        }
    }

    public void sort(VerboseCompare[] data) {
        this.data = data;
        sort(0, data.length);
    }
    
    private void sort(int begin, int end) {
        int len = end-begin;
        if (len<=1) {
            return;
        }
        indentation ++;
        int half = begin+len/2;
        say("Sort left from "+begin+" to "+half);
        sort(begin, half);
        say("Sort right from "+half+" to "+end);
        sort(half,end);
        say("Merge from "+begin+" to "+end);
        merge(begin,half,end);
        indentation--;
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
