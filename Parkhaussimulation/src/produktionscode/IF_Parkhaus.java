package produktionscode;

import java.util.List;

//Author: Teamarbeit

public interface IF_Parkhaus {

	Car[] cars();

	int add(Car car);

	Car remove(Car car);

	int size();

	IF_Statistik getStatistik();
	
	public void setStatistik(IF_Statistik s);
	
	public void setParkplatzBelegt(int parkplatz, boolean belegt);
	
	public void setMaxParkplaetze(int maxParkplaetze);
	
	public int getMaxParkplaetze();
	
	public List<Car> getCarlist();
	
	public boolean[] getParkplaetze();
	
	public void setCarlist(List<Car> carlist);
	
	public void setParkplaetze(boolean[] parkplaetzeBelegtArray);
	
	void undo();
}
