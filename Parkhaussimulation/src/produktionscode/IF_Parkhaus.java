package produktionscode;

import java.util.List;

//Author: Teamarbeit

public interface IF_Parkhaus {

	Fahrzeug[] cars();

	int add(Fahrzeug car);

	Fahrzeug remove(Fahrzeug car);

	int size();

	IF_Statistik getStatistik();
	
	public void setStatistik(IF_Statistik s);
	
	public void setParkplatzBelegt(int parkplatz, boolean belegt);
	
	public void setMaxParkplaetze(int maxParkplaetze);
	
	public int getMaxParkplaetze();
	
	public List<Fahrzeug> getCarlist();
	
	public boolean[] getParkplaetze();
	
	public void setCarlist(List<Fahrzeug> carlist);
	
	public void setParkplaetze(boolean[] parkplaetzeBelegtArray);
	
	void undo();
}
