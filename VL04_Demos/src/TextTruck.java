
public class TextTruck<T extends CharSequence> { // Ich will nur Stringartige Objekte laden
	private T value;

	public void load(T value) {
		this.value = value;
	}
	
	public T unload() {
		T value = this.value;
		this.value = null;
		return value;
	}
	
	public void tellLength() {
		System.out.println(value.length()); // Ohne <T extends CharSequence> würde er meckern!
	}
	
}
