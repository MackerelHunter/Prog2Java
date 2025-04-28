import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//doExercise1(); 
		doExercise2();
	}
	
	static void doExercise1() {
		ArrayList al = new ArrayList();
		al.add("xd");
		al.add(52);
		al.add(new java.awt.Point(2,3)); //nicht new vergessen, neues Objekt wird erzeugt
		// int testInt = al.get(0); //Da al nicht parametrisiert ist, gibt get() ein Objekt vom Typ Object zurück
		// int testInt = (int) al.get(0); // Per Cast verschwindet zwar der Compilerfehler, aber es führt zu einer Exception
		/* 2 Nachteile dieser Art von Speicherung:
		 * -Ich hab keine Ahnung, welchen Typs die gespeicherten Objekte sind
		 * -Ich muss jedes mal casten, selbst wenn die Typen passen
		 */
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("xd2");
		// al2.add(52); // Geht nicht, da al2 nur Strings nimmt
		al2.add("xd3");
		String testString = al2.get(1); // muss nicht mehr casten
		System.out.println(testString);
	}
	
	static void doExercise2() {
		// 2.2
		FlipCoin<Boolean> bCoin = new FlipCoin<>(true, false);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Ergebnis des bCoin-Münzwurfs %3d: %4s \n", i, (bCoin.toss())? "Zahl" : "Kopf");
		}
		
		//2.3
		String s1 = "Morgen ist heute gestern";
		String s2 = "Lebe immer First Class, sonst tun es Deine Erben";
		FlipCoin<String> sCoin = new FlipCoin<>(s1, s2);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Ergebnis des sCoin-Münzwurfs %3d: %s \n", i, sCoin.toss());
		}
		
		//2.4
		String happy1 = "Meega";
		String happy2 = "Super Tag";
		FlipCoin<String> happyGuy = new FlipCoin<String>(happy1, happy2);
		String sad1 = "Ojemineh";
		String sad2 = "Misere...";
		FlipCoin<String> sadGuy = new FlipCoin<String>(sad1, sad2);
		FlipCoin<FlipCoin<String>> moodyGuy = new FlipCoin<FlipCoin<String>>(happyGuy, sadGuy);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Meine Laune %3d: %s \n", i, moodyGuy.toss().toss());
		}
	}

}
