import javax.swing.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.*;

public class StopWatch extends JFrame {
	
	private JButton bStart, bStop, bReset;
	private JLabel theTime;
	private int deciSeconds, seconds;
	private static final int TIMER_STEPS = 100; // Wir sollen in Zehntelsekunden zählen, die 100stel-Sekunden bleiben dann halt immer 0
	
	public StopWatch(int borderSize, String title) {
		super(title);
		setSize(borderSize, borderSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // zentriert das Fenster
		setLayout(new BorderLayout());
		
		theTime = new JLabel("placeholder", SwingConstants.CENTER);
		updateTime();
		theTime.setFont(new Font("SansSerif", Font.PLAIN, borderSize/3));
		add(theTime);
		Timer timer = new Timer (TIMER_STEPS, event -> steps());
		
		JPanel bottomButtons = new JPanel();
		bottomButtons.setLayout(new FlowLayout()); // FlowLayout erzeugt automatisch Abstände zu den Rändern
		bStart = new JButton("Start");
		bStop = new JButton ("Stop");
		bReset = new JButton ("Reset");
		// GUI-Programmierung ist klassische Anwendung von Lambda-Ausdrücken
		bStart.addActionListener(event -> timer.start());
		bStop.addActionListener(event -> timer.stop());
		bReset.addActionListener(event -> reset());
		bottomButtons.add(new JLabel(""));
		bottomButtons.add(bStart);
		bottomButtons.add(bReset);
		bottomButtons.add(bStop);
		bottomButtons.add(new JLabel(""));
		add (bottomButtons, BorderLayout.SOUTH);
		bottomButtons.setBackground(Color.GRAY);
	}
	
	private void steps() {
		deciSeconds++;
		if (deciSeconds == 10) {
			deciSeconds = 0;
			seconds++;
		}
		if (seconds == 100) {
			seconds = 0;
		}
		updateTime();
	}
	
	private void updateTime() {
		theTime.setText(String.format("%02d:%1d0", seconds, deciSeconds));
	}
	
	private void reset() {
			deciSeconds = 0;
			seconds = 0;
			updateTime();
	}
}