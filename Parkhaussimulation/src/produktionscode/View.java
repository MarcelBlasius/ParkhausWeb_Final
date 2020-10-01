package produktionscode;

public abstract class View {

	// Author: Teamarbeit
	IF_Statistik model;

	public void subscribe(Statistik model) {
		this.model = model;
		model.addView(this);
		update();

	}

	public abstract void update();
}
