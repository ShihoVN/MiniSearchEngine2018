

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class URLTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class URLTest
{
    /**
     * Default constructor for test class URLTest
     */
    public URLTest()
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
    public void testURL(){
        URL test = new URL("url", "high", "filename");
        
        assertEquals("url", test.getURL());
        assertEquals("high", test.getReliability());
        assertEquals("filename", test.getFileName());
        assertEquals(0.5, test.getPriority(),0);
        
        
    }
    
    @Test
    public void testCompareTo(){
        URL test1 = new URL("url", "high", "filename");
        URL test2 = new URL("url", "medium", "filename");
        URL test3 = new URL("url", "low", "filename");
        URL test4 = new URL("url", "high", "filename");
        
        assertEquals(0, test1.compareTo(test4));
        assertEquals(-1, test1.compareTo(test2));
        assertEquals(1, test3.compareTo(test2));
    }
    
    @Test
    public void testAddPriority(){
        URL test = new URL("url", "high", "filename");
        
        assertEquals((float)0.5, test.getPriority(), 0);
        test.addPriority();
        assertEquals((float)1.5, test.getPriority(),0);
    }
    

    
    
}
