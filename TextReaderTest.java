

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TextReaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TextReaderTest
{
    /**
     * Default constructor for test class TextReaderTest
     */
    public TextReaderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testTextReader(){
        URL url1 = new URL("www.elephants.com", "medium", 
        "AllAboutElephantsSample.txt");
        
        fileReader2 commonWords = new fileReader2("Common Words Example.txt");
        
        TextReader test = new TextReader(url1, commonWords.getCommonWords());
        
        assertEquals(36, test.getAllWords().size());
        
        int n = 0;
        for(String word : test.getAllWords()){
            if(word.equals("elephants"))
                n++;
        }
        assertEquals(1, n);
        
        
        
        
        
        
        
    }
}
