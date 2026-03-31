
package arraysofcards;

public class ArraysOfCards {


    public static void main(String[] args) {
        
       String[] deck = new String [52]; 

       String[] rank = {"2", "3", "4", "5","6","7","8","9","10","J","Q", "K","A"};
    
       String[] suit ={"♠","♡","♢","♣"}; 
  
      for (int i = 0; i<suit.length; i++ ){
      
           for (String rank1 : rank) {
           }
          System.out.printf("(%d)","(%d)",1,deck[i]);
      }
    }
  }

      
    

