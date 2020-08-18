package produktionscode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;


// Author Lars Gebhard
public class Statistik extends AbstractPublisher{

	private List<Double> parkdauerList;
	private List<Double> state = Arrays.asList(new Double[8]); // [GesamtEinnahmen, AvgEinnahmen, AvGParkdauer,
																// Besucheranzahl, MinEinnahmen, MinParkdauer,
																// MaxEinnahmen, MaxParkdauer]

	private int currentBesucher;

	private int gesamtBesucher;
	private int gesamtFrauen;
	private int gesamtAny;
	private int gesamtFamilie;
	private int gesamtBehinderte;

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
}
