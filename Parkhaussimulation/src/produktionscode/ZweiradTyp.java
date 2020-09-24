package produktionscode;

public class ZweiradTyp {
	 private static ZweiradTyp instance = null;

	    private ZweiradTyp() {
	    }

	    public static ZweiradTyp getInstance() {
	        if(instance == null) {
	        }
	        return instance;
	    }
}
