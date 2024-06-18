package myobj.blackjack;

public class Card {

	final static char[] SUITS = {'♡', '◇', '♠', '♣'};
	final static String[] RANKS = {"2", "3", "4", "5", "6", "7", 
			"8", "9", "10", "A", "J", "Q", "K"};
	final static int[] VALUES = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	final public static int NUM_OF_SUITS = SUITS.length;
	final public static int NUM_OF_RANKS = RANKS.length;
	
	int suit; // ♡, ◇, ♠, ♣
	int rank; // A ~ K
	
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getValue() {
		return VALUES[rank];
	}
	
	@Override
	public String toString() {
		return String.format("%c%s", SUITS[suit], RANKS[rank]);
	}
	
	public static void main(String[] args) {
		System.out.println(new Card(0, 5));
	}
}
