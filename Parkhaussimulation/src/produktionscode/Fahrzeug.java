package produktionscode;

import interfaces.IF_Fahrzeug;

//Author: Marius Bauerfeind
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

	@Override
	public String getBesucherArt() {
		return besucherArt;
	}

	@Override
	public String getTyp() {
		return typ;
	}

	@Override
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
