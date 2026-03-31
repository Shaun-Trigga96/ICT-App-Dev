
/**
 *RunColours.java
 * Using an arraylist to store, sort and display values
 * @author 2Thabiso Matsaba(20286006)
 * 21 April 2021
 */
package za.ac.cput;

import java.util.ArrayList;
import static java.util.Collections.sort;

public class RunClours {
    public static void main(String[] args) {
         ArrayList<String> list = new ArrayList();  
         
    // add elements to the aaray list
    list.add("red");
    list.add("blue");
    list.add("green");
    list.add("black");
    list.add("orange");
    
    // sort the values in alphabetical order
     sort(list);
       
    //Display array list 
        System.out.println("Contents of the aaray list: ");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
   }
    
}
