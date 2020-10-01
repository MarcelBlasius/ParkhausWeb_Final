package produktionscode;

//Author: Marius Bauerfeind
public class Car implements IF_Car{
	
	private String id;
	private String art;
	private String typ;
	private int parkplatz;
	
	public Car(String id, String art,String typ) {
		this.id = id;
		this.art = art;
		this.typ = typ;
		
	}


	@Override
	public String getArt() {
		return art;
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
