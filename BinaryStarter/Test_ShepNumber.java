package Binary;

public class Test_ShepNumber {
    int testsRun;
    public static void main () {
        Test_ShepNumber tester = new Test_ShepNumber();
        int testsPassed = 0;
        System.out.println("--- TEST OF SHEP NUMBER ---");
        if (tester.testInt (3)) {
            testsPassed++;
        }
        if (tester.testBinary (6)) {
            testsPassed++;
        }
        if (tester.testBinary (13)) {
            testsPassed++;
        }
        System.out.println("--- OVERALL RESULTS ---");
        System.out.printf("Passed %d/%d tests.", testsPassed, tester.getNumTestsRun());
    }

    public int getNumTestsRun() {
        return this.testsRun;
    }
    
    private boolean testInt (int input) {
        ShepNumber myNumber = new ShepNumber (input);
        int output = myNumber.getInt();
        boolean same = output == input;
        System.out.printf("Test %d ---\n", ++this.testsRun);
        System.out.printf("This object represents %d decimal.\n", input);
        System.out.printf("Value according to Shep: %d decimal.\n", output);
        System.out.printf("Are they the same? %b \n", same);
        System.out.println(this.getResultString(same));
        return same;
    }
    
    private boolean testBinary (int input) {
        String goldStandard = Integer.toBinaryString(input);
        ShepNumber myNumber = new ShepNumber (input);
        String myString = myNumber.getBinaryString();
        boolean same = myString.equals(goldStandard);
        System.out.printf("Test %d ---\n", ++this.testsRun);
        System.out.printf("This object represents %d decimal.\n", input);
        System.out.printf("Binary according to Java: %s \n", goldStandard);
        System.out.printf("Binary according to Shep: %s \n", myString);
        System.out.printf("Are they the same? %b \n", same);
        System.out.println(this.getResultString(same));
        return same;
    }
    
    private String getResultString (boolean b) {
        if (b) {
            return "Test passed!";
        }
        return "Test failed!";
    }
}