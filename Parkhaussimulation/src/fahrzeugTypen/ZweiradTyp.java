package fahrzeugTypen;

// Author: Lars Gebhard
public class ZweiradTyp extends Fahrzeugtypen {
	private static ZweiradTyp instance = null;

	private ZweiradTyp() {
	}

	public static ZweiradTyp getInstance() {
		if (instance == null) {
			instance = new ZweiradTyp();
		}
		return instance;
	}
}
