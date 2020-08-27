package produktionscode;

//Author: Marius Bauerfeind
public class View_ParkdauerMin extends View {
	Double view;
	
	public Double getView() {
		return view;
	}
	
	@Override
	public void update() {	
		view = model.getState().getMinParkdauer();
	}
}
