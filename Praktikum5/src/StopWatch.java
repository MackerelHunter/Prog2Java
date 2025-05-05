import javax.swing.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.*;

public class StopWatch extends JFrame {
	
	private JButton bStart, bStop, bReset;
	private JLabel theTime;
	private int centiSeconds, seconds;
	
	public StopWatch(int borderSize, String title) {
		super(title);
		setSize(borderSize, borderSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		theTime = new JLabel(String.format("%02d:%02d", seconds, centiSeconds), SwingConstants.CENTER);
		theTime.setFont(new Font("SansSerif", Font.PLAIN, borderSize/3));
		add(theTime);
		int timerSteps = 100; // Wir sollen in Zehntelsekunden zählen, die 100stel-Sekunden bleiben dann halt immer 0
		Timer timer = new Timer (timerSteps, event -> { 
			centiSeconds = centiSeconds + (timerSteps/10);
			if (centiSeconds == 100) {
				centiSeconds = 0;
				seconds++;
			}
			theTime.setText(String.format("%02d:%02d", seconds, centiSeconds));
		});
		
		JPanel bottomButtons = new JPanel();
		bottomButtons.setLayout(new FlowLayout()); // FlowLayout erzeugt automatisch Abstände zu den Rändern
		bStart = new JButton("Start");
		bStop = new JButton ("Stop");
		bReset = new JButton ("Reset");
		bStart.addActionListener(event -> timer.start());
		bStop.addActionListener(event -> timer.stop());
		bReset.addActionListener(event -> {
			centiSeconds = 0;
			seconds = 0;
			theTime.setText(String.format("%02d:%02d", seconds, centiSeconds));
		});
		bottomButtons.add(new JLabel(""));
		bottomButtons.add(bStart);
		bottomButtons.add(bReset);
		bottomButtons.add(bStop);
		bottomButtons.add(new JLabel(""));
		add (bottomButtons, BorderLayout.SOUTH);
		bottomButtons.setBackground(Color.GRAY);
	}

}