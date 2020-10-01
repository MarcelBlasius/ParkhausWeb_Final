package produktionscode;

//Author: Marcel Blasius

public class View_EinnahmenAvg extends View {
	Double view;

	public Double getView() {
		return view == null ? 0d : view;
	}

	@Override
	public void update() {
		view = model.getState().getAvgEinnahmen();
	}
}
