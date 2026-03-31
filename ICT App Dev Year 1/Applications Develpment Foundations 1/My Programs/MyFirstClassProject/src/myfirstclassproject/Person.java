package myfirstclassproject;

public class Person {
    
    private String surname;
    private int age;
 
    public Person(){
        this.surname = "Mr Nobody";

        System.out.println("In Person Constructor");
}
      
    public String toString()
    {
        String str = String.format("Surname: %s\nAge: %d", this.surname, this.age);
        return str;
}
}