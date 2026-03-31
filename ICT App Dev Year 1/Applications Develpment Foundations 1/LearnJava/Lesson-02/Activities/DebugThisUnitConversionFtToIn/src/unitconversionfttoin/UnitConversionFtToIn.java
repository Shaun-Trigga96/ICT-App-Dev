/*
 * DEBUG THIS! Exercise
 * 
 * Learning to read & debug existing code is an important skill.
 * Fix the errors in this program. 
 * Try not to re-write the program, just correct what's wrong.  
 * 
 * This program will convert an input value in Inches to Feet and Inches.
 * There are 12 inches in a foot. 
 * The remainder are the leftover inches
 * Examples:    15 inches = 1 foot 3 inches.
 *              29 inches = 2 feet 5 inches.
 */
package unitconversionfttoin;

import java.util.Scanner;

public class UnitConversionFtToIn {

    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        int inputInches;
        System.out.println("Enter a value in inches : ");
        inputInches = input.nextInt();
        int ft; 
        int in;
        ft = inputInches % 12;
        in = inputInches / 12;
        System.out.printf("%d inches == %d feet %s inches\n"
                , inputInches, ft, in);
    }
}
