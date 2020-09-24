//Author: Lars Gebhard


package produktionscode;

public class TrikeTyp extends Fahrzeugtypen{
	private static TrikeTyp instance = null;

    private TrikeTyp() {
    }

    public static TrikeTyp getInstance() {
        if(instance == null) {
        }
        return instance;
    }
}
