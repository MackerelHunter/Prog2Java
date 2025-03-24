import javax.swing.JOptionPane;

public class EingabeExperimente {
	public static String eingabe;
	
	public static void setEingabe() {
		eingabe = JOptionPane.showInputDialog("Eingabe");
	}
	
	public static String getEingabe() {
		return eingabe;
	}
}
