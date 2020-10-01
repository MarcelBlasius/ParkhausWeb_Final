package interfaces;

//Author: Teamarbeit

public interface IF_Fahrzeug {
	
	//Gibt die Art des Besuchers zurueck
	String getBesucherArt();
	
	//Gibt die ID des Fahrzeuges zurueck
	String getID();
	
	//Gibt die den Fahrzeug Typ zurueck
	String getTyp();
	
	//Setzt die Parkplatznummer
	public void setParkplatz(int parkplatz);

	//Gibt den Parkplatz zurueck
	public int getParkplatz();
}
