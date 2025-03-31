import java.io.*; // Um mit Dateien umzugehen

public class MainClass {

	//Demo der Vorlesung 02: Exception-Behandlung

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ExceptionTest1  et1 = new ExceptionTest1();
//		System.out.println(et1.toUpper()); // 
//		System.out.println("Hier geht's weiter"); //  hier laufen Prozesse nebenläufig, deswegen kann das Exception-Handling langsamer sein als diese Ausgabe
		
		// Experiment 2
//		readFile("Test.txt");
//		System.out.println("Hier geht's weiter");
//		readFile("src/MainClass.java"); //
		
		// Experiment 3
//		ExceptionTest2 et2 = new ExceptionTest2();
//		try { // Muss jetzt try-catch-Block schreiben, weil wir für toUpper() versprochen haben, dass eine Exception geworfen wird
//			System.out.println(et2.toUpper());
//		} catch (IOException e) {
//			System.err.println(e); // Fehlerkanal verwenden
//		}
//		System.out.println("Hier geht's weiter");
		
		//Experiment 4
		try {
			Player p = new Player(-50);
		} catch (PlayerException e) {
			e.printStackTrace();
		}
		
	}

	public static void readFile(String name) { // liest aus Datei "name"
		RandomAccessFile f;

		try {
			f = new RandomAccessFile(name, "r"); // Wir werden gezwungen, die Exception FileNotFound zu behandeln
			for (String line; (line = f.readLine()) != null;) { // 
				System.out.println(line);
			}
		} catch (FileNotFoundException e) { // Catch-Block könnte auch leer sein; Dann können schlimme Dinge passieren! Das Programm läuft weiter, aber es ist ein Fehler aufgetreten, den wir nicht bemerken
			System.err.println("Datei nicht gefunden");
		} catch (IOException e) { // Man kann mehrere mögliche Exceptions auffangen
			System.err.println("Leseprobleme");
		} // Könnte auch mehrere Exceptions in einem Block behandeln ... catch(FileNotFoundException | IOException e)
	}
}
