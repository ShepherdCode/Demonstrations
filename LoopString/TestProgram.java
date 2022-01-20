public class TestProgram {
    public static void assertEquals
    (String name, int correct, int actual) {
        System.out.println("=== "+name+" ===");
        System.out.println("The correct answer is "+correct);
        System.out.println("Your answer was "+actual);
        if (correct==actual) {
            System.out.println("Congratulations!");
        } else {
            System.out.println("Try to fix the code!");
        }
    }
    public static void main () {
        WordAnalyzer wordy;
        wordy = new WordAnalyzer("");
        assertEquals("Empty",0, wordy.countVowels());
        wordy = new WordAnalyzer("aeiou AEIOU");
        assertEquals("Vowels",10, wordy.countVowels());
        wordy = new WordAnalyzer("1234567890 $%^& rst XYZ");
        assertEquals("Non-letters",0, wordy.countVowels());       
    }
}
