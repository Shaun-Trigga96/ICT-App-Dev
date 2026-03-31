package studentaccount;

public class Student {
    private String studentName;
    private String studentCourse;
    private double balance;


public Student(String studentName,String studentCourse, double balance){
this.studentName = studentName;
this.studentCourse = studentCourse;
this.balance = balance;
}
String getstudentName(){
    return this.studentName;
}
String getstudentCourse(){
    return this.studentCourse;
}
double setbalance(){
    return this.balance;
}
 
public String toString()
{
String str = String.format("Student Name: %s \nStudent Course: %s \nBalance:R %f", this.studentName, this.studentCourse, this.balance);
return str;
}
}