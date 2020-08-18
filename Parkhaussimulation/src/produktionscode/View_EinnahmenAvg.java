package produktionscode;

//Author: Marcel Blasius

public class View_EinnahmenAvg extends View{
	Double view;
	
	public Double getView() {
		return view;
	}
	
	@Override
	public void update() {	
		view = model.getState().get(1);
	}
}
