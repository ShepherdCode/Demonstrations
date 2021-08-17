import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * WordAnalyzerTest executes unit tests on WordAnalyzer.
 */
public class WordAnalyzerTest
{
    /**
     * Default constructor for test class WordAnalyzerTest
     */
    public WordAnalyzerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void emptyString()
    {
        WordAnalyzer wordy = new WordAnalyzer("");
        assertEquals(0, wordy.countVowels());
    }


    @Test
    public void allVowels()
    {
        WordAnalyzer wordy = new WordAnalyzer("aeiou AEIOU");
        assertEquals(10, wordy.countVowels());
    }

    @Test
    public void noVowels()
    {
        WordAnalyzer wordy = new WordAnalyzer("1234567890 $%^& rst XYZ");
        assertEquals(0, wordy.countVowels());
    }
}




