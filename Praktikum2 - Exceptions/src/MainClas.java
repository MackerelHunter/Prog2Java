
public class MainClas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//doExercise11();
		//doExercise12();
		doExercise13();
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
			acc3.put(30);
			System.out.println(acc3.toString());
			acc3.draw(200);
			System.out.println(acc3.toString());
		} catch (NegativeAmountException | InsufficientBalanceException e) {
			e.printStackTrace(); // Gibt die rote Fehlermeldung mit Exception-Namen und wo es aufgetreten ist
		}
		System.out.println("Hier geht's weiter");
	}
}
