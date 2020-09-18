
/**
 * This class computes the exponential function.
 *
 * @author Jason Miller
 * @version Monday
 */
public class Exponential3 {
    private int x;
    private int terms;
    private int numerator;
    private long denominator;

    /**
     * Create a calculator object.
     * Use the Taylor series approximation.
     * The more terms you ask for, the more accurate the answer.
     * @param x_parameter The x in "e to the x".
     * @param terms_parameter Number of terms.
     */
    public Exponential3(int x_parameter,
    int terms_parameter)    {
        this.x = x_parameter;
        this.terms = terms_parameter;
    }

    // Private method not meant for the general user.
    private double compute_term(int n) {
        if (n==0) {
            numerator=1;
            denominator=1;
        } else {
            numerator = numerator * x;
            denominator = denominator * n;
        }
        return 1.0*numerator/denominator;
    }

    /**
     * Approximate e^x using the Taylor series.
     * This version uses an efficient algorithm:
     * each term re-uses the results from the prevous term.
     * @return    e to the x
     */
    public double e_to_the_x()    {
        double sum_of_terms = 0.0;
        double one_term_value = 0.0;
        for (int i=0; i<=terms; i++) {
            one_term_value = compute_term(i);
            sum_of_terms += one_term_value;
        }
        return sum_of_terms ;
    }

    /**
     * Approximate e^x using the Taylor series.
     * This version uses a brute force algorithm:
     * each term is computed from scratch.
     * @return    e to the x
     */
    public double e_to_the_x_version2 () {
        double answer = 0.0;
        int numerator;
        long denominator;
        for ( int i = 0; i<=terms; i++) {
            numerator = power(x,i);
            denominator = factorial(i);
            answer = answer + 1.0*numerator/denominator;
        }
        return answer;
    }

    /**
     * Compute the power function.
     * For base=2 and exp=3, this returns 2^3 = 8.
     * @return base^exp
     */
    public int power (int base, int exp) {
        int answer = 1;
        for (int i=1 ; i<=exp; i++) {
            answer = answer * base;
        }
        return answer;
    }

    /**
     * Compute the factorial function.
     * For x = 5, this returns 5*4*3*2*1 = 120.
     * @return x!
     */
    public long factorial (int x) {
        long answer = 1;
        if (x >= 2) {            
            for ( ; x>=1; x--) {
                answer = answer * x;
            }
        }
        return answer;
    }

    /**
     * Demonstration program.
     * Compute e^2 various times.
     * Use 2 algorithms: brute force and efficient.
     * Both algorithms should return the same answer.
     * Try using more and more terms of Taylor series.
     * The answer should get more accurate with more terms.
     */
    public static void main () {
        int exponent = 2; // compute e^2

        for (int i=0; i<=20; i++) {

            int num_terms = i;  
            Exponential3 exp = new Exponential3 ( exponent, num_terms );

            double answer = exp.e_to_the_x();
            System.out.print("e to the "+exponent);
            System.out.print(" accurate to "+num_terms+" terms ");
            System.out.println(answer);

            double answer2 = exp.e_to_the_x_version2();
            System.out.print("e to the "+exponent);
            System.out.print(" accurate to "+num_terms+" terms ");
            System.out.println(answer2);
        }
    }
}