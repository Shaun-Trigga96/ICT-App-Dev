/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.exceptionproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author BURGERR
 */
public class DivideByZeroWithExceptionHandling {
// demonstrates throwing an exception when a divide-by-zero occurs
      public static int quotient( int n, int d )
     {
        return n / d; // possible division by zero
     } // end method quotient

     public static void main( String args[] )
     {
        Scanner scanner = new Scanner( System.in ); // scanner for input
        boolean continueLoop = true; // determines if more input is needed

        do                                                                  
        {                                                                   
           try // read two numbers and calculate quotient                   
           {                                                                
              System.out.println( "Please enter an integer numerator: " );    
              int numerator = scanner.nextInt();                            
              System.out.println( "Please enter an integer denominator: " );  
              int denominator = scanner.nextInt();                          
                                                                            
              int result = quotient( numerator, denominator );              
              System.out.printf( "\nResult: %d / %d = %d\n", numerator,     
                 denominator, result );                                     
              continueLoop = false; // input successful; end looping        
           } // end try   

           catch ( ArithmeticException a )                
           {                                                                
              System.out.println(                                           
                 "*Zero is an invalid denominator. Please try again.\n" );   
           } // end catch    

           catch ( InputMismatchException inMisMatchException )                
           {                                                                
              System.out.println(inMisMatchException.toString());                    
              System.out.println(                                           
                 "**A non-numeric value was entered. Please try again.\n" );   
                 scanner.next();
           } // end catch    
                        
          catch ( Exception e )                
           {                                                                
              System.out.println(                                           
                 "***This is the catch all executing........"+e.toString() );   
                 scanner.next();
           } // end catch    

           finally
           {
              System.out.println(                                           
                 "***FINALLY - This statement will always execute..whether an exception occurs or not");                               
            }
        } while ( continueLoop ); // end do...while                         
                   System.out.print("rest of program continues");

     } // end main
    
}

