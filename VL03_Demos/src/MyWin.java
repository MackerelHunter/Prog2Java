import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyWin extends JFrame {
	
	private JButton bRed, bBlue, bYellow, bGreen;
	private JPanel centerPane;
	// Bei GUIs sind Konstruktoren meistens größere Methoden
	public MyWin(int breite, int hoehe, String title) {
		super(title); // Übernimmt Konstruktor von JFrame
		setSize(breite, hoehe); // Methode von JFrame übernommen
		// Bildschirmgröße erfragen:
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width)/2, (d.height - getSize().height)/2);
		
		setLayout(new BorderLayout());
		// JPanel bRed = new JButton("Rot"); // Das wär falsch, da würden wir eine lokale Variable erzeugen
		bRed = new JButton("Rot"); // Wir verwenden die deklarierten Variablen der Klasse
		add(bRed, BorderLayout.NORTH); // Statische Variable von BorderLayout wird aufgerufen
		bBlue = new JButton("Blau");
		add(bBlue, BorderLayout.SOUTH);
		bGreen = new JButton("Grün");
		add(bGreen, BorderLayout.EAST);
//		bYellow = new JButton("Gelb");
//		add(bYellow, BorderLayout.EAST);
		centerPane = new JPanel();
		add(centerPane, BorderLayout.CENTER);
		centerPane.setBackground(Color.GRAY);
		
		JPanel westPane = new JPanel();
		westPane.setLayout(new GridLayout(0, 1, 5, 5));;
		westPane.add(new JLabel("Button folgt"));
		bYellow = new JButton("Gelb");
		westPane.add(bYellow);
		westPane.add(new JLabel(""));
		westPane.add(new JLabel(""));
		westPane.add(new JLabel("")); // Wir füllen das Fenster mit unsichtbaren Kästchen, schieben dadurch den Button links nach oben
		add(westPane, BorderLayout.WEST);
		
		// Wir sind immer noch im Konstruktor
		
		// Eventbehandlung
		//ActionListener a = new MyListener();
		// bRed.addActionListener(aRed); // Wenn wir auf Rot klicken, passiert was
		
		bGreen.addActionListener(new ActionListener() { // Der ActionListener wird zum Subscriber vom Button
			public void actionPerformed(ActionEvent e) { // JButtons lösen halt beim Klicken "ActionEvents" aus
				centerPane.setBackground(Color.GREEN);
			}
		});
		
		bRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPane.setBackground(Color.RED);
			}
		});
		
		bBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPane.setBackground(Color.BLUE);
			}
		});
		
		bYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				centerPane.setBackground(Color.YELLOW);
			}
		});
	} // Ende des Konstruktors
	
//	//Anonyme Innere Klasse:
//	ActionListener aRed = new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			System.out.println(e);
//		}
//	};
}
