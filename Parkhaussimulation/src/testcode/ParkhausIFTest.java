package testcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IF_Parkhaus;
import interfaces.IF_Statistik;
import produktionscode.Fahrzeug;
import produktionscode.Parkhaus;
import produktionscode.Statistik;

// Author: Marcel Blasius
class ParkhausIFTest {

	IF_Parkhaus p;

	@BeforeEach
	void setup() {
		p = new Parkhaus("0", 10, new ArrayList<Fahrzeug>(),
				new Statistik(new ArrayList<Double>(), new ArrayList<Double>()));

	}

	
	@Test
	@DisplayName("Id wird korrekt ausgegeben")
	void test_id() {
		assertEquals("0", p.getId());
	}
	
	@Test
	@DisplayName("Fahrzeuge werden korrekt hinzugefuegt")
	void addtest() {
		Fahrzeug a = new Fahrzeug("a", "any", "PKW");
		assertEquals(1, p.add(a));
		assertSame(a, p.cars()[0]);
		assertEquals(2, p.add(a));

	}

	@Test
	@DisplayName("Fahrzeuge werden korrekt entfernt")
	void removetest() {
		Fahrzeug a = new Fahrzeug("a", "any", "PKW");
		assertEquals(1, p.add(a));
		assertSame(a, p.remove(a));
		assertEquals(1, p.add(new Fahrzeug("1", "any", "PKW")));

	}

	@Test
	@DisplayName("Array mit allen geparkten Fahrzeugen wird korrekt ausgegeben")
	void ArrayTest() {

		Fahrzeug[] carArray = new Fahrzeug[10];
		for (int i = 0; i < 10; i++) {
			Fahrzeug tmp = new Fahrzeug(String.valueOf(i), "any", "PKW");
			p.add(tmp);
			carArray[i] = tmp;
		}

		assertArrayEquals(carArray, p.cars());

	}

	@Test
	@DisplayName("Die richtige maximale Parkplatzkapazitaet wird ausgegeben")
	void maxParkplaetzeTest() {
		assertEquals(10, p.getMaxParkplaetze());

	}

	@Test
	@DisplayName("Undo Einfahren funktioniert")
	void undoEinfahrenTest() {
		IF_Statistik statistikExpected = p.getStatistik();
		boolean[] parkplaetzeExpected = p.getParkplaetzeBelegtArray();

		p.add(new Fahrzeug("id", "any", "PKW"));
		p.undo();
		assert (statistikExpected == p.getStatistik());
		assert (parkplaetzeExpected == p.getParkplaetzeBelegtArray());
	}

	@Test
	@DisplayName("Undo Ausfahren funktioniert")
	void undoAusfahrenTest() {
		Fahrzeug c = new Fahrzeug("id", "any", "PKW");
		p.add(c);
		IF_Statistik statistikExpected = p.getStatistik();
		boolean[] parkplaetzeExpected = p.getParkplaetzeBelegtArray();
		p.remove(c);
		p.undo();
		assert (statistikExpected == p.getStatistik());
		assert (parkplaetzeExpected == p.getParkplaetzeBelegtArray());
	}

}
