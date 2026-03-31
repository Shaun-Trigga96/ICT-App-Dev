package VenuesMain;

   public class Venue {
   
   private String buildingName;
   private String roomNumber;
   private int numberSeats;

   public Venue(){
   }

   public Venue(String buildingName, String roomNumber, int numberSeats){
     
       this.buildingName=buildingName;
       this.roomNumber=roomNumber;
       this.numberSeats=numberSeats;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public int getNumberSeats() 
    {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) 
    {
        this.numberSeats = numberSeats;
    }

    
    public String toString() 
    {
        return"Venue{" + "Building Name=" + buildingName + ", Room Number=" + roomNumber + ", Number of Seats=" + numberSeats + '}';
    }
     
    public void show(){
        System.out.println("Bulding Name:"+ this.buildingName);
        System.out.println("Venue number:"+ this.roomNumber);
        System.out.println("Number of Seats"+ this.numberSeats);
    }

    public boolean problemVenue(){
       return false;   
}
}    