public class LittleFactorialTable{
    public int factorial (int b) {
        if (b==1) return b;
        return b*(factorial(b-1));
    }
    public void makeRow (int n) {
        int f = factorial(n);
        System.out.printf("Factorial(%3d)=%s\n",n,f);
    }
    public void makeTable (int n) {
        for (int i=1; i<=n; i++) {
            makeRow(i);
        }
    }
    public static void main ()    {
        LittleFactorialTable ft = new LittleFactorialTable();
        ft.makeTable(12);  // produces garbage with larger values
    }
}
