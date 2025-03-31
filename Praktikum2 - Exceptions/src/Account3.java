
public class Account3 {
	private double balance = 0;

	public void put(double amount) throws NegativeAmountException{
		if (amount < 0) {
			throw new NegativeAmountException("Negative Beiträge nicht erlaubt: " + amount);
		}
		balance += amount;
	}

	public void draw(double amount) throws InsufficientBalanceException{
		if (amount > balance) {
			// Exception-Text gleich hier definieren, denn sonst muss der Aufrufer überlegen, was schief gegangen ist!
			throw new InsufficientBalanceException("Kontostand reicht nicht aus: " + balance);
		}
		balance -= amount;
	}


	@Override
	public String toString() {
		return String.valueOf(balance);
	}
}

class NegativeAmountException extends Exception { // Helferklasse
	public NegativeAmountException() {
		super();
	}

	public NegativeAmountException(String s) {
		super(s);
	}
}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
		super();
	}
	
	public InsufficientBalanceException(String s) {
		super(s);
	}
}

