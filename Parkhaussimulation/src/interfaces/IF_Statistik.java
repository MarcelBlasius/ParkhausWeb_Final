package interfaces;

//Author: Team
public interface IF_Statistik {

	// State Methode fuer Views
	public IF_State getState();

	// Fuegt die Parkdauer eines Autos der Liste über alle Parkdauern hinzu und
	// berechnet Min,Max und AVG der Parkdauern
	public void addParkdauer(double parkdauer);

	/*
	 * Wertet die Besucherart aus und speichert die Anzahl der verschiedenen
	 * Besucherarten
	 */
	public void addBesucher(String besucherart);

	// Verringert die Gesamtanzahl der aktuellen Besucher
	public void removeBesucher();

	// Gibt die Gesamtanzahl je Besucherart zurueck
	public int[] getGesamtBesucherArray();

	// Gibt die Einnahmen je Besucherart zurueck
	public double[] getEinnahmenKategorieArray();

	/*
	 * Fuegt die Einnahme eines Autos der Liste über alle Einnahmen hinzu sowie den
	 * Einnahmen für die einzelnen Besucherarten und berechnet Min,Max und AVG der
	 * Einnahmen
	 */
	public void addEinnahme(double einnahme, String besuchertyp);

	// Wertet den Fahrzeugtyp aus und speichert die Anzahl der verschiedenen
	// Fahrzeugtypen
	public void addFahrzeugtyp(String typ);

	// Gibt die Anzahl je Fahrzeugtyp zurück
	public int[] getGesamtFahrzeugtypenArray();

}
