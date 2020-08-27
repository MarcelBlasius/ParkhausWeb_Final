package produktionscode;

//Author: Lars Gebhard
public class View_BesucherAnzahl extends View{
	Integer view;
	
	public Integer getView() {
		return view;
	}
	
	@Override
	public void update() {	
		view = model.getState().getBesucheranzahl();
	}
}
