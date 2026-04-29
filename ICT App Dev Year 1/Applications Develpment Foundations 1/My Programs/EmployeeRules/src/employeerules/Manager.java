package employeerules;


public class Manager extends Employee{
	
	private String name; 
	private double salary;
	private int leaveDays;
	private double cost_of_leave;
	
        public Manager(){
	   salary=70000;
	   leaveDays=18;
	}    
	
	public Manager(String name){
	    super(name);
	    salary=70000;
	    leaveDays=18;
	    this.name = name;
	}
	
	@Override
	public double getSalary()
	{
		return salary;
	}
	
	@Override
	public int getLeaveDays()
	{
		return leaveDays;
	}
	
	@Override
	public void leaveApplication(){
		System.out.println(this.name+" applied for a leave waiting for approval from the CEO");
	}
   
	@Override
	public void work(){
		System.out.println(this.name + " knows how to Manage");    
	}
         
        @Override
        public double getCostOfLeave() {
	       this.cost_of_leave = (this.salary / (super.getHours()*52)) * ((this.leaveDays/5)*super.getHours());
	    
               return cost_of_leave;
        }
	@Override
	public String toString()
	{
		return "Manager [Name=" + name + ", Salary= R" + salary + ",Hours=" +super.getHours()+", LeaveDays=" + leaveDays + "]";
	}
	
	
}
