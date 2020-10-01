package testcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IF_Controller;
import produktionscode.*;

//Author Marcel Blasius
class ControllerTest {

	IF_Controller c = Controller.getInstance();

	@BeforeEach
	void setup() {
		c.reset();
		String id = "1";
		String art = "any";
		String dauer = "15";
		String preis = "30";
		String typ = "PKW";

		String[] params = { "", id, "", dauer, preis, "", "", "", art, typ };
		c.doPost("enter", params);

		params[1] = "2";
		params[8] = "Familie";
		params[9] = "Pickup";
		c.doPost("enter", params);

		c.doPost("leave", params);

		params[1] = "1"; // ID
		params[3] = "45"; // Dauer
		params[4] = "60"; // Preis
		params[8] = "any"; // Art
		params[9] = "PKW"; // Typ

		c.doPost("leave", params);

		params[1] = "3";
		params[8] = "Frau";
		params[9] = "Quad";
		c.doPost("enter", params);

	}

	@Test
	@DisplayName("Abfangen nicht vorhandener Post befehle")
	void test_doPost_falscherCmd() {
		String expected = "Event im Post nicht gefunden cmd";
		assertEquals(expected, c.doPost("cmd", null));
	}
	
	@Test
	@DisplayName("Abfangen nicht vorhandener Get befehle")
	void test_doGet_falscherCmd() {
		String[] params = { "", "3", "", "", "", "", "", "", "any", "PKW" };
		String expected = "Fehler Controller createResonse cmd";
		assertEquals(expected, c.doGet("cmd"));
	}
	@Test
	@DisplayName("Event Enter wird korrekt ausgef�hrt")
	void test_doPost_enter() {
		String[] params = { "", "3", "", "", "", "", "", "", "any", "PKW" };
		String expected = "2";
		assertEquals(expected, c.doPost("enter", params));
		params[1] = "4";
		expected = "3";
		assertEquals(expected, c.doPost("enter", params));
	}

	@Test
	@DisplayName("Event Leave wird korrekt ausgef�hrt")
	void test_doPost_leave() {
		String art = "any";
		String id = "3";
		String preis = "10";
		String dauer = "15";

		String params[] = { "", id, "", dauer, preis, "", "", "", art };

		assertEquals("3", c.doPost("leave", params));
		params[1] = "null";
		assertEquals("Car ist null", c.doPost("leave", params));

	}

	@Test
	@DisplayName("Gesamteinnahmen werden korrekt zur�ckgegeben")
	void test_doGet_Gesamteinnahmen() {
		String expected = "Gesamteinnahmen: 0,90 Euro";
		assertEquals(expected, c.doGet("Gesamteinnahmen"));
	}

	@Test
	@DisplayName("Der Durchschnittspreis und die Durchschnittsdauer werden korrekt zur�ckgegeben")
	void test_doGet_avg() {
		String expected = "Durchschnittspreis: 0,45 Euro | Durchschnittsdauer: 0,030 Sekunden";
		assertEquals(expected, c.doGet("avg"));
		c.reset();
		expected = "Es wurde noch kein Parkticket bezahlt.";
		assertEquals(expected, c.doGet("avg"));
	}

	@Test
	@DisplayName("Die Besucheranzahl wird korrekt zur�ckgegeben")
	void test_doGet_Besucheranzahl() {
		String expected = "3 Besucher";
		assertEquals(expected, c.doGet("Besucheranzahl"));
		c.reset();
		expected = "Es wurde noch kein Parkticket bezahlt.";
		assertEquals(expected, c.doGet("Besucheranzahl"));
	}

	@Test
	@DisplayName("Die minimale Parkgebuehr und Parkdauer wird korrekt zur�ckgegeben")
	void test_doGet_min() {
		String expected = "Min Parkgebuehr: 0,30 Euro bei 0,015 Sekunden Parkdauer";
		assertEquals(expected, c.doGet("min"));
		c.reset();
		expected = "Es wurde noch kein Parkticket bezahlt.";
		assertEquals(expected, c.doGet("min"));
	}

	@Test
	@DisplayName("Die maximale Parkgebuehr und Parkdauer wird korrekt zur�ckgegeben")
	void test_doGet_max() {
		String expected = "max Parkgebuehr: 0,60 Euro bei 0,045 Sekunden Parkdauer";
		assertEquals(expected, c.doGet("max"));
		c.reset();
		expected = "Es wurde noch kein Parkticket bezahlt.";
		assertEquals(expected, c.doGet("max"));
	}

	@Test
	@DisplayName("Der JSON String fuer die Grafik der Einnahmen pro Kategorie wird korrekt zur�ckgegeben")
	void test_doGet_Einnahmen_pro_Kategorie() {
		String expected = "{\"data\":[{\"x\":[\"Frauen\",\"Any\",\"Behinderte\",\"Familien\"],\"y\":[0.0,0.6,0.0,0.3],\"type\":\"bar\",\"name\":\"Einnahmen pro Kategorie\"}]}";
		assertEquals(expected, c.doGet("Einnahmen_pro_Kategorie"));
	}

	@Test
	@DisplayName("Der JSON String fuer die Grafik der Anteil der Besucher wird korrekt zur�ckgegeben")
	void test_doGet_Anteil_Besucher() {
		String expected = "{\"data\":[{\"values\":[1,1,0,1],\"labels\":[\"Frauen\",\"Any\",\"Behinderte\",\"Familien\"],\"type\":\"pie\"}]}";
		assertEquals(expected, c.doGet("Anteil_Besucher"));
	}

	@Test
	@DisplayName("Der JSON String fuer die Grafik der Anteil der Fahrzeugtypen wird korrekt zur�ckgegeben")
	void test_doGet_Anteil_Fahrzeugtypen() {
		String expected = "{\"data\":[{\"values\":[1,1,0,0,0,1],\"labels\":[\"PKW\",\"Pickup\",\"SUV\",\"Zweirad\",\"Trike\",\"Quad\"],\"type\":\"pie\"}]}";
		assertEquals(expected, c.doGet("Anteil_Fahrzeugtypen"));
	}
	
	@Test
	@DisplayName("Maximale Parkplatzanzahl anpassen funktioniert")
	void test_change_max() {
		String[] params = {"","","15"};
		assertEquals("change_max behandelt", c.doPost("change_max", params));
		params[2] = "1";
		assertEquals("change_max behandelt", c.doPost("change_max", params));
	}
	
	@Test
	@DisplayName("Reset Funktioniert")
	void test_reset() {
		c.reset();
		assert(c == Controller.getInstance());
	}

}
