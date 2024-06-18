package myobj.prizedraw;

public class Prize {

	private String name;
	private int value;
	private int quantity;
	private double winProbability;
	
	public Prize(String name, int value, int quantity, double winProbability) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
		this.winProbability = winProbability;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public double getwinProbability() {
		return winProbability;
	}
	
	public void setwinProbability(double winProbability) {
		this.winProbability = winProbability;
	}
	
	public boolean decreaseQuantity() {
		if (quantity > 0) {
			quantity--;
			return true;
		}
		return false;
	}
}
