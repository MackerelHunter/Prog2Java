import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // Remember: Mit * werden alle Klassen, aber nicht Submodule mit ihren Klassen importiert

public class MyListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}
}
