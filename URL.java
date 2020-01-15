import java.lang.*;


/**
 * URL object where stores each URL information
 *
 * @author Shiho Numakura
 * @version 1
 */
public class URL implements Comparable<URL>
{
    //url address
    private String URL;
    //givrn reliability of the website 
    private String reliability;
    //name of the txt file 
    private String fileName;
    //priority of this specific url to print out 
    private float priority;
    
    
    public URL(String URL, String reliability, String fileName)
    {
       this.URL = URL;
       this.reliability = reliability;
       this.fileName = fileName;
       //initialize priority according to reliabiltiy
       initialPriority();
    }
    
    //initialize priority according to reliability
    public void initialPriority(){
        if(reliability.toLowerCase().equals("high"))
            //greatest priority compared to other reliability
            priority = (float)0.5;
        else if (reliability.toLowerCase().equals("medium")){
            //medium priority
            priority = (float)0.3;
        }
        else {
            priority = (float)0.1;
        }
    }
    
    //compares the priority of the URL objects
    public int compareTo(URL url){
        if(priority == url.getPriority())
            return getURL().compareTo(url.getURL());
        else if (priority < url.getPriority()){
            return 1;
        }
        else{
            return -1;
        }
    }

    public String getURL(){
        return URL;
    }
    
    public String getReliability(){
        return reliability;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public float getPriority(){
        return priority;
    }
    
    //add 1 to the priority whenever the url contains more of the searched words 
    public void addPriority(){
        priority ++;
        return;
    }
    
    public void setPriority(float newPriority){
        priority = newPriority;
    }
    

    
}
