//Author: Lars Gebhard

package produktionscode;

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