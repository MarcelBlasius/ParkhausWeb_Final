package produktionscode;

//Author: Lars Gebhard
public class View_GesamtBesucher extends View{
	Double view;
	
	public Double getView() {
		return view;
	}
	
	@Override
	public void update() {	
		view = model.getState().get(8);
	}
}
