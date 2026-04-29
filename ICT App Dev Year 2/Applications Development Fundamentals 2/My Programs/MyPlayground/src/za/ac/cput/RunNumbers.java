/**
 *
 * @author 220296006 Thabiso Matsaba
 */
package za.ac.cput;

import java.util.ArrayList;
import static java.util.Collections.sort;

public class RunNumbers {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(9);
        list.add(7);
        list.add(2);
        list.add(18);
        list.add(13);
        
        sort(list);
        
        System.out.println(list);
        
    }
}
