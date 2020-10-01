package interfaces;

import java.util.List;

import produktionscode.Fahrzeug;

//Author: Teamarbeit

public interface IF_Parkhaus {

	// Gibt ein Fahrzeug Array der im Parkhaus parkenden Fahrzeuge zurueck
	Fahrzeug[] cars();

	// fuegt ein Fahrzeug dem Parkhaus hinzu
	int add(Fahrzeug car);

	// entfernt ein Fahrzeug aus dem Parkhaus
	Fahrzeug remove(Fahrzeug car);

	// einen Parkplatz als belegt / frei markieren
	public void setParkplatzBelegt(int parkplatz, boolean belegt);
	
	// gibt ein Array mit den Daten zurueck ob ein Parkplatz belegt ist oder nicht
	public boolean[] getParkplaetzeBelegtArray();
	
	//setzt die belegten Parkplaetze
	public void setParkplaetzeBelegtArray(boolean[] parkplaetze);
	
	// gibt die Statistik eines Parkhauses zurueck
	public IF_Statistik getStatistik();
	
	//setzt die Statistik eines Parkhauses
	public void setStatistik(IF_Statistik statistik);
	
	//gibt eine Liste mit allen Fahrzeugen zurueck
	public List<Fahrzeug> getCarlist();
	
	//setzt die Fahrzeugliste eines Parkhauses
	public void setCarlist(List<Fahrzeug> carlist);
	
	// die maximale Anzahl der Parkplaetze setzen
	public void setMaxParkplaetze(int maxParkplaetze);

	// gibt die Anzahl der Parkplaetze zurueck
	public int getMaxParkplaetze();
	
	// letzten Zustand wiederherstellen
	void undo();

	// gibt die ID des Parkhauses zurueck
	public String getId();

}
