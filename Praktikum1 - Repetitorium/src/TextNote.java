import java.util.Date;
import java.text.SimpleDateFormat;

public class TextNote implements Note {
	private String entry;
	private String creationDate;
	private String lastModified;
	private int priority;
	private SimpleDateFormat sdf;
	
	public static final int PRIORITY_LOW = 0;
	public static final int PRIORITY_HIGH = 1;
	
	public TextNote (String entry, int priority) {
		this.entry = (entry == null)? "" : entry;
		this.priority = (priority == PRIORITY_LOW)? PRIORITY_LOW : PRIORITY_HIGH;
		sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
		//folgendes funktioniert, wie die Kontrollausgabe darunter zeigt
		creationDate = lastModified = timeStamp();
		//System.out.println(creationDate + " " + lastModified);
	}
	
	public TextNote (String entry) {
		this(entry, PRIORITY_LOW);
	}
	
	public String getEntry() {
		return entry;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
	
	public String getLastModified() {
		return lastModified;
	}
	
	public int getPriority() {
		return priority;
	}
	
	private String timeStamp() {
		return sdf.format(new Date());
	}
	
	public void setLastModified() {
		lastModified = timeStamp();
	}
	
	public void changeEntry(String newEntry) {
		entry = (newEntry == null)? "" : newEntry;
		setLastModified();
	}
	
	public void changePriority() {
		priority = (priority == PRIORITY_LOW)? PRIORITY_HIGH : PRIORITY_LOW;
		setLastModified();
	}
	@Override
	public String toString() {
		return String.format("[von: %s; geändert: %s; Priorität: %6s; %s]", getCreationDate(), getLastModified(), (getPriority()==0)? "normal" : "hoch", getEntry());
	}
}
