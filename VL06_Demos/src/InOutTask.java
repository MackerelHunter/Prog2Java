import java.util.concurrent.*;

/**
 * Kleines Beispiel für input/output in Threads durch eigene Klasse
 */
public class InOutTask implements Runnable, Callable<Double> {
	private double radius; // der Input
	private double area; // das Ergebnis
	
	public InOutTask(double radius) {
		this.radius = radius;
	}
	
	// Berechnung durchführen
	public void run() {
		area = Math.PI*radius*radius;
	}
	
	public double getResult() {
		return area;
	}
	
	public Double call() {
		run();
		return area;
	}
}
