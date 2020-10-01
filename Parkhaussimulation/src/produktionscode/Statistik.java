package produktionscode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;

import interfaces.IF_State;
import interfaces.IF_Statistik;
import views.AbstractPublisher;
import views.State;

// Author: Lars Gebhard
public class Statistik extends AbstractPublisher implements IF_Statistik {

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

	private int gesamtPKW;
	private int gesamtPickup;
	private int gesamtSUV;
	private int gesamtZweirad;
	private int gesamtTrike;
	private int gesamtQuad;

	// Author Lars Gebhard
	public Statistik(List<Double> einnahmenList, List<Double> parkdauerList) {
		this.einnahmenList = einnahmenList;
		this.parkdauerList = parkdauerList;

	}

	// Author: Lars Gebhard
	
	public IF_State getState() {
		return state;
	}

	// Parkdauer Funktionen:
	
	// Author: Lars Gebhard
	
	private DoubleStream getParkdauerStream() {

		double[] array = new double[parkdauerList.size()];
		int pointer = 0;

		Iterator<Double> it = parkdauerList.iterator();

		while (it.hasNext()) {
			array[pointer++] = it.next();
		}
		return Arrays.stream(array);

	}

	// Author: Lars Gebhard
	
	public void addParkdauer(double f) {

		parkdauerList.add(f);
		parkdauerAvg = getParkdauerStream().average().orElse(0d) / 1000;
		parkdauerMin = getParkdauerStream().min().orElse(0d) / 1000;
		parkdauerMax = getParkdauerStream().max().orElse(0d) / 1000;

		state.setAvgParkdauer(parkdauerAvg);
		state.setMinParkdauer(parkdauerMin);
		state.setMaxParkdauer(parkdauerMax);
		update();

	}

	// Author: Marcel Blasius

	
	public void addBesucher(String art) {

		switch (art) {
		case "Frau": {
			gesamtFrauen++;
			incrementBesucher();
			break;
		}
		case "any": {
			gesamtAny++;
			incrementBesucher();
			break;
		}
		case "Familie": {
			gesamtFamilie++;
			incrementBesucher();
			break;
		}
		case "Behinderte": {
			gesamtBehinderte++;
			incrementBesucher();
			break;
		}
		default:
			System.out.println("Fehler Statistik: addBesucher: " + art);
		}

	}
	
	private void incrementBesucher() {
		gesamtBesucher++;
		currentBesucher++;

		state.setBesucheranzahl(gesamtBesucher);
		update();
	}

	// Author: Marcel Blasius

	public void removeBesucher() {

		if (currentBesucher != 0) {
			currentBesucher--;
		}
	}

	// Author: Marcel Blasius

	
	public int[] getGesamtBesucherArray() {
		int[] s = new int[4];
		s[0] = gesamtFrauen;
		s[1] = gesamtAny;
		s[2] = gesamtBehinderte;
		s[3] = gesamtFamilie;
		return s;
	}

	// Einnaehmen Funktionen

	// Author Marius Bauerfeind

	
	private DoubleStream getEinnahmeStream() {

		double[] array = new double[einnahmenList.size()];
		int pointer = 0;

		Iterator<Double> it = einnahmenList.iterator();

		while (it.hasNext()) {
			array[pointer++] = it.next();
		}

		return Arrays.stream(array);

	}

	// Author Marius Bauerfeind
	
	public double[] getEinnahmenKategorieArray() {
		double[] s = new double[4];
		s[0] = einnahmenFrauen;
		s[1] = einnahmenAny;
		s[2] = einnahmenBehinderte;
		s[3] = einnahmenFamilie;
		return s;
	}

	// Author Marius Bauerfeind
	
	public void addEinnahme(double x, String art) {

		switch (art) {
		case "Frau": {
			einnahmenFrauen += x / 100;
			einnahmenHinzufuegen(x);
			break;
		}
		case "any": {
			einnahmenAny += x / 100;
			einnahmenHinzufuegen(x);
			break;
		}
		case "Familie": {
			einnahmenFamilie += x / 100;
			einnahmenHinzufuegen(x);
			break;
		}
		case "Behinderte": {
			einnahmenBehinderte += x / 100;
			einnahmenHinzufuegen(x);
			break;
		}
		default:
			System.out.println("Statistik: Einnahme: " + art);
		}

	}
	
	private void einnahmenHinzufuegen(double x) {
		einnahmenList.add(x / 100);
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

	// Fahrzeugtypen Funktionen

	// Author Lars Gebhard
	public void addFahrzeugtyp(String typ) {

		switch (typ) {
		case "PKW": {
			gesamtPKW++;
			break;
		}
		case "Pickup": {
			gesamtPickup++;
			break;
		}
		case "SUV": {
			gesamtSUV++;
			break;
		}
		case "Zweirad": {
			gesamtZweirad++;
			break;
		}
		case "Trike": {
			gesamtTrike++;
			break;
		}
		case "Quad": {
			gesamtQuad++;
			break;
		}
		default:
			System.out.println("Fehler Statistik: addFahrzeugtyp: " + typ);
		}

	}

	// Author Lars Gebhard
	public int[] getGesamtFahrzeugtypenArray() {
		int[] s = new int[6];
		s[0] = gesamtPKW;
		s[1] = gesamtPickup;
		s[2] = gesamtSUV;
		s[3] = gesamtZweirad;
		s[4] = gesamtTrike;
		s[5] = gesamtQuad;
		return s;
	}

}
