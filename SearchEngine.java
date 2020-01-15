import java.util.*;
import java.util.Scanner;

/**
 * Allows program to interact with user
 *
 * @author Shiho Numakura
 * @version 1
 */
public class SearchEngine
{
    
    public SearchEngine()
    {
        
    }

    //experiment
    public static void main(String[] args){

        
        
        //create database from the files thats been passed
        DatabaseTree allData 
        = new DatabaseTree(new fileReader(args[0]),new fileReader2(args[1]));
        

        //asks user for search input 
        System.out.println("Enter search: ");
        //scans through user inputs 
        Scanner scanner = new Scanner(System.in);
        //when user inputs something in command
        while(scanner.hasNextLine()){
            //pass the input into Search
            Search search = new Search(allData, scanner.nextLine());
            //ask whether user wants another search
            System.out.println("Would you like another search?");
            //program exits if user doesn't reply 'y' 
            if(!scanner.nextLine().equals("y")){
                System.exit(0);
            }
            //ask for the next search
            System.out.println("Enter search: ");
        }
        
        
        
        
        
        
    }
}
