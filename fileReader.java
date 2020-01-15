import java.util.ArrayList;
import java.util.*;
import java.io.FileReader;

/**
 * Scans for all given data to use from external file
 *
 * @author Shiho Numakura
 * @version 1
 */
public class fileReader
{
    //store all URLs in the inputfile 
    private ArrayList<URL> URLs;

    //takes inputfile from main[] in parameter
    public fileReader(String file)
    {
        //initialize ArrayList
        URLs = new ArrayList<URL>();
        //scans through the file and adds into URLs
        read(file);
    }
    
    //scan through file and create URL objects 
    private void read(String file){
        try{
            Scanner scanner = new Scanner(new FileReader(file));
            //as many as the file contain urls
            while(scanner.hasNextLine()){
                //split each line into an array with
                //url address, reliability, and txtfile name 
                String[] line = scanner.nextLine().split(" ");
                //create an object
                URL url = new URL(line[0], line[1], line[2]);
                //adds into the ArrayList
                URLs.add(url);
            }
            return;
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    }
    
    public ArrayList<URL> getURLs(){
        return URLs;
    }

    
}
