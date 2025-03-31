// Meine eigene Exception

public class PlayerException  extends Exception { // muss erben, damit throw etc. verwendet werden kann

	public PlayerException() { // brauche beim Erben wie immer eigenen Konstruktor, der super() aufruft
		super();
	}
	
	public PlayerException(String s) {
		super(s);
	}
}
