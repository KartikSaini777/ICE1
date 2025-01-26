/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Kartik Saini
 * @studentNumber 991763064
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        // Fill magicHand with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
           
            c.setValue(random.nextInt(13) + 1);
            
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }

        // Add a hard-coded lucky card: 7 of Spades
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Spades");
        
       
        System.out.println("Your magic hand of cards:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
        
        // Ask the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPick a card by entering its value (1-13) and suit (Hearts, Diamonds, Spades, Clubs).");
        System.out.print("Enter value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.next();

        // Create the user's card based on input
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Search for the card in the magic hand
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                cardFound = true;
                break;
            }
        }
        
        // Report the result
        if (cardFound) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
        
        // Check for the lucky card: 7 of Spades
        if (userCard.getValue() == luckyCard.getValue() && userCard.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
            System.out.println("Congratulations! You've picked the lucky card: 7 of Spades!");
        }
    }
}