import java.util.function.*;
import java.util.*;

public class ArrayListTest {

	private List<String> list = new ArrayList<>(
			Arrays.asList("Salamanca", null, "Auckland", "Ankara", "Freising", "Paris"));
	
	public void removeIfTest() {
		list.removeIf(string -> string == null);
		System.out.println(Arrays.toString(list.toArray()));
		list.removeIf(string -> string.matches("[aA].*"));
		System.out.println(Arrays.toString(list.toArray()));
	}

	public void regExTest() {
		for (String s : list) {
			System.out.println(s + ": " + s.matches("[aA].*")); // String.matches() fügt automatisch ^ am Anfang und $ am Ende hinzu, testet also zwingend den ganzen String. Böses Java!
		}
	}
}
