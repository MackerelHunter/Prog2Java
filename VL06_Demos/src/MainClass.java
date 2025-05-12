import java.util.*;
import java.util.concurrent.*;
// Für Messung von cpu-Zeit
import java.time.Instant;
import java.time.Duration;

public class MainClass {
	public static void main(String[] args) {
		// doExperiment1();
		// doExperiment2();
		// doExperiment3():
		// doExperiment4();
		doExperiment5();
	}

	static void doExperiment1(){
		// Idee: Einführung in Threads
		final int DELAY = 100; // in miliseconds
		final int STEPS = 30;

		Runnable task1 = () -> {
			double x = 100;
			try {
				for (int i = 0; i < STEPS; i++) {
					x = x/2 + 1/x;
					System.out.printf("Task 1: %6.3f\n", x);
					Thread.sleep(DELAY); // Muss InterruptedException handlen
				}
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Häh");
			}
		};

		Runnable task2 = () -> { // Normalerweise würde man die run()-Methode in eine eigene Methode schreiben
			double x = 100;
			try {
				for (int i = 0; i < STEPS; i++) {
					x = 2*x/3 + 2;
					System.out.printf("Task 2: %6.3f\n", x);
					Thread.sleep(DELAY); // Muss InterruptedException handlen
				}
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // muss interrupt() nochmal setzen, da beim schlafenden Thread das interrupt() gelöscht wird, falls er geweckt wird	
				System.out.println("Häh");
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start(); // Betriebssystem entscheided jetzt selber, siehe Ausgabe
		t2.start();

	}
	
	//Mehrere Threads laufen lassen
	static void doExperiment2() {
		ThreadTest tt = new ThreadTest();
		tt.start();
	}
	//Output auslesen
	static void doExperiment3() {
		InOutTask ioTask = new InOutTask(5);
		Thread t = new Thread (ioTask);
		t.start();
		// Jetzt würde man hier was anderes machen, während t läuft...
		// Sobald ich das Ergebnis von t brauche, muss ich sichergehen, dass das Ergebnis auch vorliegt, bevor ich es abfrage...
		try {
			t.join(); // Blockiert alles andere, bis t fertig ist
		} catch (InterruptedException e) {} // Bleibt unbehandelt in der Demo
		System.out.println("Thread hat berechnet: " + ioTask.getResult());
	}
	
	static void doExperiment4() {
		// Threadpools intro
		ExecutorService executor = Executors.newFixedThreadPool(2); // entscheidet, welches Callable in welchem Thread zum laufen kommt (siehe Console)
		// zwei callables erzeugen (die tasks...)
		Callable<String> c1 = () -> "Callable 1: " + Thread.currentThread().getName();
		Callable<String> c2 = () -> "Callable 2: " + Thread.currentThread().getName();
		
		// Tasks mehrmals submitten und durch Futures auffangen
		// Jedes Ergebnis braucht ein eigenes Future, auch wenn es den gleichen Callable aufruft
		Future<String> f1 = executor.submit(c1);
		Future<String> f2 = executor.submit(c2);
		Future<String> f3 = executor.submit(c1);
		Future<String> f4 = executor.submit(c2);
		
		// Währenddessen mache ich was anderes, dann sammle ich die Ergebnisse ein
		// Callables können Exceptions werfen
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
			System.out.println(f4.get());
			// Muss den Pool aus langlebigen Threads explizit beenden, sonst läuft Programm weiter
			executor.shutdown();
		} catch (InterruptedException | ExecutionException e) {} // Wir lassen sie mal unbehandelt
	}
	
	static void doExperiment5() {
		// Gruppen von Aufgaben handeln
		ExecutorService executor = Executors.newFixedThreadPool(5);
		// Tasks vorbereiten
		List<Callable<Double>> tasks = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			tasks.add(new InOutTask(i));
		}
		try {
			Instant startTime = Instant.now(); // ab hier Zeit messen
			// Tasks starten und Ergebnisliste zuweisen
			List<Future<Double>> results = executor.invokeAll(tasks);
			// ausgeben
			System.out.println("Radius Kreisfläche");
			for (int i = 0; i < results.size(); i++) {
				System.out.println(i+1 + " : " + results.get(i).get());
			}
			Instant endtime = Instant.now(); // bis hier Zeit messen
			System.out.println("Zeit: " + Duration.between(startTime, endtime).toMillis() + " ms"); // Zeit ausgeben
			// System.out.println braucht ewig viel Zeit, dadurch kommen die vielen Milisekunden zustande
			//Threadpool schließen
			executor.shutdown();
		} catch (InterruptedException | ExecutionException e) {}
	}
}
