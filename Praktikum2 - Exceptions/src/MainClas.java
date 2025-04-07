import java.util.Scanner;

public class MainClas {

	public static void main(String[] args) throws InterruptedException { // Wir werfen ein letztes Mal, jetzt an's Betriebssystem
		// TODO Auto-generated method stub
		//doExercise11();
		//doExercise12();
		//doExercise13();
		//System.out.println("Ganze Zahl: " + readForced());
		doExercise3(100);
	}

	static void doExercise11() {
		Account1 acc1 = new Account1();
		acc1.put(100);
		System.out.println(acc1.toString());
		acc1.put(-30);
		System.out.println(acc1.toString());
		acc1.draw(200);
		System.out.println(acc1.toString());
	}

	static void doExercise12() {
		Account2 acc2 = new Account2();
		try {
			acc2.put(100);
			System.out.println(acc2.toString());
			acc2.put(-30);
			System.out.println(acc2.toString());
			acc2.draw(200);
			System.out.println(acc2.toString());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hier geht's weiter");
	}
	
	static void doExercise13() {
		Account3 acc3 = new Account3();
		try { // try-Block wird verlassen, sobald Exception auftritt
			// Exceptions unterstützen Kapselung
			// Die Methode/das Objekt selbst sind verantwortlich dafür, sich bei Fehlern zu melden
			// Man muss nicht selber reinschauen
			acc3.put(100);
			System.out.println(acc3.toString());
			acc3.put(-30);
			System.out.println(acc3.toString());
			acc3.draw(200);
			System.out.println(acc3.toString());
//		} catch (NegativeAmountException | InsufficientBalanceException e) {
//			e.printStackTrace(); // Gibt die rote Fehlermeldung mit Exception-Namen und wo es aufgetreten ist
		} catch (NegativeAmountException e) {
			System.err.println("Falsche Eingabe: " + e.toString());
		} catch (InsufficientBalanceException e) {
			System.err.println("Netter Versuch: " + e.toString());
		}
		System.out.println("Hier geht's weiter");
	}
	
	static void doExercise3(int steps) throws InterruptedException { // Wir werfen weiter
		StopWatch sw = new StopWatch();
		sw.start(steps);
	}
	
	
	
	public static int readForced() {
		Scanner scan = new Scanner(System.in);
		int entry;
		while (true) {
			try {
				System.out.print("Bitte geben Sie jetzt eine ganze Zahl ein: ");
				entry = Integer.parseInt(scan.next());
				break;
			} catch (NumberFormatException e) {
				System.err.println("Kein Integer!");
			}
		}
		return entry;
	}
}
