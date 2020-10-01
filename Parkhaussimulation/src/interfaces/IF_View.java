package interfaces;

import produktionscode.Statistik;

//Author Teamarbeit
public interface IF_View {
	
	//Abonniert ein Model -> dieses fuegt das View der View Liste hinzu
	public void subscribe(Statistik model);

	//Update Funktion fuer spezialisierende Views
	public abstract void update();
}
