package testcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.*;
import views.View_BesucherAnzahl;
import views.View_GesamtEinnahmen;
import views.View_ParkdauerMin;

class StatistikTest {

	Statistik s;
	private View_GesamtEinnahmen view_gesamtEinnahmen;
	private View_BesucherAnzahl view_besucherAnzahl;
	private View_ParkdauerMin view_parkdauerMin;

	// Author: Team
	@BeforeEach
	void setup() {
		s = new Statistik(new ArrayList<Double>(), new ArrayList<Double>());
		view_gesamtEinnahmen = new View_GesamtEinnahmen();
		view_besucherAnzahl = new View_BesucherAnzahl();
		view_parkdauerMin = new View_ParkdauerMin();

		view_gesamtEinnahmen.subscribe(s);
		view_besucherAnzahl.subscribe(s);
		view_parkdauerMin.subscribe(s);
	}

	// Author: Jan Bauerfeind
	@Test
	@DisplayName("Einnahme wird korrekt gespeichert")
	void addEinnahmeTest() {
		s.addEinnahme(100, "any");

		// Einnahme wird durch 100 geteilt wg. Euro
		assertEquals(1, view_gesamtEinnahmen.getView());
		s.addEinnahme(100, "FAKE");
		assertEquals(1, view_gesamtEinnahmen.getView());

	}

	// Author: Jan Bauerfeind
	@Test
	@DisplayName("Parkdauer wird korrekt gespeichert")
	void addParkdauerest() {
		s.addParkdauer(1000);

		// Parkdauer wird aufgrund von Sekunden durch 1000 geteilt
		assertEquals(1, view_parkdauerMin.getView());

	}

	// Author: Marcel Blasius
	@Test
	@DisplayName("Statistik ueber Besucher beim Hinzufuegen wird korrekt aktualisiert")
	void addBesucherTest() {
		assertEquals(0, view_besucherAnzahl.getView());
		s.addBesucher("any");
		assertEquals(1, view_besucherAnzahl.getView());

		s.addBesucher("FAKE");
		assertEquals(1, view_besucherAnzahl.getView());

	}

	// Author: Marcel Blasius
	@Test
	@DisplayName("Statistik ueber Besucher beim Entfernen wird korrekt aktualisiert")
	void removeBesucherTest() {
		assertEquals(0, view_besucherAnzahl.getView());
		s.removeBesucher();
		assertEquals(0, view_besucherAnzahl.getView());
		s.addBesucher("any");
		assertEquals(1, view_besucherAnzahl.getView());

	}

	// Author: Lars Gebhard
	@Test
	@DisplayName("BesucherArray wird korrekt ausgegeben")
	void getGesamtBesucherArrayTest() {

		int[] BesucherArray = { 1, 1, 1, 1 };

		s.addBesucher("any");
		s.addBesucher("Familie");
		s.addBesucher("Frau");
		s.addBesucher("Behinderte");
		assertArrayEquals(BesucherArray, s.getGesamtBesucherArray());

	}

	// Author: Lars Gebhard
	@Test
	@DisplayName("EinnahmeArray wird korrekt ausgegeben")
	void getEinnahmeKategorieArrayTest() {

		double[] einnahmeKategorieArray = { 1, 1, 1, 1 };

		s.addEinnahme(100, "any");
		s.addEinnahme(100, "Familie");
		s.addEinnahme(100, "Frau");
		s.addEinnahme(100, "Behinderte");
		assertArrayEquals(einnahmeKategorieArray, s.getEinnahmenKategorieArray());

	}

	// Author: Marcel Blasius
	@Test
	@DisplayName("Fahrzeugtypen werden korrekt gespeichert")
	void test_statistik_fahrzeugtypenAdd() {
		s.addFahrzeugtyp("PKW");
		s.addFahrzeugtyp("SUV");
		s.addFahrzeugtyp("Zweirad");
		s.addFahrzeugtyp("Trike");
		s.addFahrzeugtyp("Quad");
		s.addFahrzeugtyp("Pickup");
		int[] expected = { 1, 1, 1, 1, 1, 1 };
		assertArrayEquals(expected, s.getGesamtFahrzeugtypenArray());
		s.addFahrzeugtyp("FAKE");
		assertArrayEquals(expected, s.getGesamtFahrzeugtypenArray());
	}
}
