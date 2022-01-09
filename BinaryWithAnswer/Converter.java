public class Converter {
    boolean verbose;
    int base2;
    public Converter(boolean verbose)    {
        this.verbose = verbose;
        this.base2 = 2;
    }

    public String toBinary(int dec) {
        if (dec>0) {
            int quotient = dec/base2;
            int remainder = dec%base2;
            show(dec,quotient,remainder);
            return toBinary(quotient)+remainder;
        }
        return "0";
    }

    private void show(int d,int q,int r) {
        if (this.verbose) {
            System.out.printf("Dec=%2d, Quo=%2d, Rem=%2d\n",d,q,r);
        }
    }   

    public static void main () {
        int dec = 13;
        Converter c = new Converter(true);
        String bd = c.toBinary(dec);
        System.out.println("Decimal integer  : "+dec);
        System.out.println("Base 2 equivalent: "+bd);
    }
}
