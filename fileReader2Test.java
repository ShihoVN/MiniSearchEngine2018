

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class fileReader2Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class fileReader2Test
{
    /**
     * Default constructor for test class fileReader2Test
     */
    public fileReader2Test()
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
    public void testFileReader2(){
        fileReader2 test = new fileReader2("Common Words Example.txt");
        
        assertEquals(16, test.getCommonWords().size());
        assertTrue(test.getCommonWords().contains("a"));
        assertTrue(test.getCommonWords().contains("is"));
        assertTrue(test.getCommonWords().contains("I"));
        
        
        
    }
}
