import java.awt.*;
import javax.swing.*;

public class MyWin1 extends JFrame {
	// Bei GUIs sind Konstruktoren meistens größere Methoden
	public MyWin1(int breite, int hoehe, String title) {
		super(title); // Übernimmt Konstruktor von JFrame
		setSize(breite, hoehe); // Methode von JFrame übernommen
		// Bildschirmgröße erfragen:
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width)/2, (d.height - getSize().height)/2);
		
		// Layoutmanager
		setLayout(new BorderLayout()); //Zeilen, Spalten, Abstände
		

		// Komponenten einfügen
		JLabel l1 = new JLabel("Ich zeige einen Text");
		add(l1); // JFrame ist auch ein Container, der Komponenten enthalten kann
		add(new JButton("Drück mich!")); 
		add(new JLabel("Ich"));
		add(new JLabel("und"));
		add(new JLabel("du"));
		add(new JLabel("und"));
		add(new JLabel("Müllers Kuh"));
		
	}
}
