/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.mavenproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author 220296006
 */
public class StudentTest {
    
     private Student student1;
     private Student student2;
     private Student student3;
     
    @BeforeEach
    public void setUp(){
        
       student1  = new Student();
       student2  = new Student();
       student3 = student1;
    }
    // Test for Object Equality
    @Test
    public void testEquality(){
        assertSame(student1 , student2);
    }
    // Test for Object Identity
    @Test
    public void testIdentity(){
       assertEquals(student1 , student2); 
    }
    /**
     * Test of Name method, of class Student.
     */
    @Test
    public void testName() {
        System.out.println("Name");
        Student instance = null;
        String expResult = "";
        String result = instance.Name();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Grade method, of class Student.
     */
    @Test
    public void testGrade() {
        System.out.println("Grade");
        Student instance = null;
        int expResult = 0;
        int result = instance.Grade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
