package myobj.blackjackgame;

import java.util.ArrayList;
import java.util.List;

import quiz.D06_BlackJack;

public class Dealer {

private List<Card> hand;
	
	public Dealer() {
	hand = new ArrayList<>();	
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void play() {
		while (calcHandValue() <= 16) {
			System.out.println("딜러가 Hit를 선택하였습니다.");
			addCard(D06_BlackJack.deck.drawCard());
		}
		System.out.println("딜러가 Stand를 선택하였습니다.");
	}
	
	public int calcHandValue() {
		int value = 0;
		int numOfAces = 0;
		for (Card card : hand) {
			String rank = card.getRank();
			if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
				value += 10;
			} else if (rank.equals("A")) {
				numOfAces++;
				value += 11;
			} else {
				value += Integer.parseInt(rank);
			}
		}
		while (value > 21 && numOfAces > 0) {
			value -= 10;
			numOfAces--;
		}
		return value;
	}
}
