/**
 * Person.java 
 * This is the model or worker class
 * @author Kruben Naidoo
 * 31 January 2022
 */

package za.ac.cput;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String gender;
    private int height;
    private float weight;

    // argument constructor
    public Person(String firstName, String lastName, String gender, int height, float weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    
    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }
    
    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void set(String firstName, String lastName, String gender, int height, float weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", height=" + height + ", weight=" + weight + '}';
    }
        
    @Override
    public int compareTo(Person other) {
        return this.lastName.compareTo(other.lastName);
    }
}