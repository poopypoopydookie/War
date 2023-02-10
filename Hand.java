import java.util.ArrayList;

public class Hand{
  //decks for the two players
  ArrayList<Card> Player1 = new ArrayList<Card>();
  ArrayList<Card> Player2 = new ArrayList<Card>();
  //should distribute half of the cards to one player, and half to another
  public Hand(Deck shuffler){
    
    //iterates through the deck
    for(int i = 0; i < shuffler.decky.length; i++ ){
      if(i%2 == 0){ 
        //System.out.println(shuffler.decky[i]);
        Player1.add(shuffler.decky[i]);
      }
      else{
        Player2.add(shuffler.decky[i]);
      }
    }
  }
}