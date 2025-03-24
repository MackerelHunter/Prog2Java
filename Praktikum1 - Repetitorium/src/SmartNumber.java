
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
		//return ((x%1)==0);
		//Stetters Lösung - funktioniert, weil impliziter Cast aus (int)x wieder einen double macht
		return (x == (int)x);
	}

	public boolean isEven() {
		if (!isInteger(number)) {
			return false;
		}
		//return ((number%2)==0)? false : true;
		return (isInteger(number/2));
	}
	
	//Vorgehen nach dem Prinzip der Probedivision
	//https://de.wikipedia.org/wiki/Probedivision#Beispiel
	public boolean isPrime() {
		if (!isInteger(number) || number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			//if ((number%i)==0) {
			if (isInteger(number/i)) {
				
				return false;
			}
		}
		return true;
	}
}


