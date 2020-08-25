package produktionscode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;

public class Controller {
	// Author: Teamarbeit
	DecimalFormat formatToEuro = new DecimalFormat("#0.00");
	DecimalFormat formatToSeconds = new DecimalFormat("#0.000");
	private IF_Parkhaus p;
	private Statistik s;
	
	// Author: Lars Gebhard
	private static Controller instance = null;
	private Controller() {
		this.p = new Parkhaus("0", 9, new ArrayList<Car>(),
				new Statistik(new ArrayList<Double>(), new ArrayList<Double>()));
		s = p.getStatistik();
		
	}
	// Author: Lars Gebhard
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	// Author: Teamarbeit
	public String doGet(String param){

		switch (param) {

		case ("Gesamteinnahmen"): {
			return Gesamteinnahmen();
		}

		case ("avg"): {
			return avg();
		}

		case ("Besucheranzahl"): {
			return Besucheranzahl();

		}
		case ("min"): {
			return min();
		}

		case ("max"): {
			return max();
		}

		case ("Einnahmen_pro_Kategorie"): {
			return Einnahmen_pro_Kategorie();
		}

		case ("Anteil_Besucher"): {
			return Anteil_Besucher();
		}

		default:
			System.out.println("Fehler Controller createResonse " + param);
			return null;

		}

	}

	// Author: Teamarbeit
	public String doPost(String event, String[] params) {

		switch (event) {
		
		case ("enter"): {
			return enter(params);
		}

		case ("leave"): {
			return leave(params);
		}
		default:System.out.println("Event im Post nicht gefunden "+event);

		}

		// Default return;
		return null;
	}

	// Author: Marius Bauerfeind
	private String Gesamteinnahmen() {
		return ("Gesamteinnahmen: " + formatToEuro.format(s.getGesamtEinnahmen()) + " Euro");
	}

	// Author: Marius Bauerfeind
	private String avg() {
		return ("Durchschnittspreis: " + formatToEuro.format(s.getEinnahmenAvg()) + " Euro | " + "Durchschnittsdauer: "
				+ formatToSeconds.format(s.getParkdauerAvg()) + " Sekunden");
	}

	// Author: Marius Bauerfeind
	private String Besucheranzahl() {
		return (s.getGesamtBesucher() + " Besucher");
	}

	// Author: Marius Bauerfeind
	private String min() {
		return ("Min Parkgebuehr: " + formatToEuro.format(s.getEinnahmenMin()) + " Euro bei "
				+ formatToSeconds.format(s.getParkdauerMin()) + " Sekunden Parkdauer");
	}

	// Author: Marius Bauerfeind
	private String max() {
		return ("max Parkgebuehr: " + formatToEuro.format(s.getEinnahmenMax()) + " Euro bei "
				+ formatToSeconds.format(s.getParkdauerMax()) + " Sekunden Parkdauer");
	}

	// Author: Marius Bauerfeind
	private String Anteil_Besucher() {
		int[] besuchergesamt = s.getGesamtBesucherArray();

		JsonObject root = Json.createObjectBuilder().add("data", Json.createArrayBuilder().add(Json
				.createObjectBuilder()
				.add("values",
						Json.createArrayBuilder().add(besuchergesamt[0]).add(besuchergesamt[1]).add(besuchergesamt[2])
								.add(besuchergesamt[3]))
				.add("labels", Json.createArrayBuilder().add("Frauen").add("Any").add("Behinderte").add("Familien"))
				.add("type", "pie"))).build();

		return root.toString();
	}

	// Author: Marius Bauerfeind
	private String Einnahmen_pro_Kategorie() {

		double[] einnahmenKategorie = s.getEinnahmenKategorieArray();
		JsonObject root = Json.createObjectBuilder()
				.add("data", Json.createArrayBuilder().add(Json.createObjectBuilder()
						.add("x", Json.createArrayBuilder().add("Frauen").add("Any").add("Behinderte").add("Familien"))
						.add("y",
								Json.createArrayBuilder().add(einnahmenKategorie[0]).add(einnahmenKategorie[1])
										.add(einnahmenKategorie[2]).add(einnahmenKategorie[3]))
						.add("type", "bar").add("name", "Einnahmen pro Kategorie")))
				.build();

		return (root.toString());
	}

	// Author: Marius Bauerfeind
	private String enter(String[] params) {
		return String.valueOf(p.add(new Car(params[1], params[8])));
	}

	// Author: Marius Bauerfeind
	private String leave(String[] params) {
		String priceString = params[4];
		float dauer = Float.parseFloat(params[3]);
		Car[] cars = p.cars();
		Car tmp = null;
		for (Car i : cars) {
			if (i.getID().equals(params[1])) {
				tmp = i;
			}
		}
		Car c = null;

		if (tmp != null) {
			c = p.remove(tmp);
		}

		if (c != null && !"_".equals(priceString)) {
			float price = Float.parseFloat(priceString);
			s.addEinnahme(price, params[8]);
			s.addParkdauer(dauer);
		}
		
		if(c == null) {
			return "Car ist null";
		} else {
		return c.getID();
		}
	}
	
	// Author: Lars Gebhard
	public void reset(){
		instance = null;
	}
}