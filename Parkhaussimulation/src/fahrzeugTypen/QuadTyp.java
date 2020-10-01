//Author: Lars Gebhard

package fahrzeugTypen;

public class QuadTyp extends Fahrzeugtypen {
	private static QuadTyp instance = null;

	private QuadTyp() {
	}

	public static QuadTyp getInstance() {
		if (instance == null) {
		}
		return instance;
	}
}
