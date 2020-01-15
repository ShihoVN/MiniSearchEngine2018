

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DatabaseTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTreeTest
{
    /**
     * Default constructor for test class DatabaseTreeTest
     */
    public DatabaseTreeTest()
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
    public void testTree(){
        fileReader FR = new fileReader("InputFileTreeSample.txt");
        fileReader2 FR2 = new fileReader2("Common Words Example.txt");
        
        DatabaseTree test = new DatabaseTree(FR, FR2);
        
        TextReader TR = new TextReader(FR.getURLs().get(0), FR2.getCommonWords());
        
        assertEquals(TR.getAllWords().size(), test.getTree().size());
        assertTrue(test.getTree().containsKey(TR.getAllWords().get(3)));
        assertTrue(test.getTree().containsKey(TR.getAllWords().get(6)));
        assertTrue(test.getTree().containsKey
        (TR.getAllWords().get(TR.getAllWords().size()-1)));
        
        
        
        
    }
    
    @Test
    public void testAddWord(){
        fileReader FR = new fileReader("InputFileTreeSample.txt");
        fileReader2 FR2 = new fileReader2("Common Words Example.txt");
        
        DatabaseTree test = new DatabaseTree(FR, FR2);
        
        URL url = 
        new URL("www.tornado.com", "high", "SurvivingTornadoes.txt");
        
        assertTrue(test.getTree().containsKey("elephants"));
        assertTrue(test.addWord("elephants", url));
        assertEquals(2, test.getTree().get("elephants").size());
        
        assertFalse(test.getTree().containsKey("horses"));
        assertFalse(test.addWord("horses", url));
        assertTrue(test.getTree().containsKey("horses"));
        
        
        
        
        
        
    }
}
