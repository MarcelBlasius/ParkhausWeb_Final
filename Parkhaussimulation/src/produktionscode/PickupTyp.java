//Author: Lars Gebhard

package produktionscode;

public class PickupTyp extends Fahrzeugtypen {
	private static PickupTyp instance = null;

	private PickupTyp() {
	}

	public static PickupTyp getInstance() {
		if (instance == null) {
			instance = new PickupTyp();
		}
		return instance;
	}
}
