
/**
 * This class computes the exponential function.
 *
 * @author Jason Miller
 * @version Monday
 */
public class Exponential2 {
    private int x;
    private int terms;
    private double curr_numer; // new
    private double curr_denom; // new

    /**
     * Create a calculator object.
     * Use the Taylor series approximation.
     * The more terms you ask for, the more accurate the answer.
     * @param x_parameter The x in "e to the x".
     * @param terms_parameter Number of terms.
     */
    public Exponential2(int x_parameter,
                        int terms_parameter)    {
        this.x = x_parameter;
        this.terms = terms_parameter;
        this.curr_numer=1; // new
        this.curr_denom=1; // new
    }

    /**
     * Approximate e^x using the Taylor series.
     * @return    e to the x
     */
    public double e_to_the_x()    {
        double sum_of_terms = 0.0;
        double one_term_value = 0.0;
        for (int i=0; i<terms; i++) {
            one_term_value = compute_term(i);
            sum_of_terms += one_term_value;
        }
        return sum_of_terms ; // fix
    }
    
    private double compute_term(int n) {
        if (n>0) { // new
            curr_numer = curr_numer * this.x;
            curr_denom = curr_denom * n;
        }
        return (curr_numer/curr_denom);
    }
    
    public static void main () {
        for (int num_terms=0; num_terms<=10; num_terms++) {
            int exponent = 2; // compute e^2
            Exponential2 exp = new Exponential2 ( exponent, num_terms );
            double answer = exp.e_to_the_x();
            System.out.print("e to the "+exponent);
            System.out.print(", accurate to "+num_terms+" terms, is ");
            System.out.println(answer);
        }
    }
}
