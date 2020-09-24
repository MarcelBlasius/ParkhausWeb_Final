package produktionscode;

public class SuvTyp {
	 private static SuvTyp instance = null;

	    private SuvTyp() {
	    }

	    public static SuvTyp getInstance() {
	        if(instance == null) {
	        }
	        return instance;
	    }
}
