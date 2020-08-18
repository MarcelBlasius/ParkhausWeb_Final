package produktionscode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;


// Author Lars Gebhard
public class Statistik extends AbstractPublisher{

	private List<Double> einnahmenList;
	private List<Double> parkdauerList;
	private List<Double> state = Arrays.asList(new Double[8]); // [GesamtEinnahmen, AvgEinnahmen, AvGParkdauer,
																// Besucheranzahl, MinEinnahmen, MinParkdauer,
																// MaxEinnahmen, MaxParkdauer]
	private int currentFrauen;
	private int currentAny;
	private int currentFamilie;
	private int currentBehinderte;
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
		this.parkdauerList = parkdauerList;
		
	}
	
	// Author Lars Gebhard
	//State Methods for Views
	public List<Double> getState() {
		return state;
	}
	
	// Author Lars Gebhard
	private void setState(int index, double value) {
		state.set(index, value);
		update();
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
		
		this.setState(2, parkdauerAvg);
		this.setState(5, parkdauerMin);
		this.setState(7, parkdauerMax);
		
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
		currentBesucher = getCurrentBesucher() + 1;

		this.setState(3, gesamtBesucher);

		switch (art) {
		case "Frau": {
			currentFrauen = getCurrentFrauen() + 1;
			gesamtFrauen++;
			break;
		}
		case "any": {
			currentAny = getCurrentAny() + 1;
			gesamtAny++;
			break;
		}
		case "Familie": {
			currentFamilie = getCurrentFamilie() + 1;
			gesamtFamilie++;
			break;
		}
		case "Behinderte": {
			currentBehinderte = getCurrentBehinderte() + 1;
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
			currentBesucher = getCurrentBesucher() - 1;

			switch (art) {
			case "Frau":
				currentFrauen = getCurrentFrauen() - 1;
				break;
			case "any":
				currentAny = getCurrentAny() - 1;
				break;
			case "Familie":
				currentFamilie = getCurrentFamilie() - 1;
				break;
			case "Behinderte":
				currentBehinderte = getCurrentBehinderte() - 1;
				break;
			default:
				System.out.println("Fehler Statistik removeBesucher: " + art);
			}
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
	
	//Author Marcel Blasius
	public double getGesamtEinnahmen() {

		return gesamtEinnahmen;

	}
	
	//Author Marcel Blasius
	public double getEinnahmenAvg() {
		return einnahmenAvg;
	}

	//Author Marcel Blasius
	public double getEinnahmenMin() {
		return einnahmenMin;

	}

	//Author Marcel Blasius
	public double getEinnahmenMax() {
		return einnahmenMax;
	}

	//Author Marcel Blasius
	public int getCurrentFrauen() {
		return currentFrauen;
	}

	//Author Marcel Blasius
	public int getCurrentAny() {
		return currentAny;
	}

	//Author Marcel Blasius
	public int getCurrentBehinderte() {
		return currentBehinderte;
	}
	
	//Author Marcel Blasius
	public int getCurrentFamilie() {
		return currentFamilie;
	}

	//Author Marcel Blasius
	public int getCurrentBesucher() {
		return currentBesucher;
	}
	
	//Author Marcel Blasius
	public int getGesamtBesucher() {
		return gesamtBesucher;
	}
	
	//Author Teamarbeit
	public void undo(String art) {
		
		gesamtBesucher--;
			switch (art) {
			case "Frau":
				gesamtFrauen--;
				break;
			case "any":
				gesamtAny--;
				break;
			case "Familie":
				gesamtFamilie--;
				break;
			case "Behinderte":
				gesamtBehinderte--;
				break;
			default:
				System.out.println("Fehler Statistik undo: " + art);
			}
		
		if(currentBesucher > 0) {
			currentBesucher--;

			switch (art) {
			case "Frau":
				currentFrauen--;
				break;
			case "any":
				currentAny--;
				break;
			case "Familie":
				currentFamilie--;
				break;
			case "Behinderte":
				currentBehinderte--;
				break;
			default:
				System.out.println("Fehler Statistik undo: " + art);
			}
		}
		
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
		
		
		this.setState(0, gesamtEinnahmen);
		this.setState(1, einnahmenAvg);
		this.setState(4, einnahmenMin);
		this.setState(6, einnahmenMax);
		
	}

}
