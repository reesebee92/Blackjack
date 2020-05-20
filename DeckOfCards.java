/**
 * DeckOfCards class
 * 
 * This class will create a deck of 52 cards by suit and rank using a Card
 * object. There is a constructor used provided with the initializations for the
 * deck and remaining cards. There are four method operations available for use.
 * 
 * @author sDantzler
 */
public class DeckOfCards extends Card {

   // instance variables
   private static final int DECK_SIZE = 52;
   private static int cardsRemaining;
   private static Card[] deck;

   public DeckOfCards() {
      super();
      deck = new Card[DECK_SIZE];
      cardsRemaining = 0;
      // initializes the deck with values from ace of spades to King of diamonds
      for (int rank = 1; rank < 14; rank++) {
         for (int suit = 0; suit < 4; suit++) {
            deck[cardsRemaining] = new Card(suit, rank);
            cardsRemaining++;
         }
      } // end for loop

      // current count of cards in the deck
      cardsRemaining = DECK_SIZE;
   }// end constructor

   /**
    * shuffle method
    * 
    * Shuffle the cards in the deck using a random index
    * 
    */
   public static void shuffle() {

      Card temp;
      int randIndex;

      for (int loopIndex = 0; loopIndex < deck.length; loopIndex++) {
         // Generate a random index
         randIndex = (int) (Math.random() * deck.length);

         temp = deck[loopIndex];
         deck[loopIndex] = deck[randIndex];
         deck[randIndex] = temp;
      } // end for loop

   }// end shuffle method

   /**
    * cardsRemaining method
    * 
    * Returns the number of cards left in the deck
    * 
    * @return remaining cards value
    */
   public int cardsRemaining() {
      return DECK_SIZE;
   }// end cardsRemaining method

   /**
    * dealCard method
    * 
    * Checks to make sure there are cards remaining in the deck and if not the
    * deck will reset and then the deck will return a card from the deck
    * 
    * @return one card value
    */
   public static Card dealCard() {

      if (cardsRemaining == 0) {
         reset();
      }
      cardsRemaining--;
      return deck[cardsRemaining];

   }// end deal method

   /**
    * reset method
    * 
    * Shuffle the cards in the deck and reset the cardsRemaining value back to
    * the original deck size
    */
   public static void reset() {
      shuffle();
      cardsRemaining = DECK_SIZE;
   }// end reset method

}// end of class DeckOfCards
