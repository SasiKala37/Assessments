package com.bridgelabz.oops;

import com.bridgelabz.utility.Utility;

public class DeckOfCards {

	 static String[] SUIT= {"Clubs","Diamonds", "Hearts", "Spades"};
	    static String[] RANK= {"2", "3", "4", "5", "6", "7", "8", "9", "10",
	            "Jack", "Queen", "King", "Ace"    };
	    static String[][] deck=new String[SUIT.length][RANK.length];
	    public static void main(String[] args) {
	    	Utility utility=new Utility();
	        Utility.cardsIntialization(deck,SUIT,RANK);
	        Utility.shufflingCards(deck, SUIT.length,RANK.length);
	        //Utility.printingcards(deck);
	        /*System.out.println("Deck of cards in queue");
	        utility.addCardsToQ(deck);*/
	    }
}
