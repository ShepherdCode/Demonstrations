public class Square{
    private int x;
    private String [][] ary;
    private final int ROWS = 9;
    private final int COLS = 10;
    public Square()    {
        x = 0;
        ary = new String [ ROWS ] [ COLS ];
    }

    public void populate () {
        for (int row = 0; row<ROWS; row++) {
            for (int col = 0; col<COLS; col++) {
                ary[row][col] = "10101";
            }
        }
    }

    public void display () {
        for (int row = 1; row<ROWS; row++) {
            for (int col = 1; col<COLS; col++) {
                String mychar = ary[row][col];
                System.out.printf(" %5s",mychar);
            }
            System.out.println(" !");
        }        
    }

    public static void main ()    {
        Square s = new Square();
        s.populate();
        s.display();
    }
}