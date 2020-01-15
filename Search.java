import java.util.Scanner;
import java.util.*; 
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Prints result of the search using a database TreeMap
 *
 * @author Shiho Numakura
 * @version 1
 */
public class Search
{
    ////treemap to store database
    private DatabaseTree data;
    //store the user input as an array of String 
    private String[] inputs;
    //store all URLs in database
    private ArrayList<URL> URLs;
    //store the result URLs for the seach
    private PriorityQueue<URL> printingURLs;
    
    //Class called every search is made 
    //takes in the database used for the search and the user input 
    public Search(DatabaseTree data, String userInput)
    {
       //assigns variable 
       this.data = data;
       printingURLs = new PriorityQueue<URL>();
       inputs = userInput.toLowerCase().split(" ");
       
       
       //two cases whether input contains "or"
       //assigns the results into URLs 
       if(contains("or")){
           URLs = searchOR(toArrayList(inputs));
       }
       else{
           URLs = search(toArrayList(inputs));
       }
        
       //if no results were found for the search
       if(URLs == null){
           System.out.println("No Results Found for: "+userInput);
        }
       else{
           //add all URLs into the priority queue printingURLs to print in order
           for(URL url : URLs){
               printingURLs.add(url);
           }
            
           //determines the number of URLs to print  
           int n = printingURLs.size();
           //if there's more than five results URLs
           if(printingURLs.size()>5){
               //restricts to only first five 
               n = 5;
           }
           
           //prints the user input 
           System.out.println("Result for: " + userInput);
           //counts the number of URLs that's already printed 
           int count = 1;
           //prints the url of the head of the URL in printingURLs 
           System.out.println(printingURLs.peek().getURL());
           //initilize that URL's priority 
           printingURLs.peek().initialPriority();
           //sorts the printingURLs 
           printingURLs.poll();
           
           //iterates printingURLs 
           Iterator<URL> itr = printingURLs.iterator();
           //only prints the number of URLs it's restricted
           while (itr.hasNext() && count<n){
                //counts each time the URL is printed
                count++;
                //takes next URL in printingURLs
                URL url = itr.next();
                //prints out the url 
                System.out.println(url.getURL());
                //initilize that URL's priority
                url.initialPriority();
            }
        }
       
    }
    
    //checks if input contains a specifc key
    private boolean contains(String key){
        for(String word: inputs){
            if(word.equals(key))
                return true;
        }
        return false;
    }
    
    //takes in an array and return an ArrayList of just the words 
    private ArrayList<String> toArrayList(String[] inputs){
        ArrayList<String> AL = new ArrayList<String>(Arrays.asList(inputs));
        while(AL.contains("and")){
            AL.remove("and");
        }
        return AL;
    }
    
    //takes in a list and return an ArrayList of just the words 
    private ArrayList<String> toArrayList(List<String> list){
        ArrayList<String> AL = new ArrayList<String>(list);
        while(AL.contains("and")){
            AL.remove("and");
        }
        return AL;
    }
    
    //search for keywords connected with "and"
    private ArrayList<URL> search(ArrayList<String> inputs){
        //final resulting URLs that apply to the input
        ArrayList<URL> finalURLs = new ArrayList<URL>();
        
        //goes over all the keywords in input
        //negelects keyword starting with "-"
        for(int i = 0; i<inputs.size();i++){
            //if the keyword is in the database
            if(data.getTree().containsKey(inputs.get(i))){
                //if there are no URLs stores in finalURLs yet
                if(finalURLs.size() == 0){
                    //add all URL that contain that keyword
                    finalURLs.addAll(data.getTree().get(inputs.get(i)));
                    //showing that these URLs contain this keyword 
                    for(URL url : finalURLs){
                        url.addPriority();
                    }
                }
                //if there is some URL in finalURLs already
                else {
                    if(data.getTree().containsKey(inputs.get(i))){
                            //temporarily storing the URL that contain the keyword
                            ArrayList<URL> urls = data.getTree().get(inputs.get(i));
                            //checks whether the urls already contained a previous keyword 
                            for(int j =0; j<urls.size(); j++){
                                for(int k=0; k<finalURLs.size();k++){
                                    //if the url already contained in another keyword
                                    if(urls.get(j).getURL().equals(finalURLs.get(k).getURL())){
                                        //increase priority 
                                        finalURLs.get(k).addPriority();
                                        break;
                                    }
                                    //if the url is not in finalURLs yet 
                                    if(k==finalURLs.size()-1){
                                        //add priority and store that URL to finalURLs 
                                        URL tmpURL = urls.get(j);
                                        tmpURL.addPriority();
                                        finalURLs.add(tmpURL);
                                    }
                                }
                            }
                        }
                }
            }
        }
        
        //goes over the input again looking for a negation
        for(int i = 0; i<inputs.size();i++){
            //if keyword starts with "-"
            if(inputs.get(i).substring(0,1).equals("-")){
                    //the urls that contain this keyword
                    ArrayList<URL> ngURLs = data.getTree().get(inputs.get(i).substring(1));
                    for(int j = 0; j<ngURLs.size(); j++){
                        for(int k = 0; k<finalURLs.size(); k++){
                            //if the url that contain the keyword,
                            //takes it to initial priority 
                            if(ngURLs.get(j).getURL().equals(finalURLs.get(k).getURL())){
                                finalURLs.get(k).initialPriority();
                            }
                        }
                    }
                }
        }
             
        //if there are no URls that apply to the search
        if(finalURLs.size() == 0)
            return null;
        return finalURLs;
                 
                
    }
        

    //search if there are "or" used in search
    private ArrayList<URL> searchOR(ArrayList<String> inputs){
        //take the index where to disjunct the clauses 
        int or = inputs.indexOf("or");
        
        //separate the two clauses and operate search separately
        ArrayList<URL> URLs1 
        = search(toArrayList(inputs.subList(0,or)));
        ArrayList<URL> URLs2 
        = search(toArrayList(inputs.subList(or, inputs.size())));
        
        //takes in the two results and combines into one search result
        return searchOR(URLs1, URLs2);
    }
    
    private ArrayList<URL> searchOR(ArrayList<URL> urls1, ArrayList<URL> urls2){
        ArrayList<URL> URLs1 = urls1;
        ArrayList<URL> URLs2 = urls2;
        ArrayList<URL> finalURLs;
        
        
        //possibility of either search were not found 
        if(urls1 == null && urls2 == null){
            return null;
        }
        if(urls1 == null && urls2 != null){
            finalURLs = new ArrayList<URL>(URLs2);
            return finalURLs;
        }
        else if(urls1 != null && urls2 == null){
            finalURLs = new ArrayList<URL>(URLs1);
            return finalURLs;
        }
        //if both side on "or" had a result
        else{
            //use URLs1 as a base 
            finalURLs = new ArrayList<URL>(URLs1);
            
            for(int i = 0; i<URLs2.size(); i++){
                for(int j = 0; i<URLs1.size(); i++){
                    //if URLs2 contains a URL that is also found in URLs1
                    if(URLs2.get(i).getURL().equals(URLs1.get(j).getURL())){
                        //keeps the higher prioirty of the url 
                        if(URLs2.get(i).getPriority() > URLs1.get(j).getPriority()){
                            for(URL url : finalURLs){
                                if(url.getURL().equals(URLs2.get(i))){
                                    url.setPriority(URLs2.get(i).getPriority());
                                    break;
                                }
                            }
                        }
                    }
                    //if the url in URLs2 isnt in URLs1
                    if(j == URLs1.size()-1){
                        finalURLs.add(URLs2.get(i));
                    }
                }
            }
            
            
            return finalURLs;
        }
    }
    
    public PriorityQueue<URL> getFinalURLs(){
        return printingURLs;
    }
    public ArrayList<URL> getURLs(){
        return URLs;
    }
    
    
    
    

    
}
