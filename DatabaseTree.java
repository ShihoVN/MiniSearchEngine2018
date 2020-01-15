import java.util.LinkedList;
import java.util.ArrayList;
import java.util.*;  


/**
 * Stores all data into a database tree map
 *
 * @author Shiho Numakura
 * @version 1
 */
public class DatabaseTree
{
    //treemap to store ALL words used in ALL files 
    private TreeMap<String, ArrayList<URL>> tree;
    //ArrayList of URL to store in database
    private ArrayList<URL> allURLs;
    //LinkedList of String to store common words not to store in database
    private LinkedList<String> commonWords;

    //takes ArrayList of all URLs and LinkedList of all common words to disregard
    public DatabaseTree(fileReader FR, fileReader2 FR2)
    {
        //initialize 
        tree = new TreeMap<String, ArrayList<URL>>();
        allURLs = FR.getURLs();
        commonWords = FR2.getCommonWords();
        
        //for every URL, create a TextReader to retrieve all words in that file
        for(int i = 0; i<allURLs.size(); i++){
            //call TextReader for this URL, with this list of common words
            TextReader text = new TextReader(allURLs.get(i), commonWords);
            LinkedList<String> newWords = text.getAllWords();
            //add all word from the file to the treemap from this url 
            for(String word : newWords){
                addWord(word, allURLs.get(i));
            }
        }
    }
    
    //add word associated with its url to the tree map 
    public boolean addWord(String word, URL url){
        //if the tree already has the key word 
        if(tree.containsKey(word)){
            //add the url to the existing value pf Word object for the tree 
            tree.get(word).add(url);
            //if the word is already in the treemap 
            return true;
        }
        else{
            //if the tree does NOT have the word yet 
            //create a new Word object for that word 
            Word newWord = new Word(word, url);
            //adds into the tree map
            tree.put(newWord.getKey(), newWord.getURLs());
            //if the word wasnt in the treemap yet 
            return false;
        }
    }
    
    public TreeMap<String, ArrayList<URL>> getTree(){
        return tree;
    }
    
    
    
    
    
    
    
}
