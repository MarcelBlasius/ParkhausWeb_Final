package produktionscode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import commandPattern.AusfahrenCommand;
import commandPattern.EinfahrenCommand;
import commandPattern.ParkhausCommand;
import interfaces.IF_Parkhaus;
import interfaces.IF_Statistik;

// Author: Lars Gebhard
public class Parkhaus implements IF_Parkhaus {

	private String id;
	private List<Fahrzeug> carlist;
	private IF_Statistik s;
	private boolean[] parkplaetze;
	private List<ParkhausCommand> commandList = new ArrayList<ParkhausCommand>();

	public Parkhaus(String id, int parkplaetze, List<Fahrzeug> carlist, IF_Statistik s) {

		this.id = id;
		this.carlist = carlist;
		this.s = s;
		this.parkplaetze = new boolean[parkplaetze];
	}

	public int add(Fahrzeug c) {

		commandList.add(new EinfahrenCommand(this));
		carlist.add(c);

		for (int i = 0; i < parkplaetze.length; i++) {
			if (!parkplaetze[i]) {
				parkplaetze[i] = true;
				c.setParkplatz(i + 1);
				break;
			}
		}

		s.addBesucher(c.getBesucherArt());
		s.addFahrzeugtyp(c.getTyp());
		return c.getParkplatz();
	}

	public Fahrzeug remove(Fahrzeug c) {

		commandList.add(new AusfahrenCommand(this));
		carlist.remove(c);
		s.removeBesucher();
		setParkplatzBelegt(c.getParkplatz(), false);
		c.setParkplatz(-1);
		return c;

	}

	public Fahrzeug[] cars() {
		Fahrzeug[] carray = new Fahrzeug[carlist.size()];
		int pointer = 0;

		Iterator<Fahrzeug> it = carlist.iterator();

		while (it.hasNext()) {
			carray[pointer++] = it.next();
		}

		return carray;
	}

	public String getId() {
		return id;
	}

	public void setMaxParkplaetze(int maxParkplaetze) {

		boolean[] tmp = new boolean[maxParkplaetze];
		if (tmp.length >= parkplaetze.length) {
			for (int i = 0; i < parkplaetze.length; i++) {
				tmp[i] = parkplaetze[i];
			}
		} else {
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = parkplaetze[i];
			}
		}
		parkplaetze = tmp;
	}

	public void setParkplatzBelegt(int parkplatz, boolean belegt) {
		if (parkplatz - 1 < parkplaetze.length) {
			parkplaetze[parkplatz - 1] = belegt;
		}

	}

	public int getMaxParkplaetze() {
		return parkplaetze.length;

	}

	public boolean[] getParkplaetzeBelegtArray() {
		return parkplaetze;
	}

	public void setParkplaetzeBelegtArray(boolean[] parkplaetze) {
		this.parkplaetze = parkplaetze;

	}

	public IF_Statistik getStatistik() {
		return s;
	}

	public List<Fahrzeug> getCarlist() {
		return carlist;
	}

	public void setCarlist(List<Fahrzeug> carlist) {
		this.carlist = carlist;
	}

	public void setStatistik(IF_Statistik statistik) {
		this.s = statistik;
	}

	public void undo() {
		if (!commandList.isEmpty()) {
			commandList.remove(commandList.size() - 1).undo();
		}
	}

}
