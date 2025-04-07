
public class StopWatch {
	private int second = 0;
	private int tenth = 0;
	
	void start(int steps) throws InterruptedException {
		// Diese Exception ist nötig, da der Thread die meiste Zeit schläft
		// Ohne die Exception müsste man genau auf einen vollen 100ms-Schritt treffen, wenn man den Thread unterbrechen will
		// Wir fangen an zu werfen
		for (int i = 0; i <= steps; i++) {
			tenth = i%10;
			second = i/10;
			System.out.printf("\r" + "%02d:%1d", second, tenth); //Die Null bei 02d füllt die Leerzeichen mit Nullen auf
			Thread.sleep(100);
			
		}
	}
}
