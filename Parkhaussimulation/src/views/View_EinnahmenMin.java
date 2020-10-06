package views;

// Author: Marcel Blasius
public class View_EinnahmenMin extends View {
	Double view;

	public Double getView() {
		return view == null ? 0d : view;
	}

	@Override
	public void update() {
		view = model.getState().getMinEinnahmen();
	}
}
