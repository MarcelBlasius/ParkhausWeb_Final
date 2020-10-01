package interfaces;

//Author: Teamarbeit

public interface IF_Statistik {

	public IF_State getState();

	public void addParkdauer(double parkdauer);

	public void addBesucher(String id);

	public void removeBesucher(String id);

	public int[] getGesamtBesucherArray();

	public double[] getEinnahmenKategorieArray();

	public void addEinnahme(double einnahme, String besuchertyp);

	public void addFahrzeugtyp(String typ);

	public int[] getGesamtFahrzeugtypenArray();

}
