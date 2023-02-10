import java.util.Random; //generate rrandom number for shuffling


public class Deck {
  Card[] decky;
  Random rand;
  public Deck() {
    decky = new Card[54];
    rand = new Random();
  }

  //fills the deck up 
  public Card[] fill() {
    for(int i = 0; i < 13; i++){
      for(int j = 0; j<4; j++){
        decky[i*4+j] = new Card(i);
      }
    }
    decky[52] = new Card(13);
    decky[53] = new Card(13);
    return decky;
  }
  //shuffles the deck
  public void shuffle(){
     for(int i = 0; i < 54; i++){
         int c = (int)(Math.random()*54);
         Card a = decky[c];
         decky[c] = decky[i];
         decky[i] = a;
     }
  }
  //stringifies
  public String toString() {
    String str = "";
    for(int i = 0; i< decky.length;i++){
      str+= "" + decky[i];
    }
    return str;
  }
}