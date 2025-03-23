import java.util.ArrayList;

public class NoteBook {
	private ArrayList<TextNote> notes;
	
	public NoteBook() {
		notes = new ArrayList<TextNote>();
	}
	
	public void addNote(TextNote textNote) {
		if (textNote != null) {
			notes.add(textNote);
		}
	}
	
	public TextNote getNote(int n) {
		if (n >= 0 || n <= notes.size()) {
			return notes.get(n);
		}
		return null;
	}
	
	public void listing() {
		System.out.println("Liste der Notizen:\n==================");
		for (TextNote textNote : notes) {
			System.out.println(textNote.toString());
		}
	}
}
