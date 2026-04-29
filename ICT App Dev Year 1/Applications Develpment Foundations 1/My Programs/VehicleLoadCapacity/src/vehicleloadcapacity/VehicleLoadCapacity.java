package vehicleloadcapacity.src.vehicleloadcapacity;

import java.util.*;

public class VehicleLoadCapacity {


    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int mass1, mass2, mass3, totMass, maxLoad, capNum;
        
        String load1, load2, load3;
        System.out.println("Please enter maximum load capacity of vehicle: ");
        maxLoad = kbd.nextInt();
        System.out.println(" ");
      
         System.out.println("Please enter name of the first load: ");
         load1 = kbd.nextLine();
         
         System.out.println("Please enter name of the second load: ");
         load2 = kbd.nextLine();
         
         System.out.println("Please enter name of the third load: ");
         load3 = kbd.nextLine();
         
         System.out.println("Please enter mass of the first load: ");
         mass1 = kbd.nextInt();
         System.out.println("Please enter mass of the second load: ");
         mass2 = kbd.nextInt();
         System.out.println("Please enter mass of the third load: ");
         mass3 = kbd.nextInt();
         
        totMass = mass1 + mass2 + mass3;
        
         System.out.println(load1 +" : " + mass1 + "kg");
         System.out.println(load2 +" : " + mass2 + "kg");
         System.out.println(load3 +" : " + mass3 + "kg");
         System.out.println("The total mass is "+totMass+ "kg");
  
         if ( totMass<=maxLoad ){
             capNum=maxLoad-totMass;  
             System.out.println("The available mass is" +capNum );
              
         }else if (totMass>maxLoad){
             capNum =maxLoad-totMass;
             System.out.println("You have exceeded the maximum load capacity by : " + capNum+ "kg"); 
             
         }
         
         
         
          
                 
                 
         
        
        
                
        
        
        
                
                
        
        
        
        
        
        
        
    }
    
}
