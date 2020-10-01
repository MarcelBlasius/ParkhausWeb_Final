//Author: Lars Gebhard

package fahrzeugTypen;

public class SuvTyp extends Fahrzeugtypen {
	private static SuvTyp instance = null;

	private SuvTyp() {
	}

	public static SuvTyp getInstance() {
		if (instance == null) {
		}
		return instance;
	}
}
