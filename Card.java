public class Card{ //neenu and jennys card class
  public static String values;
  public char cv; 
  public int point;

  public Card(int v){
    values = "23456789TJQKAX"; //card values
    cv = values.charAt(v); //gets character at that index
    point = v; //keeps track of how much that card is worth, used to compare later in the game
  }

  //stringifies card
  public String toString(){
    return "" + cv;
  }
}
//ry was here
