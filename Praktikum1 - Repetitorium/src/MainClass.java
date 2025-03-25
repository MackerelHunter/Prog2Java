import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//doExercise1();
		//doExercise2();
		doExercise3();
		//doExercise4();
	}

	static void doExercise1() {
		int[][] dreieck = new int[6][];
		for (int i = 0; i < dreieck.length; i++) {
			dreieck[i] = new int[i+1];		
		}
		System.out.println(Arrays.deepToString(dreieck));
		for (int i = 0; i < dreieck.length; i++) {
			for (int j = 0; j < dreieck[i].length; j++) {
				if ((j == 0) || (j == i)) {
					dreieck[i][j] = 1;
				} else {
					dreieck[i][j] = dreieck[i-1][j]+dreieck[i-1][j-1];
				}
			}
		}
		System.out.println(Arrays.deepToString(dreieck));

	}

	static void doExercise2() {
		SmartNumber numma = new SmartNumber(2);
		System.out.println(numma.isPrime());
		for (int i = 1; i <= 20; i++) {
			numma.setNumber(i);
			System.out.println(numma.isPrime());
		}
	}

	static void doExercise3() {
		//auf Verwendung der Konstanten beim Konstruktor-Aufruf achten!
		TextNote tn = new TextNote("Wichtiger Text", TextNote.PRIORITY_HIGH);
		System.out.println(tn.toString());
		tn.changePriority();
		System.out.println(tn.toString());
		tn.changeEntry("Nicht mehr so wichtig");
		System.out.println(tn.toString());
	}

	static void doExercise4() {
		NoteBook nota = new NoteBook();
		nota.addNote(new TextNote("Haha", TextNote.PRIORITY_LOW));
		nota.addNote(new TextNote("Hihi", TextNote.PRIORITY_HIGH));
		nota.getNote(0).changePriority();
		nota.getNote(1).changeEntry("Hoho");
		nota.listing();
	}

}
