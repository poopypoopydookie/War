import java.util.*;

// static means belonging to class, nonstatic means belonging to instance OF CLASS
class Main {
  
  public static boolean store;
  public static Deck deck;
  public static Hand hand;
  public static ArrayList<Card> p1Deck;
  public static ArrayList<Card> p2Deck;   
  
  public static void main(String[] args) {
      //p1deck = new ArrayList<Card>();
      //p2deck = new ArrayList<Card>(); // problem here? fixed issue with nonstatic in static context
      deck = new Deck();
      deck.fill();
      deck.shuffle();
      // System.out.println(deck);
      // deck.shuffle();
      // Hand tester = new Hand(deck);
      intro();
      //System.out.println(deck);
  }

  public static void intro(){
    // System.out.println("By Jennifer Ju and Aleena Jose: WAR");
    Scanner startGame = new Scanner(System.in);
    System.out.println("Computer or 2Player?");
    String answer = startGame.nextLine();
    if(answer.equals("Computer")){
      computer(); //computer vs player
    }
    else if (answer.equals("2Player")){
      humanVsHuman(); //2players
    }
    else{
      System.out.println("Type Computer or 2Player word for word.");
      intro();
    }
    /*
    while (!answer.equals("2Player") && !answer.equals("Computer")) {
      System.out.println("Please type in exactly 2Player or Computer" );
      intro();
    }*/
  }
  
  public static void humanVsHuman() {
    Hand hand = new Hand(deck);
    int p = 0;
    int count = 0;
    while(hand.Player1.size() != 0 && hand.Player2.size()!= 0){
      System.out.println("Drawing cards..");
      System.out.println("Player1: " + hand.Player1.get(p));
      System.out.println("Player2: " + hand.Player2.get(p));
      if(hand.Player1.get(p).point > hand.Player2.get(p).point){
        //removes the card from player2's deck and puts it into player1's deck 
        System.out.println("Player1 takes it.");
        hand.Player1.add(hand.Player2.get(p));
        hand.Player1.add(hand.Player1.get(0));
        hand.Player1.remove(0);
        hand.Player2.remove(p);
        count++;
      }
      else if(hand.Player1.get(p).point < hand.Player2.get(p).point){
        System.out.println("Player2 takes it.");
        hand.Player2.add(hand.Player2.get(p));
        hand.Player2.add(hand.Player1.get(0));
        hand.Player2.remove(0);
        hand.Player1.remove(p);
        count++;
      }
      else{
        System.out.println("It's a tie. Drawing more cards..");
        p++;
        if(hand.Player1.get(p).point > hand.Player2.get(p).point){
        System.out.println("Player1 takes it.");
        hand.Player1.add(hand.Player2.get(p));
        hand.Player1.add(hand.Player1.get(0));
        hand.Player1.remove(0);
        hand.Player2.remove(p);
        p = 0;
        count++;
      }else if(hand.Player1.get(p).point < hand.Player2.get(p).point){
        System.out.println("Player2 takes it.");
        hand.Player2.add(hand.Player2.get(p));
        hand.Player2.add(hand.Player1.get(0));
        hand.Player2.remove(0);
        hand.Player1.remove(p);
        p = 0;
      }
      }
      
      if(count >= 200){
          Scanner escape = new Scanner(System.in);
          System.out.println("Do you want to escape?");
          String ans = escape.nextLine().toLowerCase();
          if(ans.equals("yes")){
              System.out.println("Cya, it's a draw");
              break;
          }
          else{
              count = 0;
          }
      }
      
    }
    if(hand.Player1.size() == hand.Player2.size()){
        System.out.println("IT'S A TIE, GO AWAY NOW");
    }
    else if(hand.Player1.size() == 0){
        System.out.println("Player2 WON. BYE");
    }
    else if(hand.Player2.size() == 0){
        System.out.println("Player1 WON. BYE");
    }
  }
  
  
  public static void computer(){
    Hand hand = new Hand(deck);
    int p = 0;
    int count = 0;
    while(hand.Player1.size() != 0 && hand.Player2.size()!= 0){
      System.out.println("Drawing cards..");
      System.out.println("Player: " + hand.Player1.get(p));
      System.out.println("Computer: " + hand.Player2.get(p));
      if(hand.Player1.get(p).point > hand.Player2.get(p).point){
        System.out.println("The player takes it.");
        hand.Player1.add(hand.Player2.get(p));
        hand.Player1.add(hand.Player1.get(0));
        hand.Player1.remove(0);
        hand.Player2.remove(p);
        count++;
      }
      else if(hand.Player1.get(p).point < hand.Player2.get(p).point){
        System.out.println("The computer takes it.");
        hand.Player2.add(hand.Player2.get(p));
        hand.Player2.add(hand.Player1.get(0));
        hand.Player2.remove(0);
        hand.Player1.remove(p);
        count++;
      }
      else{
        System.out.println("It's a tie. Drawing more cards..");
        p++;
        if(hand.Player1.get(p).point > hand.Player2.get(p).point){
        System.out.println("The player takes it.");
        hand.Player1.add(hand.Player2.get(p));
        hand.Player1.add(hand.Player1.get(0));
        hand.Player1.remove(0);
        hand.Player2.remove(p);
        p = 0;
        count++;
      }else if(hand.Player1.get(p).point < hand.Player2.get(p).point){
        System.out.println("The computer takes it.");
        hand.Player2.add(hand.Player2.get(p));
        hand.Player2.add(hand.Player1.get(0));
        hand.Player2.remove(0);
        hand.Player1.remove(p);
        p = 0;
      }
      }
      
      if(count >= 200){
          Scanner escape = new Scanner(System.in);
          System.out.println("Do you want to escape?");
          String ans = escape.nextLine().toLowerCase();
          if(ans.equals("yes")){
              System.out.println("Cya, it's a draw");
              break;
          }
          else{
              count = 0;
          }
      }
      
      
    }
    if(hand.Player1.size() == hand.Player2.size()){
        System.out.println("IT'S A TIE, GO AWAY NOW");
    }
    else if(hand.Player1.size() == 0){
        System.out.println("COMPUTER WON. BYE");
    }
    else if(hand.Player2.size() == 0){
        System.out.println("PLAYER WON. BYE");
    }
  }
/*
  public static void displayCard(Card p1, Card p2) {
    System.out.println("Player 1: " + p1);
    System.out.println("Player 2: " + p2);
  }*/
}