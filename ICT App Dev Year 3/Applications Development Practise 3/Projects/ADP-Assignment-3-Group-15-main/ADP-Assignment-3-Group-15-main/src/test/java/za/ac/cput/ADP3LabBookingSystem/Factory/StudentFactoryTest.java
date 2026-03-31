/*
        Author: Nabeel Meyers
        Student Number: 218328702
        Student.java
        Assignment 3
        2021
 */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.ADP3LabBookingSystem.Entity.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    //Student Validity
    @Test
    public void testValidStudent() {
        Student student = StudentFactory.build("Nabeel","Meyers","nabeel@gmail.com","0834746561");
        assertNotNull(student);
        System.out.println(student);
    }

    //Invalid Email
    @Test
    public void testValidEmail() {
        Student student = StudentFactory.build("Micheal","Scott","MScott@gmail","0648789875");
        //not valid email
        assertNull(student);
        System.out.println(student);
    }

    //invalid Phone Number Length
    @Test
    public void testValidPhoneNumberLength() {
        Student student = StudentFactory.build("Micheal","Scott","MScott@gmail.com","06487");
        //not valid phone number length
        assertNull(student);
        System.out.println(student);
    }

    //invalid Phone Number content
    @Test
    public void testValidPhoneNumberContent() {
        Student student = StudentFactory.build("Micheal","Scott","MScott@gmail.com","qwe8789875");
        //not valid phone number
        assertNull(student);
        System.out.println(student);
    }

    //identity Test
    @Test
    void identityTest(){
        Student student = StudentFactory.build("Tyson","killua","tenz@gmail.com","0816689985");
        Student student2 = student;
        assertSame(student,student2);

    }

    //Equality Test
    @Test
    void equalityTest(){
        Student student = StudentFactory.build("Tyson","killua","tenz@gmail.com","0816689985");
        Student student2 = StudentFactory.build("Jay","Won","sinatraa@yahoo.com","0846565658");
        assertNotEquals(student,student2);

    }

    //TimeOut Test
    @Test
    @Timeout(1000)
    void testTimeOut() throws InterruptedException{
        Thread.sleep(500);
        Student student = StudentFactory.build("Tyson","killua","tenz@gmail.com","0816689985");
        Student student2 = student;
        assertSame(student,student2);

    }

    //Disabling Test
    @Disabled("disabled for testing purposes...")
    @Test
    void disableTest(){

        Student student = StudentFactory.build("Tyson","killua","tenz@gmail.com","0816689985");
        Student student2 = StudentFactory.build("","","","");
        assertEquals(student,student2);
        System.out.println(student);
    }
}