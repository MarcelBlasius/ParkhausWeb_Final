package fahrzeugTypen;

// Author: Lars Gebhard
public class TrikeTyp extends Fahrzeugtypen {
	private static TrikeTyp instance = null;

	private TrikeTyp() {
	}

	public static TrikeTyp getInstance() {
		if (instance == null) {
			instance = new TrikeTyp();
		}
		return instance;
	}
}
