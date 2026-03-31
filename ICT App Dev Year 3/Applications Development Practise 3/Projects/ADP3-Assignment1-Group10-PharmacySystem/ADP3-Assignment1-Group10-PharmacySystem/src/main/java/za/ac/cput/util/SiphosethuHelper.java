//*  Name: Siphosethu
 //       *  Student Number: 217237614
 //       *  Group: 10
//        *
//        */

package za.ac.cput.util;

import java.util.UUID;

public class SiphosethuHelper {
    public static int generateID()
    {
        return UUID.randomUUID().hashCode();
    }

    public static boolean validEmail(String email) {
        String regex = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return email.matches(regex);
    }

    public static boolean isValid(int n){
        return n > 0;
    }

    public static boolean isValid(String s){
        return s != null && s.trim().length() > 0;
    }
}
