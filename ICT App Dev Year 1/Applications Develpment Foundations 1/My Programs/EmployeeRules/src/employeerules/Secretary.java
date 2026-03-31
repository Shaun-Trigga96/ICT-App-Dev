package employeerules;

public class Secretary extends Employee{
    private double hours;
    private String name;
    private double cost_of_leave;
    
	public Secretary(){	
	}

	public Secretary(String name){
	    super(name); 
	    this.name = name;
	    this.hours = 40.0;
	}
	
	@Override
	public double getHours()
	{
		return hours;
	}
	
	@Override
	public void work(){
		System.out.println(this.name + " knows how to type");    
	}
        
    @Override
        public double getCostOfLeave() {
	       this.cost_of_leave = (super.getSalary() / (this.hours*52)) * ((super.getLeaveDays()/5)*this.hours);
	    
               return cost_of_leave;
        }       
	@Override
	public String toString()
	{
		return "Secretary [Name=" + name +", Salary= R" + super.getSalary()+", Hours=" + hours + ", LeaveDays=" + super.getLeaveDays() + "]";
	}
	
	
}
