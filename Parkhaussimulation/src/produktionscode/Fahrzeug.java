package produktionscode;

import interfaces.IF_Fahrzeug;

// Author: Jan Bauerfeind
public class Fahrzeug implements IF_Fahrzeug {

	private String id;
	private String besucherArt;
	private String typ;
	private int parkplatz;

	public Fahrzeug(String id, String art, String typ) {
		this.id = id;
		this.besucherArt = art;
		this.typ = typ;

	}

	public String getBesucherArt() {
		return besucherArt;
	}

	public String getTyp() {
		return typ;
	}

	public String getID() {
		return id;
	}

	public void setParkplatz(int parkplatz) {
		this.parkplatz = parkplatz;
	}

	public int getParkplatz() {
		return parkplatz;
	}

}
