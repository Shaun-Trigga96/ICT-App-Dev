package za.ac.cput.mavenproject;

import java.util.Scanner;

/**
 *
 * @author 220296006 Thabiso Matsaba
 */
public class ArraysOfObjects {
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // A bank of 5 students named grads
        //Student[] grads = new Student[5]; 
        // then assign
        //grads[0] = new Student("Thabiso",99);
        
        String name;
        int grade;
        Student[] students = new Student[4];
        for(int i=0;i<students.length;i++) {
            System.out.printf("Enter GRADE then NAME for student #%d ==> ",i);
            grade = input.nextInt();
            name = input.nextLine();
            students[i] = new Student(name, grade);
        }
        

        System.out.printf("#\tStudent\tGrade\n");
        System.out.printf("-\t-------\t-----\n");

        for(int i=0; i<students.length;i++) {
            System.out.printf("%d\t%s\t%d\n", i,students[i].Name(), students[i].Grade());
        }
            
    }
}


