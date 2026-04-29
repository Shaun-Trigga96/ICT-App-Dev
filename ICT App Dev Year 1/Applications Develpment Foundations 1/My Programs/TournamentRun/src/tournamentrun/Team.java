package tournamentrun;

public class Team {
    
 private String name;
 private int gamesWon;
 private int gamesLost;
 private int gamesTied;
 
 public Team(){
}

    public Team(String name,int gamesWon,int gamesLost,int gamesTied){
     
      this.name=name;
      this.gamesWon=gamesWon;
      this.gamesLost=gamesLost;
      this.gamesTied=gamesTied;
}

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesTied() {
        return gamesTied;
    }

    public void setGamesTied(int gamesTied) {
        this.gamesTied = gamesTied;
    }

    @Override
    public String toString() {
        return "Team{" + "Name = " + name + ", Games Won = " + gamesWon + ", Games Lost = " + gamesLost + ", Games Tied = " + gamesTied + '}';
    }

    public void dispalyDetail(){
     
     System.out.println("Tournament Games");
     System.out.println("---------------");
     System.out.println("Name:" + this.name);
     System.out.println("Games Won:" + this.gamesWon);
     System.out.println("Games Lost:" + this.gamesLost);
     System.out.println("Games Tied:" + this.gamesTied);
 
    }
     
    }
