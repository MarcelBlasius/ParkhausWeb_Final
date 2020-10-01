package views;

import interfaces.IF_Statistik;
import interfaces.IF_View;
import produktionscode.Statistik;

public abstract class View implements IF_View{

	// Author: Teamarbeit
	IF_Statistik model;

	public void subscribe(Statistik model) {
		this.model = model;
		model.addView(this);
		update();

	}

	public abstract void update();
}
