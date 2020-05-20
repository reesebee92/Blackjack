# Blackjack

The purpose of this porject was to understand the importance behind object oriented programming and put it to use! This project demonstrates encapsulation and inheiritance.

Design

The specifications of the program are to simulate a Blackjack game with a user with console based output. My original design was to create a DeckOfCards class to create an object within the BlackjackGameSimulator class. My DeckOfCards class will include 4 methods: shuffle() to shuffle the deck, dealCard() to deal a card, reset() to start a new deck and shuffle() it, and cardsRemaining() to track where the dealer is in the deck. The BlackjackGameSimulator class will include the main method to go through the different scenarios of playing a one on one game. The main method will start by asking a user how much money they have and using that amount to play the game until the money runs out or the player no longer wants to play.

Final Design with Changes

Once I began to code the program, there were several flaws and I had to change the design a bit. When I attempted to write the code I noticed that I was having a huge difficulty in retrieving the suit and rank with only a DeckOfCard object available for reference. I finally decided that I would have to create a Card class where I can control the values present for each card in order to use them. Once I created this class my code was a lot easier to write. However, I ran into another issue where I was unable to set the new value of a card without changing the rank. Thus, I added another variable in the constructors within the Card class, which fixed the problem immediately. The last issue I encountered was cleaning up my code and eliminating repeated print statements and getting my program to run smoothly. I did fix this eventually by making sure each scenario was covered and playing the game over and over again! See the UML design below for my final program design.

What I Learned

The biggest thing I learned doing this project is how important it is to define a superclass to the fullest to get the most out of the methods and operations within the subclass(es).
