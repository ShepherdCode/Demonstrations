public class Binary {
    int myNum;
    public Binary(int myNum)    {
        this.myNum = myNum;
    }
    public String toBinaryString() {
        String binary = buildStringFromInt (myNum);
        return binary;
    }
    private String buildStringFromInt (int n) {
        String binary = "";
        if (n==0) {
            return binary;
        }
        if (n % 2 == 0) {
            binary = "0";
        } else {
            binary = "1";
        }
        return buildStringFromInt (n/2) + binary;
    }
    public static void main () {
        int starter = 6;
        Binary converter = new Binary(6);
        String answer = converter.toBinaryString();
        System.out.println("This is a test of the divide-by-two algorithm.");
        System.out.printf("Decimal = %10d\n",starter);
        System.out.printf("Binary  = %10s\n",answer);
    }
}
