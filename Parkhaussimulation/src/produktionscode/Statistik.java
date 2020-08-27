package produktionscode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;


// Author Lars Gebhard
public class Statistik extends AbstractPublisher{

	private List<Double> einnahmenList;
	private List<Double> parkdauerList;
	private IF_State state = new State();

	private int currentBesucher;

	private int gesamtBesucher;
	private int gesamtFrauen;
	private int gesamtAny;
	private int gesamtFamilie;
	private int gesamtBehinderte;

	private double einnahmenFrauen;
	private double einnahmenAny;
	private double einnahmenFamilie;
	private double einnahmenBehinderte;

	private double gesamtEinnahmen;
	private double einnahmenAvg;
	private double einnahmenMin;
	private double einnahmenMax;
	
	private double parkdauerAvg;
	private double parkdauerMin;
	private double parkdauerMax;

	// Author Lars Gebhard
	public Statistik(List<Double> einnahmenList, List<Double> parkdauerList) {
		this.einnahmenList = einnahmenList;
		this.parkdauerList = parkdauerList;
		
	}
	
	// Author Lars Gebhard
	//State Methods for Views
	public IF_State getState() {
		return state;
	}	
	
	//Parkdauer Funktionen:
	// Author Lars Gebhard
	//Generiere Parkdauer Stream
	private DoubleStream getParkdauerStream() {

		double[] array = new double[parkdauerList.size()];
		int pointer = 0;
		
		Iterator<Double> it = parkdauerList.iterator();
		
		while(it.hasNext()) {
			array[pointer++] = it.next();	
		}
		return Arrays.stream(array);
		
	}
	// Author Lars Gebhard
	//Parkdauer hinzufuegen
	public void addParkdauer(double f) {

		parkdauerList.add(f);
		parkdauerAvg = getParkdauerStream().average().orElse(0d);
		parkdauerMin = getParkdauerStream().min().orElse(0d);
		parkdauerMax = getParkdauerStream().max().orElse(0d);
		
		state.setAvgParkdauer(parkdauerAvg);
		state.setMinParkdauer(parkdauerMin);
		state.setMaxParkdauer(parkdauerMax);
		update();
		
	}
	// Author Lars Gebhard
	public double getParkdauerAvg() {
		return parkdauerAvg / 1000;
		
		
	}
	// Author Lars Gebhard
	public double getParkdauerMin() {
		return parkdauerMin / 1000;
	}
	// Author Lars Gebhard
	public double getParkdauerMax() {
		return parkdauerMax / 1000;
	}
	
	//Author: Marcel Blasius
	
	//Besucher Funktionen
	public void addBesucher(String art) {
		gesamtBesucher++;
		currentBesucher++;
		
		state.setBesucheranzahl(gesamtBesucher);
		update();
		
		switch (art) {
		case "Frau": {
			gesamtFrauen++;
			break;
		}
		case "any": {
			gesamtAny++;
			break;
		}
		case "Familie": {
			gesamtFamilie++;
			break;
		}
		case "Behinderte": {
			gesamtBehinderte++;
			break;
		}
		default:
			System.out.println("Fehler Statistik: addBesucher: " + art);
		}

	}

	//Author: Marcel Blasius
	
	public void removeBesucher(String art) {
		
		if(currentBesucher != 0) {
			currentBesucher --;
		}
	}

	
	//Author: Marcel Blasius
	
	//Alle Besucher als Array ausgeben
	public int[] getGesamtBesucherArray() {
		int[] s = new int[4];
		s[0] = gesamtFrauen;
		s[1] = gesamtAny;
		s[2] = gesamtBehinderte;
		s[3] = gesamtFamilie;
		return s;
	}
	
	//Einnaehmen Funktionen
	
	
	//Author Marius Bauerfeind
	
	//Einnahme Stream erzeugen
	private DoubleStream getEinnahmeStream() {

		double[] array = new double[einnahmenList.size()];
		int pointer = 0;
		
		Iterator<Double> it = einnahmenList.iterator();
		
		while(it.hasNext()) {
			array[pointer++] = it.next();		
		}
		
		return Arrays.stream(array);
		
	}
	
	//Author Marius Bauerfeind
	//Alle Einnahmen pro Kategorie als Array ausgeben
	public double[] getEinnahmenKategorieArray() {
		double[] s = new double[4];
		s[0] = einnahmenFrauen;
		s[1] = einnahmenAny;
		s[2] = einnahmenBehinderte;
		s[3] = einnahmenFamilie;
		return s;
	}
	
	//Author Marius Bauerfeind
	//Einnahme hinzufuegen
	public void addEinnahme(double x, String art) {

		
		einnahmenList.add(x / 100);
		
		switch (art) {
		case "Frau": {
			einnahmenFrauen += x / 100;
			break;
		}
		case "any": {
			einnahmenAny += x / 100;
			break;
		}
		case "Familie": {
			einnahmenFamilie += x / 100;
			break;
		}
		case "Behinderte":{
			einnahmenBehinderte += x / 100;
			break;
		}
		default:
			System.out.println("Statistik: Einnahme: " + art);
		}
		
		gesamtEinnahmen = getEinnahmeStream().sum();
		einnahmenAvg = getEinnahmeStream().average().orElse(0d);
		
		einnahmenMin = getEinnahmeStream().min().orElse(0d);
		einnahmenMax = getEinnahmeStream().max().orElse(0d);
		
		state.setGesamtEinnahmen(gesamtEinnahmen);
		state.setAvgEinnahmen(einnahmenAvg);
		state.setMinEinnahmen(einnahmenMin);
		state.setMaxEinnahmen(einnahmenMax);
		update();
		
	}

}
