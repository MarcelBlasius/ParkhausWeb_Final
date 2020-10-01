package testcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.Fahrzeug;
import produktionscode.IF_Fahrzeug;

//Author: Marius Bauerfeind
class CarIFTest {

	IF_Fahrzeug a;

	@BeforeEach
	void setup() {
		a = new Fahrzeug("1", "any", "PKW");

	}

	@Test
	@DisplayName("Erstellung eines Autos und Get Methoden funktionieren")
	void Autotest() {
		assertEquals("any", a.getArt());
		assertEquals("1", a.getID());
		assertEquals("PKW", a.getTyp());
	}

}
