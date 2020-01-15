import java.util.LinkedList;
import java.util.*;
import java.io.FileReader;

/**
 * takes external data file to store in the program
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextReader
{
    //list to store all the words used in the file 
    private LinkedList<String> words;
    //list to store all the common words to disregard 
    private LinkedList<String> commonWords;

    //takes in the url to scan through, and a list of common words 
    public TextReader(URL url, LinkedList<String> commonWords)
    {
        //initialize 
        words = new LinkedList<String>();
        this.commonWords = commonWords;
        //scan through the url txt file 
        read(url.getFileName());
    }
    
    //scan through the url txt file 
    private void read(String file){
        try{
            Scanner scanner = new Scanner(new FileReader(file));
            
            //as many as there are words in the txt file 
            while(scanner.hasNext()){
                //takes every word only alphabets from the txt in lower case 
                String word = scanner.next().replaceAll("[^a-zA-z]", "").toLowerCase();
                
                //dont add any words listed in common words 
                //dont add any repeating words already existing in the words
                if(!commonWords.contains(word) && !words.contains(word)){
                    words.add(word);
                }
            }
        
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public LinkedList<String> getAllWords(){
        return words;
    }
}

    

