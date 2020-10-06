package fahrzeugTypen;

// Author: Lars Gebhard
public class SuvTyp extends Fahrzeugtypen {
	private static SuvTyp instance = null;

	private SuvTyp() {
	}

	public static SuvTyp getInstance() {
		if (instance == null) {
			instance = new SuvTyp();
		}
		return instance;
	}
}
