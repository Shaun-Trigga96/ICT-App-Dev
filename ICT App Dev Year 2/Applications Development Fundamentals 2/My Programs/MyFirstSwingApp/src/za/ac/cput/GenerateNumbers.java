/*
/**
 * GenerateNumber.java
 * @author Thabiso Matsaba
 * 14 April 2021
 */
package za.ac.cput;

public class GenerateNumbers {
    
    public static int numbers[] = new int[6];
    
    // this method below stores six values unique to lotto numbers in the aaray 'nymbers'
    public static void populateValues(){
    for (int i = 0; i<numbers.length; i++ ){
        numbers[i] = (int)(Math.random() * 48 + 1);
       System.out.println(numbers[1]);
       
  } 
}
}