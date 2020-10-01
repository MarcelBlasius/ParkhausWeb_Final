package produktionscode;

//Author: Marius Bauerfeind
public class View_ParkdauerAvg extends View {
	Double view;

	public Double getView() {
		return view == null ? 0d : view;
	}

	@Override
	public void update() {
		view = model.getState().getAvgParkdauer();
	}
}
