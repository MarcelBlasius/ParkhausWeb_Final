package produktionscode;

public class TrikeTyp {
	private static TrikeTyp instance = null;

    private TrikeTyp() {
    }

    public static TrikeTyp getInstance() {
        if(instance == null) {
        }
        return instance;
    }
}
