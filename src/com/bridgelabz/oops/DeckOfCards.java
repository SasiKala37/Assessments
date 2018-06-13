/**
 * Purpose:a Program DeckOfCards.java, to initialize deck of cards having suit ("Clubs", "Diamonds", 
 * "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"). 
 * Shuffle the cards using Random method and then distribute 9 Cards to 4 Players and 
 * Print the Cards the received by the 4 Players using 2D Array…
 * 
 * @author SasiKala
 * @version 1.0
 * @since 08-06-2018
 */

package com.bridgelabz.oops;

import com.bridgelabz.utility.Utility;

public class DeckOfCards {

	static String[] SUIT = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] RANK = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	static String[][] deck = new String[SUIT.length][RANK.length];

	public static void main(String[] args) {
		Utility utility = new Utility();
		Utility.cardsIntialization(deck, SUIT, RANK);
		Utility.shufflingCards(deck, SUIT.length, RANK.length);
		Utility.printingcards(deck);
		/*
		 * System.out.println("Deck of cards in queue"); utility.addCardsToQ(deck);
		 */
	}
}
