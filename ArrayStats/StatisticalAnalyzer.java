// TO DO: Remove this comment.
// TO DO: Add JavaDoc throughout this class.
public class StatisticalAnalyzer {
    int [] data;
    public StatisticalAnalyzer (int [] data) {
        this.data = data;
    }

    public int recursiveSum (int i) {
        return 0; // TO DO: fix this.
        // You must use recursion. 
        // Assume i==0 initially.
        // Recurse till i==data.length.
    }

    public int iterativeSum () {
        return 1; // TO DO: fix this. 
        // You must use iteration.
    }

    public int getRange() {
        return 2; // TO DO: fix this.
        // Range = max - min
        // Use iteration and variables that track min and max.
    }

    public double getAverage () {
        return 3.0; // TO DO: fix this. 
        // Use getSum() and division.
        // Don't use integer division!
    }    

    public double getStdDev () {
        return 4.0; // Extra credit
        // Compute the population standard deviation.
        // deviation = ( one_value - average )
        // stdev = sqrt ( sum ( square (deviation ) ) )
        // Use getAverage(), Math.pow(x,2), and Math.sqrt().
    }

}
