
public class Player {
	private int age;

	public Player(int age) throws PlayerException {
		if (age < 0) {
			throw new PlayerException("Negatives Alter nicht erlaubt!");
		}
		this.age = age;
	}
}
