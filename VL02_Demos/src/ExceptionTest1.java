
public class ExceptionTest1 {
	//provoziert eine Exception
	private String s;

	//Problem: hier könnte Nullreferenz drin stehen, da setString() nicht im Konstruktor aufgerufen wird
	public void setString(String s) {
		this.s = s;
	}

	public String toUpper() {
		try {
			return s.toUpperCase();
		} catch(NullPointerException e) { //"fange NullPointerException auf und halte Referenz e darauf"
			System.err.println("Ups, mein String ist eine Null-Referenz"); //System.err gibt in rot aus
			// e.printStackTrace(); //gibt das rote "Exception in thread "main" ..." aus
			// System.out.println(e);
			return null; // brauche auch bei Exception-Handling Rückgabe
		}
	}
}
