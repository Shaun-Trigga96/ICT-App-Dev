/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchstatement;
import java.util.*;
public class SwitchStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
int choice, num1, num2, answer;
System.out.println("\tCalculator");
System.out.println("1: Plus");
System.out.println("2: Minus");
System.out.println("3. Multiplication");
System.out.println("4: Division");
System.out.println("5: Exit");
System.out.println("Enter first number");
num1 = scn.nextInt();
System.out.println("Enter second number");
num2 = scn.nextInt();
System.out.println("Enter your choice");
choice = scn.nextInt();
switch (choice) {
case 1:
answer = num1 + num2;
System.out.println("Addition: " + answer);
break;
case 2:
answer = num1 - num2;
System.out.println("Subtraction: " + answer);
break;
case 3:
answer = num1 * num2;
System.out.println("Multiplation: " + answer);
break;
case 4:
answer = num1 / num2;
System.out.println("Division: " + answer);
// break;
case 5:
System.out.println("Thank you.");
System.exit(0);
break;
default:
System.out.println("Wrong choice");
}
System.out.println("Switch done.");
} 
}
    
    

