import java.util.ArrayList;

public class NoteBook {
	//Achte darauf, dass das NoteBook mit dem Interface Note agiert, nicht mit der implementierenden Klasse TextNote
	private ArrayList<Note> notes;
	
	public NoteBook() {
		notes = new ArrayList<Note>();
	}
	
	public void addNote(Note note) {
		if (note != null) {
			notes.add(note);
		}
	}
	
	public Note getNote(int n) {
		if (n >= 0 || n <= notes.size()) {
			return notes.get(n);
		}
		return null;
	}
	
	public void listing() {
		System.out.println("Liste der Notizen:\n==================");
		for (Note note : notes) {
			System.out.println(note.toString());
		}
	}
}
