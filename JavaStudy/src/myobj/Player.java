package myobj;

public class Player {

	String name;
	int score;
	int money;
	
	public Player(String name, int score, int money) {
		this.name = name;
		this.score = score;
		this.money = money;
	}
	
	public String getName() {
		return name;
		
	}
	
	public int getScore() {
		return score;
		
	}

	public void updateMoney(int change) {
		money += change;
		
	}
}
