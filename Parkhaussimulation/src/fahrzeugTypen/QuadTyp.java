package fahrzeugTypen;

// Author: Lars Gebhard
public class QuadTyp extends Fahrzeugtypen {
	private static QuadTyp instance = null;

	private QuadTyp() {
	}

	public static QuadTyp getInstance() {
		if (instance == null) {
			instance = new QuadTyp();
		}
		return instance;
	}
}
