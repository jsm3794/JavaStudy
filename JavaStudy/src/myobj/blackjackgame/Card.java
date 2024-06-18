package myobj.blackjackgame;

public class Card {

	private String suit;
	private String rank;
	
	public Card(String suits, String ranks) {
		this.suit = suits;
		this.rank = ranks;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return suit + " " + rank;
	}
}