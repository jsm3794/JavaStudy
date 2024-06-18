package myobj.blackjackgame;

import java.util.ArrayList;
import java.util.List;

import quiz.D06_BlackJack;

public class Player {

	private List<Card> hand;
	
	public Player() {
	hand = new ArrayList<>();	
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void hit() {
		System.out.println("Hit를 선택하였습니다.");
		addCard(D06_BlackJack.deck.drawCard());
	}
	
	public void stand() {
		System.out.println("Stand를 선택하였습니다.");
	}
}
