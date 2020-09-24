//Author: Lars Gebhard


package produktionscode;

public class SuvTyp extends Fahrzeugtypen{
	 private static SuvTyp instance = null;

	    private SuvTyp() {
	    }

	    public static SuvTyp getInstance() {
	        if(instance == null) {
	        }
	        return instance;
	    }
}
