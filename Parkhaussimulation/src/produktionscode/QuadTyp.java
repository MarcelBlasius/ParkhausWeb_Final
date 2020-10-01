//Author: Lars Gebhard

package produktionscode;

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
