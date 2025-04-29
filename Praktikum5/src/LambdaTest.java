import java.util.*;
import java.time.LocalDateTime;
import java.util.function.*;

public class LambdaTest {
	
	public void printerTest() {
		SimplePrinter sp = new SimplePrinter();
		sp.print(5);
		
		// Lambda-Test
		Printer coolPrinter = nPages -> System.out.println("Ich drucke " + nPages + " coole Seiten"); 
		// Bei nur einem Parameter mit ableitbarem Datentyp kann man Klammern, Datentyp, geschweifte Klammern und Semikolon weglassen
		coolPrinter.print(5);
		
		// Lambda-Test 2
		Printer multiPrinter = nPages -> {
			for (int i = 1; i <= nPages; i++) {
				System.out.println("Ich drucke die coole Seite " + i);
			}
		};
		multiPrinter.print(5);	
	}
	
	public void sortTest() {
		String[] names = {"Ankara", "Auckland", "Freising", "Salamanca", "Paris"};
		Comparator<String> aComparator = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s1.replaceAll("[^aA]*", "").length() - s2.replaceAll("[^aA]*", "").length()); // ersetzen
			}
		};
		Arrays.sort(names, aComparator);
		System.out.println("Mit anonymer Klasse: " + Arrays.toString(names));
		Arrays.sort(names, (s1, s2) -> (s1.replaceAll("[^aA]*", "").length() - s2.replaceAll("[^aA]*", "").length())); // Eckige Klammern: alle Zeichen darin / ^ in eckigen Klammern: alle außer den Zeichen / * von 0 bis n Vorkommen
		System.out.println("Mit Lambda-Ausdruck: " + Arrays.toString(names));
	}
	
	// 1.4
	public void functionalInterfaceTest() {
		Consumer<Double> squareConsumer = base -> System.out.println("Quadrat: " + base*base);
		squareConsumer.accept(5.0);
		
		Supplier<String> hourSupplier =  () -> {return (LocalDateTime.now().getHour() + " Uhr");};
		System.out.println(hourSupplier.get());
		
		String[] stringArray = {"hihi", "haha", "hehe"};
		Function<String[], String> arraySerializer = input -> {
			StringBuilder sb = new StringBuilder();
			for (String s : input) {
				sb.append(s);
			}
			return sb.toString();
		};
		System.out.println(arraySerializer.apply(stringArray));
		
	}
	
	public void iterateTest() {
		System.out.println(iterate(5, 10, start -> (start/2 + 1/start)));
		System.out.println(iterate(5, 10, start -> ((2/3) * start + 2)));
	}
	
	public double iterate(double start, int nTimes, UnaryOperator<Double> unerator) { // nimmt einen double als Startwert, nTimes sagt, wie oft es passieren soll, und mit dem Interface UnaryOperator<Double> wissen wir, dass es eine Methode sein soll, die ein double nimmt und ein double zurückgibt!
		for (int i = 1; i <= nTimes; i++) {
			start = unerator.apply(start);
		}
		return start;
	}
}

interface Printer {
	void print(int nPages);
}

class SimplePrinter implements Printer {
	public void print(int nPages) {
		System.out.println("Ich drucke " + nPages + " Seiten");
	}
}
