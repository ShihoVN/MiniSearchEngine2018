import java.util.LinkedList;
import java.util.*;
import java.io.FileReader;

/**
 * Takes common words from an external file into the program
 *
 * @author Shiho Numakura
 * @version 1
 */
public class fileReader2
{
    //store strings of common words 
    private LinkedList<String> commonWords;

    //takes file from main[] with common words
    public fileReader2(String file)
    {
        //initialize 
        commonWords = new LinkedList<String>();
        //scans through the file and adds into commonWords
        read(file);
    }

    //scans through file and adds into commonWords
    private void read(String file){
        try{
            Scanner scanner = new Scanner(new FileReader(file));
            //scans through all the word in file 
            while(scanner.hasNextLine()){
                //add the string of words into the commonWords 
                commonWords.add(scanner.nextLine());
            }
            return;
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    
    }
    
    public LinkedList<String> getCommonWords(){
        return commonWords;
    }
    
    
}
