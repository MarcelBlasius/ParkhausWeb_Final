package produktionscode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//Author Lars Gebhard
public class Parkhaus implements IF_Parkhaus{
	
	private String id;
	private List<Car> carlist;
	private IF_Statistik s;
	private boolean[] parkplaetze;
	private List<ParkhausCommand> commandList = new ArrayList<ParkhausCommand>();
	
	public Parkhaus(String id, int parkplaetze, List<Car>carlist, IF_Statistik s ) {

		this.id = id;	
		this.carlist = carlist;
		this.s = s;
		this.parkplaetze = new boolean[parkplaetze];
	}
	
	@Override
	public int add(Car c) {
		
		commandList.add(new EinfahrenCommand(this));
		carlist.add(c);
		
		for(int i = 0; i < parkplaetze.length; i++) {
			if(!parkplaetze[i]) {
				parkplaetze[i] = true;
				c.setParkplatz(i + 1);
				break;
			}
		}
		
		
		s.addBesucher(c.getArt());
		s.addFahrzeugtyp(c.getTyp());
		return c.getParkplatz();
	}

	@Override
	public Car remove(Car c) {
		
		commandList.add(new AusfahrenCommand(this));
		carlist.remove(c);
		s.removeBesucher(c.getArt());
		setParkplatzBelegt(c.getParkplatz(), false);
		c.setParkplatz(-1);	
		return c;
		
	}

	@Override
	public Car[] cars() {
		Car[] carray = new Car[carlist.size()];
		int pointer = 0;
		
		Iterator<Car> it = carlist.iterator();
		
		while(it.hasNext()) {
			carray[pointer++] = it.next();		
		}
		
		return carray;
	}
	
	
	@Override
	public int size() {
		return carlist.size();
	}
	
	public String getId() {
		return id;
	}
	
	public IF_Statistik getStatistik() {
		return s;
	}
	
	public void setMaxParkplaetze(int maxParkplaetze) {
		
		boolean[] tmp = new boolean[maxParkplaetze];
		if(tmp.length >= parkplaetze.length) {
			for(int i = 0; i < parkplaetze.length; i++) {
				tmp[i] = parkplaetze[i];
			}
		} else {
			for(int i = 0; i < tmp.length; i++) {
				tmp[i] = parkplaetze[i];
			}
		}
		parkplaetze = tmp;
	}

	public void setParkplatzBelegt(int parkplatz, boolean belegt) {
		if(parkplatz - 1 < parkplaetze.length) {
			parkplaetze[parkplatz - 1] = belegt;
		}
		
	}
	
	public int getMaxParkplaetze() {
		return parkplaetze.length;
		
	}
	
	public List<Car> getCarlist() {
		return carlist;
	}
	
	public boolean[] getParkplaetze() {
		return parkplaetze;
	}
	
	public void setStatistik(IF_Statistik s) {
		this.s = s;
		
	}
	
	public void setCarlist(List<Car> carlist) {
		this.carlist = carlist;
	}
	
	public void setParkplaetze(boolean[] parkplaetzeBelegtArray) {
		this.parkplaetze = parkplaetzeBelegtArray;
	}
	
	public void undo() {
		if(!commandList.isEmpty()) {
			commandList.remove(commandList.size()-1).undo();
		}
	}

	
}
