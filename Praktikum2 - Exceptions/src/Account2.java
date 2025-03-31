
public class Account2 {
	private double balance = 0;

	public void put(double amount) throws java.lang.Exception {
		if (amount < 0) {
			throw new java.lang.Exception("Negative Beiträge nicht erlaubt: " + amount);
		}
		balance += amount;
	}

	public void draw(double amount) throws java.lang.Exception {
		if (amount > balance) {
			// Exception-Text gleich hier definieren, denn sonst muss der Aufrufer überlegen, was schief gegangen ist!
			throw new java.lang.Exception("Negative Beiträge nicht erlaubt: " + amount);
		}
		balance -= amount;
	}


	@Override
	public String toString() {
		return String.valueOf(balance);
	}
}
