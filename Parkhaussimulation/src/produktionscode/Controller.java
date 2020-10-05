package produktionscode;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;

import interfaces.IF_Controller;
import interfaces.IF_Parkhaus;
import views.View_BesucherAnzahl;
import views.View_EinnahmenAvg;
import views.View_EinnahmenMax;
import views.View_EinnahmenMin;
import views.View_GesamtEinnahmen;
import views.View_ParkdauerAvg;
import views.View_ParkdauerMax;
import views.View_ParkdauerMin;

public class Controller implements IF_Controller{
	// Author: Teamarbeit
	DecimalFormat formatToEuro = new DecimalFormat("#0.00");
	DecimalFormat formatToSeconds = new DecimalFormat("#0.000");
	private IF_Parkhaus p;
	private Statistik s;
	private View_BesucherAnzahl view_besucherAnzahl = new View_BesucherAnzahl();
	private View_EinnahmenAvg view_einnahmenAvg = new View_EinnahmenAvg();
	private View_EinnahmenMax view_einnahmenMax = new View_EinnahmenMax();
	private View_EinnahmenMin view_einnahmenMin = new View_EinnahmenMin();
	private View_GesamtEinnahmen view_gesamtEinnahmen = new View_GesamtEinnahmen();
	private View_ParkdauerAvg view_parkdauerAvg = new View_ParkdauerAvg();
	private View_ParkdauerMax view_parkdauerMax = new View_ParkdauerMax();
	private View_ParkdauerMin view_parkdauerMin = new View_ParkdauerMin();

	// Author: Lars Gebhard
	private static IF_Controller instance = null;

	private Controller() {
		init();
	}

	// Author: Lars Gebhard
	public static IF_Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	// Author: Teamarbeit
	public String doGet(String param) {

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

		case ("Anteil_Fahrzeugtypen"): {
			return Anteil_Fahrzeugtypen();
		}
		
		case ("config&name"):{
			return null;
		}
		
		case ("cars&name"):{
			return null;
		}

		default:
			System.out.println("Fehler Controller createResonse " + param);
			return ("Fehler Controller createResonse " + param);

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

		case ("change_max"): {
			change_max(params);
			return null;
		}

		case ("full"): {
			return null;
		}
		
		case ("change_open_from"):{
			return null;
		}
		
		case ("change_open_to"):{
			return null;
		}
		default:
			System.out.println("Event im Post nicht gefunden " + event);
			return("Event im Post nicht gefunden " + event);
			

		}
	
	}

	// Author: Marius Bauerfeind
	private String Gesamteinnahmen() {

		return ("Gesamteinnahmen: " + formatToEuro.format(view_gesamtEinnahmen.getView()) + " Euro");
	}

	// Author: Marius Bauerfeind
	private String avg() {
		if (view_einnahmenAvg.getView() != 0d) {
			return ("Durchschnittspreis: " + formatToEuro.format(view_einnahmenAvg.getView()) + " Euro | "
					+ "Durchschnittsdauer: " + formatToSeconds.format(view_parkdauerAvg.getView()) + " Sekunden");
		} else {
			return "Es wurde noch kein Parkticket bezahlt.";
		}
	}

	// Author: Marius Bauerfeind
	private String Besucheranzahl() {
		if (view_besucherAnzahl.getView() != 0d) {

			return (view_besucherAnzahl.getView() + " Besucher");
		} else {
			return "Es wurde noch kein Parkticket bezahlt.";

		}
	}

	// Author: Marius Bauerfeind
	private String min() {
		if (view_parkdauerMin.getView() != 0d) {

			return ("Min Parkgebuehr: " + formatToEuro.format(view_einnahmenMin.getView()) + " Euro bei "
					+ formatToSeconds.format(view_parkdauerMin.getView()) + " Sekunden Parkdauer");
		} else {
			return "Es wurde noch kein Parkticket bezahlt.";

		}
	}

	// Author: Marius Bauerfeind
	private String max() {
		if (view_parkdauerMax.getView() != 0d) {

			return ("max Parkgebuehr: " + formatToEuro.format(view_einnahmenMax.getView()) + " Euro bei "
					+ formatToSeconds.format(view_parkdauerMax.getView()) + " Sekunden Parkdauer");
		} else {
			return "Es wurde noch kein Parkticket bezahlt.";
		}
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

	private String Anteil_Fahrzeugtypen() {
		int[] fahrzeugtypengesamt = s.getGesamtFahrzeugtypenArray();

		JsonObject root = Json.createObjectBuilder()
				.add("data",
						Json.createArrayBuilder().add(Json.createObjectBuilder().add("values",
								Json.createArrayBuilder().add(fahrzeugtypengesamt[0]).add(fahrzeugtypengesamt[1])
										.add(fahrzeugtypengesamt[2]).add(fahrzeugtypengesamt[3])
										.add(fahrzeugtypengesamt[4]).add(fahrzeugtypengesamt[5]))
								.add("labels", Json.createArrayBuilder().add("PKW").add("Pickup").add("SUV")
										.add("Zweirad").add("Trike").add("Quad"))
								.add("type", "pie")))
				.build();

		return root.toString();
	}

	// Author: Marius Bauerfeind
	private String enter(String[] params) {
		return String.valueOf(p.add(new Fahrzeug(params[1], params[8], params[9])));
	}

	// Author: Marius Bauerfeind
	private String leave(String[] params) {
		String priceString = params[4];
		float dauer = Float.parseFloat(params[3]);
		Fahrzeug[] cars = p.cars();
		Fahrzeug tmp = null;
		for (Fahrzeug i : cars) {
			if (i.getID().equals(params[1])) {
				tmp = i;
			}
		}
		Fahrzeug c = null;

		if (tmp != null) {
			c = p.remove(tmp);
		}

		if (c != null && !"_".equals(priceString)) {
			float price = Float.parseFloat(priceString);
			s.addEinnahme(price, c.getBesucherArt());
			s.addParkdauer(dauer);
		}

		if (c == null) {
			return "Car ist null";
		} else {
			return c.getID();
		}
	}

	// Author: Marcel Blasius
	private void change_max(String[] params) {
		p.setMaxParkplaetze(Integer.parseInt(params[2]));
	}

	// Author: Lars Gebhard
	@SuppressWarnings("static-access")
	public void reset() {
		init();
	}
	
	private void init() {
		this.p = new Parkhaus("0", 10, new ArrayList<Fahrzeug>(),
				new Statistik(new ArrayList<Double>(), new ArrayList<Double>()));

		// Statistik Cast, da dass Interface den AbstractPublisher nicht extenden kann
		s = (Statistik) p.getStatistik();

		// Views als Teamarbeit
		view_besucherAnzahl.subscribe(s);
		view_einnahmenAvg.subscribe(s);
		view_einnahmenMax.subscribe(s);
		view_einnahmenMin.subscribe(s);
		view_gesamtEinnahmen.subscribe(s);
		view_parkdauerAvg.subscribe(s);
		view_parkdauerMax.subscribe(s);
		view_parkdauerMin.subscribe(s);
	}
}