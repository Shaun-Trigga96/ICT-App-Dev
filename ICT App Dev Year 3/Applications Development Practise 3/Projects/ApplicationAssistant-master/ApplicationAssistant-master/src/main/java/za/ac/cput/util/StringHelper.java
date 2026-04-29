package za.ac.cput.util;

public class StringHelper {

    public static boolean isNullorEmpty(String str) {
        if (str == null) return true;
        if (str.isEmpty()) return true;
        if (str.equalsIgnoreCase("null")) return true;
        return false;
    }

}
