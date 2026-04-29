package tournamentrun;

   public class Netball extends Team {
    
    private int goalsFor;
    private int goalsAgaints;

  
    public Netball(){
  }

    public Netball(String name,int gamesWon,int gamesLost,int gamesTied,int goalsFor,int goalsAgaints){
       
        super(name, gamesWon, gamesLost,gamesTied);
        this.goalsFor=goalsFor;
        this.goalsAgaints=goalsAgaints;
  }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgaints() {
        return goalsAgaints;
    }

    public void setGoalsAgaints(int goalsAgaints) {
        this.goalsAgaints = goalsAgaints;
    }

    @Override
    public String toString() {
        return super.toString()+ "Netball{" + "Goals For = " + goalsFor + ", Goals Againts = " + goalsAgaints + '}';
    }
  
    @Override
     public void dispalyDetail(){
     
        super.dispalyDetail();
        System.out.println("Goals For:" + this.goalsFor);
        System.out.println(" Goals Againts:" + this.goalsAgaints);
     }  
     }
