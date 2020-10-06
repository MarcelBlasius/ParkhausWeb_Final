package fahrzeugTypen;

// Author: Lars Gebhard
public class PkwTyp extends Fahrzeugtypen {

	private static PkwTyp instance = null;

	private PkwTyp() {
	}

	public static PkwTyp getInstance() {
		if (instance == null) {
			instance = new PkwTyp();
		}
		return instance;
	}
}