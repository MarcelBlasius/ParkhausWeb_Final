package produktionscode;

//Author: Teamarbeit

public interface IF_Controller {

	public String doGet(String param);

	public String doPost(String event, String[] params);

	public void reset();
}
