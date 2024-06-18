package myobj.omokgame;

public class OmokPlayer {

	String name;
	char stone;
	
	public OmokPlayer(String name, char stone) {
		this.name = name;
		this.stone = stone;
	}
	
	public String getName() {
		return name;
	}
	
	public char getStone() {
		return stone;
	}
}
