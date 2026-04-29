package employeerules;

    public class Employee {
   
    private String name; 
    private double salary;
    private double hours;
    private int leaveDays;
    private double cost_of_leave;

    public Employee(){
   }

   public Employee(String name){
	   this.name=name;
	   this.salary=50000.0;
	   this.hours=37.5;
	   this.leaveDays=15;
   }
   public void setName(String name){
	   this.name=name;
   }
   public String getName(){
	   return this.name;
   }

   public double getSalary(){
	   return this.salary;
   }
         
   public void setSalary(double salary) {
        this.salary = salary;
   }

   public double getHours(){    
	   return this.hours; 
   }       
         
   public void setHours(double hours) {
	   this.hours = hours;
    } 
       
   public int getLeaveDays(){
	   return this.leaveDays;
   }
  
   public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
   }
   
   public void leaveApplication(){
	   System.out.println(this.name+" applied for a leave");
   }
   
   public double getCostOfLeave() {
	   this.cost_of_leave = (this.salary / (this.hours*52)) * ((this.leaveDays/5)*this.hours);
	   return cost_of_leave;
   }
      
   public void work(){
       System.out.println(this.name + " knows how to work");    
   }

   @Override
   public String toString()
   {
	return "Employee [Name=" + name + ", Salary= R" + salary + ", Hours=" + hours + ", LeaveDays=" + leaveDays + "]";
   }
}    

