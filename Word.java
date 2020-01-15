import java.util.*; 
import java.util.ArrayList;
/**
 * Word object where each word stores all URL containing the word
 *
 * @author Shiho Numakura 
 * @version 1
 */
public class Word
{
    //word of the object
    private String key;
    //URL that contains the word
    private ArrayList<URL> URLs;

    //when Word is called with no given URL
    public Word(String key)
    {
        //initialize 
        this.key = key;
        URLs = new ArrayList<URL>();
    }
    
    //when Word is called with word and the url it contains
    public Word(String key, URL url){
        //initialize
        this.key = key;
        URLs = new ArrayList<URL>();
        //add given URL to URLs
        URLs.add(url);
    }
    
    
    public String getKey(){
        return key;
    }
    
    public ArrayList<URL> getURLs(){
        return URLs;
    }
    

    
}
