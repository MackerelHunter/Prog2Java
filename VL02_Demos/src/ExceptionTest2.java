import java.io.*;

public class ExceptionTest2 {

	private String s;
	
	public void setString(String s) {
		this.s = s;
	}
	
	public String toUpper() throws IOException { // Versprechen, dass selber eine solche Exception geworfen wird
		if (s == null) {
			throw new IOException("String ist null");
		}
		return s.toUpperCase();
	}
	
}
