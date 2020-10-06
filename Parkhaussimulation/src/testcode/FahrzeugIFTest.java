package testcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IF_Fahrzeug;
import produktionscode.Fahrzeug;

// Author: Jan Bauerfeind
class FahrzeugIFTest {

	IF_Fahrzeug a;

	@BeforeEach
	void setup() {
		a = new Fahrzeug("1", "any", "PKW");

	}

	@Test
	@DisplayName("Erstellung eines Fahrzeuges und Get-Methoden funktionieren")
	void Autotest() {
		assertEquals("any", a.getBesucherArt());
		assertEquals("1", a.getID());
		assertEquals("PKW", a.getTyp());
	}

}
