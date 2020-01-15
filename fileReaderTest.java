

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class fileReaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class fileReaderTest
{
    /**
     * Default constructor for test class fileReaderTest
     */
    public fileReaderTest()
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
    public void testFileReader(){
        fileReader test = new fileReader("InputFileSample.txt");
        
        assertEquals(4, test.getURLs().size());
        
        URL url1 = new URL("www.elephants.com", "medium", 
        "AllAboutElephantsUnderstandingDolphins.txt");
        URL url2 = new URL("www.tornado.com", "high", "SurvivingTornadoes.txt");
        
        assertEquals(url1.getURL(), test.getURLs().get(0).getURL());
        assertEquals(url1.getReliability(), test.getURLs().get(0).getReliability());
        
        assertEquals(url2.getURL(), test.getURLs().get(3).getURL());
        assertEquals(url2.getReliability(), test.getURLs().get(3).getReliability());
        
    }
}
