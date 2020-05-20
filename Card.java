/**
 * Card class
 * 
 * This class will create a Card Object with a suit, rank, and value. There are
 * two constructors provided with the mentioned initializations. There are seven
 * method operations available for use.
 * 
 * @author sDantzler
 */
public class Card {

   // instance variable
   private final int suit;
   private int rank, value;

   // final integers for switch statement
   public final static int SPADES = 0;
   public final static int CLUBS = 1;
   public final static int HEARTS = 2;
   public final static int DIAMONDS = 3;

   Card() {

      this.suit = -1;
      this.rank = -1;
      this.value = -1;
   }// end default constructor

   Card(int suit, int rank) {

      this.suit = suit;
      this.rank = rank;
      this.value = rank;

   }// end parameterized constructor

   /**
    * getRank method
    * 
    * Returns the rank for a Card
    */
   public int getRank() {
      return rank;
   }// end getRank method

   /**
    * getRankString method
    * 
    * Returns the String rank for a Card
    */
   public String getRankString() {
      switch (rank) {
         case 1:
            return "Ace";
         case 2:
            return "2";
         case 3:
            return "3";
         case 4:
            return "4";
         case 5:
            return "5";
         case 6:
            return "6";
         case 7:
            return "7";
         case 8:
            return "8";
         case 9:
            return "9";
         case 10:
            return "10";
         case 11:
            return "Jack";
         case 12:
            return "Queen";
         case 13:
            return "King";
         default:
            return "Ace";
      }// end switch
   }// end getRankString method

   /**
    * getSuit method
    * 
    * Returns the suit for a Card
    */
   public int getSuit() {
      return suit;
   }// end getSuit method

   /**
    * getSuitString method
    * 
    * Returns the String suit for a Card
    */
   public String getSuitString() {

      switch (suit) {
         case SPADES:
            return "Spades";
         case CLUBS:
            return "Clubs";
         case HEARTS:
            return "Hearts";
         case DIAMONDS:
            return "Diamonds";
         default:
            return "";
      }// end switch

   }// end getSuitString method

   /**
    * getValue method
    * 
    * Gets the value for a Card
    */
   public int getValue() {
      if (rank > 10) {
         value = 10;
      }
      return value;
   }// end getValue method

   /**
    * setValue method
    * 
    * Sets the value for a Card
    */
   public void setValue(int newRank) {
      value = newRank;
   }// end setRank method

   /**
    * toString method
    * 
    * Returns the string value of a Card
    */
   public String toString() {
      return getRankString() + " of " + getSuitString();
   }// end toString method

}// end Card class
