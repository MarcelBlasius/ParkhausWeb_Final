package interfaces;

//Author: Teamarbeit

public interface IF_Statistik {

	public IF_State getState();

	//Fügt die Parkdauer eines Autos der Liste über alle Parkdauern hinzu
	public void addParkdauer(double parkdauer);

	//Fügt die ID eines Autos der Liste über alle Besucher hinzu
	public void addBesucher(String id);

	
	public void removeBesucher();

	public int[] getGesamtBesucherArray();

	public double[] getEinnahmenKategorieArray();

	public void addEinnahme(double einnahme, String besuchertyp);

	public void addFahrzeugtyp(String typ);

	public int[] getGesamtFahrzeugtypenArray();

}
