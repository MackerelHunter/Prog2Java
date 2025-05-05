import java.awt.EventQueue;

public class MainClass {

	public static void main(String[] args) {
		// doExercise1();
		// doExercise2();
		doExercise3();
	}
	
	static void doExercise1() {
		LambdaTest lt = new LambdaTest();
		lt.printerTest();
		lt.sortTest();
		lt.functionalInterfaceTest();
		lt.iterateTest();
	}
	
	static void doExercise2() {
		ArrayListTest bingbong = new ArrayListTest();
		bingbong.removeIfTest();
	}
	
	static void doExercise3() {
		EventQueue.invokeLater(() -> { // invokeLater(runnable r) lässt alles innerhalb der Methode auf einem anderen Thread laufen, wodurch das restliche Programm nicht blockiert wird
			StopWatch sw = new StopWatch(400, "Stoppuhr");
			sw.setVisible(true);
		});
	}
}
