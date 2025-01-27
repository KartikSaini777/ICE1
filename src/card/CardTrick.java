/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for a hardcoded lucky card.
 * To be used as starting code in ICE 1
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
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from Card.SUITS
            magicHand[i] = c;
        }

        // Add a hardcoded lucky card: 7 of Spades
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit("Spades");
        
        // Print the magic hand
        System.out.println("Your magic hand of cards:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        // Check if the lucky card is in the magic hand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Display the result
        if (found) {
            System.out.println("\nCongratulations! The lucky card " + luckyCard.getValue() + " of " + luckyCard.getSuit() + " is in the magic hand!");
        } else {
            System.out.println("\nSorry! The lucky card " + luckyCard.getValue() + " of " + luckyCard.getSuit() + " is not in the magic hand.");
        }
    }
}
