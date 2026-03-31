package employeerules;

import java.util.Arrays;


public class EmployeeRulesTest {

    public static void main(String[] args) {
       
        Employee[] employee = new Employee [20];
     
       employee[0]= new Employee("Thabiso");
       employee[1]= new Employee("Luvo");
       employee[2]= new Employee("Shaun");
       employee[3]= new Employee("Patrick");
       employee[4]= new Manager("Gilgamesh");
       employee[5]= new Manager("Saber");
       employee[6]= new Manager("Shiro");
       employee[7]= new Secretary("Namhla");
       employee[8]= new Secretary("Asanda");
       employee[9]= new Secretary("Amanda");
       
       double avrg_salary = 0;
       double total_salary =0;
       int count = 0;
      for(int i=0; i < employee.length; i++) {
    	  
    	  if(employee[i] != null) {
    		  count ++;
    		  total_salary += employee[i].getSalary();
    	  }
    	  else {
    		  break;
    	  }
      }
      avrg_salary = total_salary/count;
      System.out.println(Arrays.toString(employee));
      System.out.println("The avarage salary for our employees per year is:"+avrg_salary);
      System.out.println("The cost of leave to the company is:R" +employee[9].getCostOfLeave());
      
    }    
    
}
