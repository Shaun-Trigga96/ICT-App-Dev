package VenuesMain;

import java.util.Arrays;

import java.util.*;

            public class VenueControl{

            Venue[] venues = new Venue[20];
            int numberOfVenues=0;
         
   
            public VenueControl(){
            venues[0]= new Venue("Engineering","2.38",80);
            venues[1]= new Venue("Engineering","2.60",60);
            venues[2]= new Venue("Engineering","2.38",80);
            venues[3]= new ComputerLab("Engineering","1.24",40,35);
            venues[4]= new ComputerLab("Engineering","1.24",50,35);
            venues[5]= new ComputerLab("Engineering","1.24",60,35);
            numberOfVenues=6;
        }
            public int menus(){
            
            Scanner kbd = new Scanner(System.in);
            int option;
            
            System.out.println("1:Add room");
            System.out.println("2:Display room");
            System.out.println("3:Display problem labs");
            System.out.println("4:Exit");
            
            option = kbd.nextInt();
            return option;
        }
         
            public Venue createVenue(){
            
            Scanner scn = new Scanner(System.in);
            
            System.out.println("Pease enter Building Name:");
            String buildingName = scn.nextLine();
            System.out.println("Please enter Room Number:");
            String roomNumber = scn.nextLine();
            System.out.println("Please enter Number of Seats:");
            int numberSeats = scn.nextInt();
            
            Venue venue = new Venue(buildingName, roomNumber, numberSeats);

            return venue;
        }       
            
            public ComputerLab createComputerLab(){
            
            Scanner scn = new Scanner(System.in);
            
            System.out.println("Pease enter Building Name:");
            String buildingName = scn.nextLine();
            System.out.println("Please enter Room Number:");
            String roomNumber = scn.nextLine();
            System.out.println("Please enter Number of Seats:");
            int numberSeats = scn.nextInt();
            System.out.println("Please enter Number of Working Computers:");
            int numberWorkingComputers = scn.nextInt();
            
            ComputerLab computerlab = new ComputerLab(buildingName, roomNumber, numberSeats,numberWorkingComputers);
            
            return computerlab;
         }
        
            public void displayAllRooms(){
             
            System.out.println("Displaying all Rooms");
            System.out.println("----------------------");
            for (int i = 0; i < numberOfVenues; i++) {
            System.out.println(venues[i].toString());
            System.out.println("-------------------------");
        }
        }
        
        
            public void problemlab(){
            System.out.println("Problem computer lab");
            for (int i = 0; i <numberOfVenues ; i++) {
            if (venues[i] instanceof Venue) {
                Venue venue = (Venue) venues[i];
            System.out.println(""+ venue.problemVenue());
            System.out.println("" + venue.toString());
            System.out.println("-------------------------");
        }

        }
        }
         
            public void add(){
            
             int choice;
             Venue venue;
             ComputerLab computerlab;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 for normal venue");
            System.out.println("Enter 2 for a computer lab");
               
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                venue = createVenue();
                venues[numberOfVenues] = venue;
                numberOfVenues++;
                break;
            case 2:
                computerlab = createComputerLab();
                venues[numberOfVenues] = computerlab;
                numberOfVenues++;
                break;
            default:
                System.out.println("Wrong choice");
        }
        }

            public void menuControl(){
             
             int option;
             while (true) {
             option = menus();
              switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    displayAllRooms();
                    break;
                case 3:
                    problemlab();
                    break;
                case 4:
                    menus();
                    break;
                case 5:
                    System.out.println("Thank you.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option");
                    System.out.println("Please try again.");
        }
        }
        }
        }   
            