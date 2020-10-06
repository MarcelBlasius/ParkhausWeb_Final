package commandPattern;

import java.util.List;

import interfaces.IF_Commands;
import interfaces.IF_Statistik;
import produktionscode.Fahrzeug;
import produktionscode.Parkhaus;

// Author: Jan Bauerfeind
public abstract class ParkhausCommand implements IF_Commands {
	Parkhaus p;

	private List<Fahrzeug> carlist;
	private IF_Statistik s;
	private boolean[] parkplaetze;

	public ParkhausCommand(Parkhaus p) {
		this.p = p;
		this.carlist = p.getCarlist();
		this.s = p.getStatistik();
		this.parkplaetze = p.getParkplaetzeBelegtArray();

	}

	public void undo() {
		p.setCarlist(this.carlist);
		p.setStatistik(this.s);
		p.setParkplaetzeBelegtArray(this.parkplaetze);
	}
}
