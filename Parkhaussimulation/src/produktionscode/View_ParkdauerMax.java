package produktionscode;

//Author: Marius Bauerfeind
public class View_ParkdauerMax extends View{
	Double view;
	
	public Double getView() {
		return view;
	}
	
	@Override
	public void update() {	
		view = model.getState().getMaxParkdauer();
	}
}
