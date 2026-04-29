package tournamentrun;

public class Rugby extends Team {
    
    private int tries;

 
       public Rugby(){ 
   }
   
       public Rugby(String name,int gamesWon,int gamesLost,int gamesTied,int tries){
    
        super(name, gamesWon, gamesLost,gamesTied);
         this.tries=tries;
    }

       public int getTries() {
        return tries;
    }

      public void setTries(int tries) {
        this.tries = tries;
    }

      @Override
      public String toString() {
        return super.toString()+"Rugby{" + "tries=" + tries + '}';
    }

      @Override
        public void dispalyDetail(){
       
         super.dispalyDetail();
         System.out.println("Tries:" + this.tries);
     
     }
    









}