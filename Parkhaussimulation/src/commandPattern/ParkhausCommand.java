package commandPattern;

import java.util.List;

import interfaces.IF_Statistik;
import produktionscode.Fahrzeug;
import produktionscode.Parkhaus;

//Author Marius Bauerfeind
public abstract class ParkhausCommand {
	Parkhaus p;

	List<Fahrzeug> carlist;
	IF_Statistik s;
	boolean[] parkplaetze;

	public ParkhausCommand(Parkhaus p) {
		this.p = p;
		this.carlist = p.getCarlist();
		this.s = p.getStatistik();
		this.parkplaetze = p.getParkplaetze();

	}

	public void undo() {
		p.setCarlist(this.carlist);
		p.setStatistik(this.s);
		p.setParkplaetze(this.parkplaetze);
	}
}
