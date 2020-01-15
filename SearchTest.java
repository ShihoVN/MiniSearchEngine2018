

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SearchTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SearchTest
{
    /**
     * Default constructor for test class SearchTest
     */
    public SearchTest()
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
    public void testSearch(){
        
        fileReader FR = new fileReader("InputFileSearchTest.txt");
        fileReader2 FR2 = new fileReader2("Common Words Example.txt");
        
        DatabaseTree tree = new DatabaseTree(FR, FR2);
        
        Search test = new Search(tree, "elephants");
        assertEquals(1,test.getURLs().size());
        assertEquals("www.elephants.com",test.getURLs().get(0).getURL());
        
        Search test1 = new Search(tree, "many");
        assertEquals(2, test1.getURLs().size());
        assertEquals("www.elephants.com",test1.getURLs().get(0).getURL());
        assertEquals("https://www.coolkidfacts.com/horse-facts/",test1.getURLs().get(1).getURL());
        
         }
}
