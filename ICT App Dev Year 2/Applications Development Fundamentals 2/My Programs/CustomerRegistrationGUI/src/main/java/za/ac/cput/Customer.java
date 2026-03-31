/**
 * Assignment 2
 * Customer.java
 * This is my customer class 
 * @author Thabiso Matsaba (220296006)
 * 05 May 2021
 */
package za.ac.cput;

public class Customer{

	private String title;
	private String firstName;
	private String lastName;
	private String gender;
	private boolean isSouthAfrican;
  
        public Customer(){} 
   
   
public void setSouthAfrican(boolean isSouthAfrican)
{
	this.isSouthAfrican = isSouthAfrican;
}

public Customer (String title,String firstName,String lastName,String gender, boolean isSouthAfrican){
     
       this.title = title;
       this.firstName = firstName;
       this.lastName = lastName;
       this.gender = gender;
       this.isSouthAfrican = isSouthAfrican;
    }

public void setTitle(String title)
{
	this.title = title;
}

public void setFirstName(String firstName)
{
	this.firstName = firstName;
}

public void setLastName(String lastName)
{
	this.lastName = lastName;
}

public void setGender(String gender)
{
	this.gender = gender;
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

     public boolean isIsSouthAfrican() {
         return isSouthAfrican;
     }

     @Override
     public String toString() {
         return "Customer{" + "title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", isSouthAfrican=" + isSouthAfrican + '}';
     }
 }

