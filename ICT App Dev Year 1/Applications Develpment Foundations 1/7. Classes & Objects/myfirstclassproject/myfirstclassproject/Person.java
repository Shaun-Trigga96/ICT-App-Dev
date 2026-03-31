
package myfirstclassproject;

public class Person 
{
    private String surname="Mr Nobody";
    private int age;
 
    public Person()
    {
       //Constructor = Special method 
        //when an instance is created 
        this.age = 0;
        System.out.println("In Person Constructor");
    }//Constructor
    
    public String toString()
    {
        String str = String.format("Surname: %s\nAge: %d", this.surname, this.age);
        return str;
    }//end of toString
}
