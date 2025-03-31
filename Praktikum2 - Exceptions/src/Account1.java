
public class Account1 {
	private double balance = 0;
	
	public void put(double amount) {
		balance += amount;
	}
	
	public void draw(double amount) {
		balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Guthaben: " + balance;
	}
}
