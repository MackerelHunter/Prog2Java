
//2.1



public class FlipCoin<T> {
	private T object1;
	private T object2;
	
	public FlipCoin(T object1, T object2) {
		this.object1 = object1;
		this.object2 = object2;
	}
	
	public T toss() {
		if (Math.random() >= 0.5) {
			return object1;
		}
		return object2;
	}
}
