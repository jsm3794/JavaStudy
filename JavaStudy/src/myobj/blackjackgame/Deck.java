package myobj.blackjackgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		initializeDeck();
		shuffle();
	}

	private void initializeDeck() {
		String[] suits = {"♡", "◇", "♠", "♣"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
		
		for (String suit : suits) {
			for (String rank : ranks) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	private void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card drawCard() {
		return cards.remove(0);
	}
}
