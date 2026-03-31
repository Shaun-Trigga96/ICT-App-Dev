package studentsrun;

  public class Student {
   
      private String name;
      private long studentNumber;
      private double loanAmount;

              
  public Student(){
}         
                         
  public Student(String name,long studentNumber,double loanAmount){
    
       this.name=name;
       this.studentNumber=studentNumber;
       this.loanAmount=loanAmount;
}           

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmont) {
        this.loanAmount = loanAmont;
    }

    @Override
    public String toString() {
        return "Student{" + "Name = " + name + ", Student Number = " + studentNumber + ", Loan Amount = " + loanAmount + '}';
    }
              
    public void show(){
      
      System.out.println("Student Details");
      System.out.println("Name:"+ this.name);
      System.out.println("Student number:"+ this.studentNumber);
      System.out.println("Loan amount:"+ this.loanAmount);
    }
              
              
    public double interest(){
       
      return this.loanAmount*0.5;
    }         
              
              
              
              
              
              

              
 }
