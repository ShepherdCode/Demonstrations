import java.math.BigInteger;
public class BigFactorialTable{
    public BigInteger factorial (BigInteger b) {
        if (b.equals(BigInteger.ONE)) return b;
        return b.multiply(factorial(b.subtract(BigInteger.ONE)));
    }
    public void makeRow (int n) {
        BigInteger b = factorial(BigInteger.valueOf(n));
        String s = b.toString();
        System.out.printf("Factorial(%3d)=%s\n",n,s);
    }
    public void makeTable (int n) {
        for (int i=1; i<=n; i++) {
            makeRow(i);
        }
    }
    public static void main ()    {
        BigFactorialTable ft = new BigFactorialTable();
        ft.makeTable(30);  // BigInteger handles 2 billion digits
    }
}
