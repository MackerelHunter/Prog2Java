import javax.swing.JOptionPane;

public class ThreadTest {

	// Kooperation von 4 Threads - als Demo
	private String commonString; // gemeinsame Variable, in die die Threads konkurrierend reinschreiben

	private Thread t1, t2, viewDaemon, finisher;

	public ThreadTest() {
		commonString = "";

		t1 = new Thread( () -> {
			while (!Thread.currentThread().isInterrupted()) { // while-Schleife nicht vergessen! Der Thread muss das kontinuierlich machen
				commonString = Thread.currentThread().getName() + ": Bei mir ist was passiert";
				sleep((int) (Math.random()*10001)); // Wäre eigentlich zu lang für einen Lambdaausdruck
			}
		});
		t1.setName("Der erste Thread");

		t2 = new Thread( () -> {
			while (!Thread.currentThread().isInterrupted()) {
				commonString = Thread.currentThread().getName() + ": Bei mir ist was passiert";
				sleep((int) (Math.random()*10001)); // Wäre eigentlich zu lang für einen Lambdaausdruck
			}
		});
		t2.setName("Der zweite Thread");

		// der Terminator
		finisher = new Thread( () -> {
			JOptionPane.showMessageDialog(null, "Bitte drücken, um Threads zu beenden");
			// Macht erst hier weiter, sobald der Knopf gedrückt wurde
			t1.interrupt();
			t2.interrupt();
		});

		viewDaemon = new Thread ( () -> {
			while (true) {
				System.out.printf("\r%s", commonString); // immer in der gleichen Zeile ausgeben
				sleep(50);
			}
		});
		viewDaemon.setDaemon(true);
	}

	public void start() {
		t1.start();
		t2.start();
		finisher.start();
		viewDaemon.start();
	}

	private void sleep(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
