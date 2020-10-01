//Author: Lars Gebhard

package fahrzeugTypen;

public class ZweiradTyp extends Fahrzeugtypen {
	private static ZweiradTyp instance = null;

	private ZweiradTyp() {
	}

	public static ZweiradTyp getInstance() {
		if (instance == null) {
		}
		return instance;
	}
}
