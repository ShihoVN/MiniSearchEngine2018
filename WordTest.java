

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordTest
{
    /**
     * Default constructor for test class WordTest
     */
    public WordTest()
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
    public void testWord(){
        Word test = new Word("key");
        assertEquals("key", test.getKey());
        
        
        URL url = new URL("url", "high", "filename");
        Word test1 = new Word("word", url);
        
        assertEquals("word", test1.getKey());
        assertEquals(1, test1.getURLs().size());
        assertEquals(url, test1.getURLs().get(0));
        
        URL url2 = new URL("url", "high", "filename");
        test1.getURLs().add(url2);
        assertEquals(2, test1.getURLs().size());
        assertEquals(url2, test1.getURLs().get(1));
        
    }
}
