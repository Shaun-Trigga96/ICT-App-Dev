/**
 * Customer.java
 * Assignment 2 Sample Solution - Customer worker class
 * @author Kruben Naidoo
 * Date: 21 April 2021
 */
package za.ac.cput;

public class Customer implements Comparable<Customer> {
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private boolean isPensioner; 

    public Customer(String title, String firstName, String lastName, String gender, boolean isPensioner) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.isPensioner = isPensioner;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public boolean isPensioner() {
        return isPensioner;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", isPensioner=" + isPensioner + '}';
    }
    
    @Override
    public int compareTo(Customer c) {
        return this.lastName.compareTo(c.lastName);
    }
}