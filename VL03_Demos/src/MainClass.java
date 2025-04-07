import javax.swing.JFrame;
import java.awt.Toolkit;

public class MainClass {

	public static void main(String[] args) {
		// Erstes Fenster erzeugen
		JFrame f = new JFrame("Mein erstes Fenster :-) "); // das allein reich noch nicht zur Anzeige
		//f.setVisible(true); // Jetzt wird es angezeigt
		//		f.setSize(600, 400);
		//		f.setResizable(false); // Größe nicht mehr veränderbar
		//		f.setVisible(true);

		MyWin win = new MyWin(600, 400, "Meins!");
		win.setVisible(true);
	}

}
