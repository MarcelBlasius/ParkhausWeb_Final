package produktionscode;

//Author: Lars Gebhard
public class View_GesamtEinnahmen extends View{
	
	Double view;
	
	public Double getView() {
		return view == null ? 0. : view;
	}
	
	@Override
	public void update() {	
		view = model.getState().getGesamtEinnahmen();
	}

}
