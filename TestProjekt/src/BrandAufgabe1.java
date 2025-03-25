import java.util.Scanner;

public class BrandAufgabe1 {

	public static void brandAufgabe1() {
		Scanner scanner = new Scanner(System.in);

		boolean validInput = false;
		long tenDigitNumber = 0;
		do {
			System.out.println("Bitte geben Sie jetzt eine 10-stellige ganze Zahl ein");
			if (scanner.hasNext("\\d{10}")) {
				tenDigitNumber = scanner.nextLong();
				System.out.println(tenDigitNumber);
				System.out.println("Gültige Eingabe!");
				validInput = true;
			} else {
				System.out.println("Ungültige Eingabe");
				scanner.next();
			}
		} while (!validInput);

		System.out.println(tenDigitNumber);
	}
}