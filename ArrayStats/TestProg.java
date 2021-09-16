import java.util.*;
/**
 * This program tests the StatisticalAnalyzer classs
 * @author Jason Miller
 * @version 1.0
 */
public class TestProg {
    int counter;
    public TestProg () {
        counter = 0;
    }

    /**
     * Send a formated report to stdout.
     * @param data Array of integers to be analyzed.
     */
    public void showStats(int [] data) {
        counter++;
        System.out.printf("---- Test %d ----\n",counter);
        System.out.printf(" Data: %s\n",Arrays.toString(data));
        StatisticalAnalyzer sa = new StatisticalAnalyzer(data);
        System.out.printf(" Stat: %10s %10s %10s %10s %10s\n",
            "rSum","iSum","Max-Min","Average", "StdDev");
        System.out.printf("Value: %10d %10d %10d %10.2f %10.3f\n\n",
            sa.recursiveSum(0),
            sa.iterativeSum(),
            sa.getRange(),
            sa.getAverage(),
            sa.getStdDev() );
    }

    /**
     * Demonstrate StatisticalAnalyzer on two sample data sets.
     */
    public static void main () {
        TestProg tp = new TestProg();
        int [] data1 = {1,2,3,4};
        tp.showStats(data1); // answers are 10,3,2.5,1.12
        int [] data2 = {10,50,30,40,20};
        tp.showStats(data2); // answers are150,40,30,14.1
    }
}
