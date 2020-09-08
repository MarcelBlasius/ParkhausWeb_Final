package produktionscode;

//Author: Marcel Blasius

public class View_EinnahmenMax extends View{
	Double view;
	
	public Double getView() {
		return view == null ? 0 : view;
	}
	
	@Override
	public void update() {	
		view = model.getState().getMaxEinnahmen();
	}
}
