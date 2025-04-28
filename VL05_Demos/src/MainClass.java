import java.util.*;
import java.util.function.*;

// Separate Klasse, keine innere Klasse. Kann aber nicht public sein, nur eine public Klasse pro java-File
class LengthComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		// Hier: nach Länge sortieren
		return s1.length() - s2.length();
	}
}

class StringUtilities {
	// lengthCompare kriegt die gleiche Signatur wie die zu implementierende Methode compare vom Interface Comparator (siehe oben)
	public static int lengthCompare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
	public static int signaturSchwindel(String s1, String s2) { // Signatur entspricht compare() von Comparator, macht aber nicht das was von compare erwartet wird
		return 5;
	}
	
	public static int signaturSchwindel2() { // geht nicht für Experiment 4, da Signatur nicht compare entspricht
		return 5;
	}
}

public class MainClass {

	// String-Array, zu Demozwecken
	static String[] namen = {"Sam", "Norbert", "Alice", "Edda"};
	
	public static void main(String[] args) {
		// doExperiment1();
		// doExperiment2();
		// doExperiment3();
		// doExperiment4();
		doExperiment5();
	}
	
	static void doExperiment1() {
		//*** Code-Übermittlung klassisch (geht, ist aber bissl zäh)
		//Namen-Liste ausgeben
		System.out.println(Arrays.toString(namen));
		// Sortiert Namen (verändert Original-Array, erzeugt kein neues Array)
		Arrays.sort(namen);
		// Standardmäßig wird alphabetisch sortiert
		System.out.println(Arrays.toString(namen));
		// Sortierung nach Länge
		Comparator<String> lc = new LengthComparator();
		Arrays.sort(namen, lc);
		System.out.println(Arrays.toString(namen));
	}
	
	static void doExperiment2() {
		//*** Code-Übermittlung mit Lambda-Ausdrücken
		// so würd's normalerweise aussehen
//		public int compare(String s1, String s2) {
//			// Hier: nach Länge sortieren
//			return s1.length() - s2.length();
//		}
		
		// Im Comparator-Interface ist schon festgelegt, welche Methode mit welchen Parametern und welchem Rückgabetyp implementiert werden muss
		// Deshalb können wir es auch weglassen => führt zum Lambda-Ausdruck
		Comparator<String> lc1 = (String s1, String s2) -> {return s1.length() - s2.length();};
		Arrays.sort(namen, lc1);
		System.out.println(Arrays.toString(namen));
		// ohne typen der Übergabeparameter (Typ ist ableitbar wegen Comparator-Interface);
		Comparator<String> lc2 = (s1, s2) -> {return s1.length() - s2.length();};
		// bei nur einer Codezeile (gemeint ist s1.length() - s2.length())
		Comparator<String> lc3 = (s1, s2) -> s1.length() - s2.length();
		// Dann kann ich es eigentlich auch direkt reinschreiben
		Arrays.sort(namen, (s1, s2) -> s1.length() - s2.length());
	}
	
	static void doExperiment3() {
		
		//*** Verwendung externer Variablen in Lambdaausdrücken (unterliegt Einschränkungen)
		boolean reverse = true;
		
		Comparator<String> lc = (s1, s2) -> { // geht nicht ohne geschweifte Klammern, da es ein längerer Ausdruck ist
			// reverse = !reverse; // geht nicht, Variablen, die von außen kommen, dürfen nicht verändert werden => sind im Effekt final
			if(reverse) {
				return s2.length() - s1.length();
			} else {
				return s1.length() - s2.length();
			}
		}; // nicht Strichpunkt vergessen, ist ja noch ein Lambdaausdruck
		Arrays.sort(namen, lc);
		System.out.println(Arrays.toString(namen));
	}
	
	static void doExperiment4() {
		//*** Methodenreferenzen
		// andere Klasse stellt Methoden zur Verfügung, die ich für mein funktionales Interface und Lambda-Ausdruck hernehmen will
		Comparator<String> c = StringUtilities::lengthCompare; // keine Klammern, da Signatur bereits bekannt; ist immer noch ein Lambda-Ausdruck
		Arrays.sort(namen, c);
		System.out.println(Arrays.toString(namen));
		// Schwindel-Methode verwenden
		Arrays.sort(namen, StringUtilities::signaturSchwindel); // sehr kompakt
		System.out.println(Arrays.toString(namen));
		// Arrays.sort(namen, StringUtilities::signaturSchwindel2); // geht nicht, weil falsche Signatur für das funktionale Interface Compare
	}

	static void doExperiment5() {
		//*** Eigene Methoden mit funktionalen Interfaces ...
		int nTimes = 5; // hätten das auch in den Lambda-Ausdruck schreiben können
		repeat(nTimes, (Integer i) -> System.out.println("Countdown: " + (nTimes-i-1)));
		repeat(nTimes, i -> System.out.println("Parabeltabelle: " + i + ":" + i*i));
	}
	
	static void repeat(int nTimes, Consumer<Integer> consumer) { // Bei Generics darf ich nicht mit primitiven Datentypen arbeiten, sondern muss Wrapperklassen verwenden (z.B. Integer)
		for(int i = 0; i < nTimes; i++) {
			consumer.accept(i); // hier passiert Autoboxing; der int i wird in Integer gewrapped // accept ist der Methodenname des funktionalen Interface Consumer<T> 
		}
	}
}
