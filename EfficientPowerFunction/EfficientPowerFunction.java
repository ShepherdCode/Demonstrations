public class EfficientPowerFunction {
    private int iterations;
    private boolean optimize;
    public EfficientPowerFunction ( )    {
        iterations=0;
        optimize=false;
    }

    public EfficientPowerFunction (boolean optimize)    {
        iterations=0;
        this.optimize=optimize;
    }

    public double power (double base, int exp){
        iterations++;
        double answer;
        if (exp < 0) {
            return 1.0/power(base,0-exp);
        } else if (exp == 0) {   
            return 1;
        } else if (exp == 1) {
            return base;
        } else if (optimize && exp % 2 == 0) {
            double temp = power(base, exp/2);
            return (temp * temp);
        } else {
            return (base * power(base, exp-1) );    
        }
    }    

    public int getIterations() {
        return iterations;
    }

    public static void main(){
        EfficientPowerFunction math1,math2;
        double answer1,answer2;
        int calls1,calls2;
        int base = 2;
        int exp;
        boolean testOptimize = true;
        if (testOptimize) {
            System.out.println("          calls calls"); 
            System.out.println("base expo NoOpt Optimized"); 
            System.out.println("==== ==== ===== ========="); 
            for (exp=1; exp<=20; exp++) {
                math1 = new EfficientPowerFunction(false);
                answer1 = math1.power(base,exp);
                calls1 = math1.getIterations();
                math2 = new EfficientPowerFunction(true);
                answer2 = math2.power(base,exp);
                calls2 = math2.getIterations();
                System.out.printf(
                    "%4d %4d %5d %5d\n",
                    base, exp, calls1, calls2); 
            }
        }
        boolean testNegative = true;
        if (testNegative) {
            System.out.println();
            math1 = new EfficientPowerFunction(true);
            answer1 = math1.power(10,3);
            System.out.println("power(10,3)="+answer1);
            answer1 = math1.power(10,-3);
            System.out.println("power(10,-3)="+answer1);
        }
    }
}