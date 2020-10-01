package interfaces;

//Author: Teamarbeit

public interface IF_Controller {

	//Handler fuer doGet Anfragen
	public String doGet(String param);

	//Handler fuer doPost Anfragen
	public String doPost(String event, String[] params);

	//resette die Instanz
	public void reset();
}
