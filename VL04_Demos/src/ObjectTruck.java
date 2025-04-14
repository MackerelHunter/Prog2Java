/**
 * Beispiel eines einfachen Containers ohne Generics
 * Soll ein beliebiges Object laden können
 */
public class ObjectTruck {
	
	private Object value;
	
	//Wir schenken uns die Null-Prüfung etc.
	public void load(Object value) {
		this.value = value;
	}
	
	public Object unload() {
		Object value = this.value; // Wir speichern das Objekt zwischen
		this.value = null; // Wir "entladen" die Ladefläche
		return value;
	}
}
