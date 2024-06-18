package example;

import java.util.Random;

public class RandomCard {

	public class Main {
			
			public enum Rank {
				ace, two, three, four, five, six, seven, eight, nine, ten, jack, king, queen
			}
			
			public enum Suit {
				hearts, diamonds, clovers, spades
			}
		}
		
		public static void main(String[] args) {
			
			Random random = new Random();
			
			Main.Rank randomRank = Main.Rank.values()[random.nextInt(Main.Rank.values().length)];
			Main.Suit randomSuit = Main.Suit.values()[random.nextInt(Main.Suit.values().length)];
			
			System.out.println("Random card: " + randomRank + " " + randomSuit);
	
		}
}
