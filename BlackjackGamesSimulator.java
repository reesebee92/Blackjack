
/**
 * BlackjackGamesSimulator class 
 * 
 * This Blackjack Simulation will allow a user to play against the house/dealer
 * and potential win or lose money. This class extends DeckOfCards which extends
 * Card. An object DeckOfCards will be created for the virtual dealer to use during
 * the game. Enjoy!
 * 
 * @author sDantzler
 */

import java.io.*;
import java.util.Scanner;

public class BlackjackGamesSimulator extends DeckOfCards {

   public static void main(String[] args) {

      // int array and int variables needed to play the game
      int[] totalMoney = new int[1];
      int bet, totalValue1, totalValue2;

      // player's hand and card variables used track to throughout the game
      String playerHand, dealerHand;
      Card card1, card2, card3, card4;

      // Scanner initializations
      Scanner input = new Scanner(System.in);
      Scanner hit = new Scanner(System.in);
      Scanner stay = new Scanner(System.in);
      Scanner yes = new Scanner(System.in);
      Scanner no = new Scanner(System.in);

      // Create a deck of cards and shuffle for the game
      DeckOfCards deck = new DeckOfCards();
      deck.shuffle();

      // Start the user interaction experience
      System.out.println(
            "Hello, I will be your dealer for Blackjack, so let's get started!\n");

      // prompt the user enter the amount of money they have total
      System.out.println(
            "Enter the total amount of money you have available to play with: ");
      totalMoney[0] = input.nextInt();

      // Playing the game until money runs out or user exits the Play label
      Play: while (totalMoney[0] != 0) {
         // Prompt user to place their bet
         System.out.println();
         System.out.println("Place your bet!");
         bet = input.nextInt();

         // if the bet is incorrect prompt the user to enter until correct
         while (bet > totalMoney[0] || bet < 1) {
            System.out.print(
                  "\nIncorrect bet, please enter a legal bet between 1 and "
                        + totalMoney[0] + ": \n");
            bet = input.nextInt();
         }

         // deal 2 cards for player
         card1 = dealCard();
         card2 = dealCard();

         // reset the rank value to allow for automatic Blackjack
         setAceValueHigher(card1, card2);

         // tally total rank for player and display hand
         totalValue1 = card1.getValue() + card2.getValue();

         playerHand = card1.toString() + ", " + card2.toString();
         System.out.println("\nHere is your current hand: " + playerHand);

         // instant win
         if (totalValue1 == 21) {
            System.out.print("Blackjack! ");
            win(bet, totalMoney);
            if (yes.nextLine().toLowerCase().contentEquals("yes")) {
               continue;
            } else {
               break Play;
            }
         } // end if

         // If no instant win show dealer's one card
         card3 = dealCard();
         card4 = dealCard();
         setAceValueHigher(card3, card4);

         // tally total rank for dealer and display partial hand
         totalValue2 = card3.getValue() + card4.getValue();

         dealerHand = card3.toString();
         System.out.println("The dealer is showing: " + dealerHand);

         // User has the option to hit or stay
         System.out
               .println("Do you want to hit or stay?: Enter [hit] or [stay]");

         // while hit is the next inputed String
         while (hit.nextLine().contentEquals("hit")) {

            // deal cards until an outcome is achieved
            card1 = dealCard();
            totalValue1 = totalValue1 + card1.getValue();
            playerHand = playerHand + ", " + card1.toString();
            System.out.println("\nYour new hand is " + playerHand);

            if (totalValue1 > 21) {
               lose(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  continue;
               } else {
                  break Play;
               }
            } else if (totalValue1 == 21) {
               win(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  continue;
               } else {
                  break Play;
               }
            } else {
               System.out.println("You're still under 21! "
                     + "Do you want to hit or stay? Enter [hit] or [stay]:");
            }
         } // end hit while loop

         while (totalValue2 <= 21 && totalValue1 < 21) {

            // if player doesn't win or lose from hitting it's the dealer's turn
            dealerHand = "\n" + card3.toString() + ", " + card4.toString();
            System.out.println("The dealer's current hand is: " + dealerHand);

            while (totalValue2 < 17) {

               // deal until dealer's hand is < 17
               card3 = dealCard();
               totalValue2 = totalValue2 + card3.getValue();
               dealerHand = dealerHand + ", " + card3.toString();
               System.out
                     .println("The dealer's current hand is: " + dealerHand);

            } // end dealer hit while loop

            // determine who wins between the player and dealer
            if (totalValue2 == 21) {
               lose(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  break;
               } else {
                  break Play;
               }
            } else if ((totalValue1 > totalValue2) && totalValue1 < 21) {
               win(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  break;
               } else {
                  break Play;
               }
            } else if ((totalValue2 > totalValue1) && totalValue2 < 21) {
               lose(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  break;
               } else {
                  break Play;
               }
            } else if (totalValue1 == totalValue2 && totalValue1 <= 21) {
               draw();
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  break;
               } else {
                  break Play;
               }
            } else {
               System.out.print("Dealer bust!");
               win(bet, totalMoney);
               if (yes.nextLine().toLowerCase().contentEquals("yes")) {
                  break;
               } else {
                  break Play;
               }
            } // end winner if-else if statements
         } // end while loop

         if (no.nextLine().toLowerCase().contentEquals("no")) {
            break Play;
         }
      } // end while totalMoney > 0 or player exits while loop

      // if the user ran out of money
      if (totalMoney[0] == 0) {
         System.out.println("Sorry you ran out of money!");
      }
      System.out.println(
            "Thanks for playing! \nYour cash value is: $" + totalMoney[0]);

      // close all the Scanners
      no.close();
      yes.close();
      hit.close();
      stay.close();
      input.close();

   }// end main method

   /**
    * setAceValueHigher method
    * 
    * This method returns a rank of 11 when an Ace is the first card
    * 
    * @param card1, card2
    */
   public static void setAceValueHigher(Card card1, Card card2) {

      if ((card1.getRank() == 1) && (card2.getRank() >= 10)) {
         card1.setValue(11);
      }
      if ((card2.getRank() == 1 && card1.getRank() >= 10)) {
         card2.setValue(11);
      }

   }// end setAceValueHigher method

   /**
    * win method
    * 
    * This method updates a player's bet money after a win
    * 
    * @param bet, totalMoney[]
    */
   public static void win(int bet, int[] totalMoney) {
      System.out.println("You win!");
      totalMoney[0] = totalMoney[0] + (int) (bet * 1.5);
      System.out.println("\nWould you like to keep playing");
   }// end win method

   /**
    * lose method
    * 
    * This method updates a player's bet money after a loss
    * 
    * @param bet, totalMoney[]
    */
   public static void lose(int bet, int[] totalMoney) {
      System.out.println("You lose!");
      totalMoney[0] = totalMoney[0] - (int) bet;
      System.out.println("\nWould you like to keep playing");
   }// end lose method

   /**
    * draw method
    * 
    * This method prompts a user after a draw
    * 
    */
   public static void draw() {
      System.out.println("Draw!");
      System.out.println("Would you like to keep playing");
   }// end draw method

}// end class BlackjackGamesSimulator
