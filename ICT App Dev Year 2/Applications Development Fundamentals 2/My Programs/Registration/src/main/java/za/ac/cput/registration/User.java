/**
 * User.java
 * This my user class
 * @author Thabiso Matsaba
 * 28 April 2021
 */
package za.ac.cput.registration;

public class User {
    
    private String Title;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Email;
    private String Passowrd;
    private String ConfirmPassword;
    private String Terms;

    public User (String Title,String FirstName,String LastName,String Gender,String Email, String Passowrd,String ConfirmPassword,String Terms){
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassowrd() {
        return Passowrd;
    }

    public void setPassowrd(String Passowrd) {
        this.Passowrd = Passowrd;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

    public String getTerms() {
        return Terms;
    }

    public void setTerms(String Terms) {
        this.Terms = Terms;
    }
    
    
}
