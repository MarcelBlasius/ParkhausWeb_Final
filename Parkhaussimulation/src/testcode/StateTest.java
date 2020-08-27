package testcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.IF_State;
import produktionscode.State;

class StateTest {
	
	IF_State s = new State();

	@Test
	@DisplayName("Gesamteinnahme wird korrekt gespeichert")
	void gesamtEinnahmenTest() {
		s.setGesamtEinnahmen(10.5);
		assertEquals(10.5,s.getGesamtEinnahmen());
	}
	
	@Test
	@DisplayName("Einnahmendurchschnitt wird korrekt gespeichert")
	void avgEinnahmenTest() {
		s.setAvgEinnahmen(10.5);
		assertEquals(10.5,s.getAvgEinnahmen());
	}
	@Test
	@DisplayName("Parkdauerdurchschnitt wird korrekt gespeichert")
	void avgParkdauerTest() {
		s.setAvgParkdauer(5.5);
		assertEquals(5.5,s.getAvgParkdauer());
	}
	@Test
	@DisplayName("Besucheranzahl wird korrekt gespeichert")
	void besucheranzahlTest() {
		s.setBesucheranzahl(7);;
		assertEquals(7,s.getBesucheranzahl());
	}
	@Test
	@DisplayName("Einnahmenminimum wird korrekt gespeichert")
	void minEinnahmenTest() {
		s.setMinEinnahmen(10.5);;
		assertEquals(10.5,s.getMinEinnahmen());
	}
	@Test
	@DisplayName("Parkdauerminimum wird korrekt gespeichert")
	void minParkdauerTest() {
		s.setMinParkdauer(5.5);;
		assertEquals(5.5,s.getMinParkdauer());
	}
	@Test
	@DisplayName("Einnahmenmaximum wird korrekt gespeichert")
	void maxEinnahmenTest() {
		s.setMaxEinnahmen(10.5);
		assertEquals(10.5,s.getMaxEinnahmen());
	}
	@Test
	@DisplayName("Parkdauermaximum wird korrekt gespeichert")
	void maxParkdauerTest() {
		s.setMaxParkdauer(5.5);
		assertEquals(5.5,s.getMaxParkdauer());
	}

}
