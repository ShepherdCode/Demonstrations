// TO DO: Remove this comment.
// TO DO: Add JavaDoc throughout this class.
public class WordAnalyzer {
    private String word;
    public WordAnalyzer(String word)    {
        this.word = word;
    }

    // TO DO: Remove this comment.
    // TO DO: Fix this method.
    public int countVowels () {
        return -1;
    }
    
    public static void main (String myWord) {
        WordAnalyzer wordy = new WordAnalyzer(myWord);
        int count = wordy.countVowels();
        System.out.printf("There are %d vowels in %s.\n",
        count,myWord);
    }

}
