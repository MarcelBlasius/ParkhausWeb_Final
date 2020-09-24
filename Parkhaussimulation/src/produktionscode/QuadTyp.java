package produktionscode;

public class QuadTyp {
	private static QuadTyp instance = null;

    private QuadTyp() {
    }

    public static QuadTyp getInstance() {
        if(instance == null) {
        }
        return instance;
    }
}
