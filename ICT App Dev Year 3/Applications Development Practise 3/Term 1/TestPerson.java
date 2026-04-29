/**
 * MyApplication.java 
 * This is the main entry point into the application
 * @author Kruben Naidoo
 * 31 January 2022
 */

package za.ac.cput;
import java.util.Arrays;

public class TestPerson {
    public static int initialise(Person []p, int size) {
        p[0] = new Person("Sisipho", "Mvimvi", "female", 160, 60.5f);
        p[1] = new Person("Sean", "Trainor", "male", 183, 80.0f);
        p[2] = new Person("Amy", "Johnston", "female", 200, 90.0f);
        p[3] = new Person("Amir", "Karbelkar", "male", 182, 72.0f);
        p[4] = new Person("Chris", "Mbuyi", "male", 195, 75.5f);
        size = 5;
        return size;
    }
    
    public static void sort(Person []p, int size) {
        Arrays.sort(p);
    }
    
    public static void display(Person []p, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(p[i].toString());
        }
    }
    
    public static void main(String[] args) {
        Person[] p = new Person[5];
        int size = 0;
        
        size = initialise(p, size);
        
        sort(p, size);
        
        display(p, size);
    }
}