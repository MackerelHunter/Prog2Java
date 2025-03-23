
public class SmartNumber {

	private double number;

	public SmartNumber (double number) {
		this.number = number;
	}

	public SmartNumber () {
		this(1.0);
	}

	public void setNumber (double number) {
		this.number = number;
	}

	public double getNumber () {
		return number;
	}
	// könnte statisch geschrieben werden, da die Methode einen Parameter hat
	public boolean isInteger (double x) {
		return ((x%1)==0)? true : false;
	}

	public boolean isEven() {
		if (!isInteger(number)) {
			return false;
		}
		return ((number%2)==0)? false : true;
	}
	
	//Vorgehen nach dem Prinzip der Probedivision
	//https://de.wikipedia.org/wiki/Probedivision#Beispiel
	public boolean isPrime() {
		if (!isInteger(number) || number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if ((number%i)==0) {
				return false;
			}
		}
		return true;
	}
}


