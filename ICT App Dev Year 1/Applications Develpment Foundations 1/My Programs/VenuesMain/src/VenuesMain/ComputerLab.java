package VenuesMain;

    public class ComputerLab extends Venue{
    
         private int numberWorkingComputers;

        public ComputerLab(){
        }

        public ComputerLab(String buildingName, String roomNumber, int numberSeats,int numberWorkingComputers)
        {
            super(buildingName,roomNumber,numberSeats);
        this.numberWorkingComputers=numberWorkingComputers;    
        }

        public int getNumberWorkingComputers() 
        {
        return numberWorkingComputers;
        }

        public void setNumberWorkingComputers(int numberWorkingComputers) 
        {
        this.numberWorkingComputers = numberWorkingComputers;
        }

        
        @Override
        public String toString() {
            
        return "ComputerLab{" + "Building Name=" + super.getBuildingName() + ", Room Number=" + super.getRoomNumber() + ", Number Seats=" + super.getNumberSeats() + ", Number Working Computers=" + this.numberWorkingComputers + '}';
       }

        @Override
        public void show(){
        super.show();
        System.out.println("Number of Working Computers"+ this.numberWorkingComputers);
        
        }

        @Override
        public boolean problemVenue(){
             return super.getNumberSeats() > this.numberWorkingComputers;
       }
       }
       