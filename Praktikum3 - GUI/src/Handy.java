import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;


public class Handy extends JFrame {

	private String enteredNumber = "";
	private String verbunden = "Verbunden";
	private String getrennt = "Getrennt";
	private JTextField tSearch;
	private JButton bWahl, bAbbr;
	private ArrayList<JButton> buttonList;
	private JLabel lStatus;
	//private Jbutton bOne, bTwo, bThree
	public Handy(int hoehe, String title) {
		super(title);
		setSize((int) (hoehe*0.7), hoehe);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width-getSize().width)/2, (d.height-getSize().height)/2);
		setLayout(new BorderLayout());

		//Textfeld oben
		JPanel northBorder = new JPanel();
		northBorder.setLayout(new GridLayout(0,1,5,5));
		tSearch = new JTextField("");
		northBorder.add(tSearch);
		add(northBorder, BorderLayout.NORTH);

		//Knöpfe Mitte
		JPanel centerButtons = new JPanel();
		centerButtons.setLayout(new GridLayout(0,3,5,5));
		bWahl = new JButton("Wahl");
		centerButtons.add(bWahl);
		centerButtons.add(new JLabel(""));
		bAbbr = new JButton("Abbr.");
		centerButtons.add(bAbbr);
		buttonList = new ArrayList<JButton>();
		// Einzelne Buttons über Position in ArrayList ansprechbar!
		for (int i = 0; i <= 9; i++) {
			buttonList.add(new JButton(String.format("%1d", i)));
		}
		for (int i = 1; i <= 9; i++) {
			centerButtons.add(buttonList.get(i));
		}
		centerButtons.add(new JLabel(""));
		centerButtons.add(buttonList.get(0));
		centerButtons.add(new JLabel(""));
		add(centerButtons, BorderLayout.CENTER);

		//Statuslabel unten
		lStatus = new JLabel("getrennt");
		add(lStatus, BorderLayout.SOUTH);

		//ActionListener an Buttons anhängen
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enteredNumber += e.getActionCommand(); //e.getActionCommand holt den "Command String" des ActionEvent (in unserem Fall das Label des Buttons)
				tSearch.setText(enteredNumber);
				// aber wie kann ich von hier auf das erzeugende Event zugreifen?
			}
		};
		for (int i = 0; i < buttonList.size(); i++) {
			buttonList.get(i).addActionListener(buttonListener);
		}
		
		bWahl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dial();
			}
		}); // Klammer nicht vergessen
		
		bAbbr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tSearch.setText("");
				
			}
		});
		
	}
	
	//Testfunktion, um Zugriff auf buttonList-Elemente zu prüfen
	public void changeButtonNumber(int number, String newLabel) {
		buttonList.get(number).setText(newLabel);
	}
	
	private void dial() {
		lStatus.setText(tSearch.getText()); // ändert das JLabel lStatus zum Inhalt vom Textfeld tSearch
	}


}
