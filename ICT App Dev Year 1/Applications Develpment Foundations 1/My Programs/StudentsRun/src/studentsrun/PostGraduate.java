package studentsrun;

      public class PostGraduate extends Student {
    
       private String thesis;
    
   
      public PostGraduate(){
   }
   
   
      public PostGraduate(String name,long studentNumber,double loanAmount,String thesis){
      
       super(name,studentNumber,loanAmount);
       this.thesis=thesis;
   }

      public String getThesis() {
        return thesis;
   }

      public void setThesis(String thesis) {
        this.thesis = thesis;
   }
     
     @Override
    public String toString() {
        return "PostGraduate{" + "Name = " + super.getName() + ", Student Number = " + super.getStudentNumber() + ", Loan Amount = " + super.getLoanAmount() + ", Thesis = " + this.thesis + '}';
    }
          
   
      @Override
      public void show(){
      super.show();
      System.out.println("Thesis:"+ this.thesis);
    }

       @Override
      public double interest(){
       
        return super.getLoanAmount()*0.1;
    }         
    }
  