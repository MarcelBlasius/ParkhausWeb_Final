package testcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.*;

class StatistikTest {

	Statistik s;
	
	//Author: Teamarbeit
	@BeforeEach
	void setup() {
		s =	new Statistik(new ArrayList<Double>(), new ArrayList<Double>());
		
	}
	
	//Author: Marius Bauerfeind
	@Test
	@DisplayName("Einnahme wird korrekt gespeichert")
	void addEinnahmeTest() {
		s.addEinnahme(100, "any");
		
		//Einnahme wird durch 100 geteilt wg. Euro
		assertEquals(1, s.getGesamtEinnahmen());
		
	}
	//Author: Marius Bauerfeind
	@Test
	@DisplayName("Parkdauer wird korrekt gespeichert")
	void addParkdauerest() {
		s.addParkdauer(1000);
		
		//Parkdauer wird aufgrund von Sekunden durch 1000 geteilt
		assertEquals(1, s.getParkdauerMin());
		
		
	}
	
	
	

}
