/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.exceptionproject;

import java.util.Scanner;

/**
 *
 * @author BURGERR
 */
public class DivideByZeroNoExceptionHandling {
// demonstrates throwing an exception when a divide-by-zero occurs
      public static int quotient( int numerator, int denominator )
      {
        return numerator / denominator; // possible division by zero
     } // end method quotient

     public static void main( String args[] )
     {
        Scanner scanner = new Scanner( System.in ); // scanner for input

        System.out.println( "Please enter an integer numerator: " );
        int numerator = scanner.nextInt();
        System.out.println( "Please enter an integer denominator: " );
        int denominator = scanner.nextInt();

        int result = quotient( numerator, denominator );
        System.out.printf(
           "\nResult: %d / %d = %d\n", numerator, denominator, result );
     } // end main
    
}
