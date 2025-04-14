/**
 * Truck als Generic
 * @param <T>
 */
public class Truck<T> { // Diese Klasse möchte parametrisiert werden! Ich kann das T jetzt wie einen Klassennamen verwenden!
	private T value;

	public void load(T value) {
		this.value = value;
	}
	
	public T unload() {
		T value = this.value;
		this.value = null;
		return value;
	}
}
