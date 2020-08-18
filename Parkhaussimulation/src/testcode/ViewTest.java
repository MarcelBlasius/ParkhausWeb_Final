package testcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.*;

class ViewTest {
	
	Statistik s;
	
	
	//Author: Teamarbeit
	@BeforeEach
	void setup() {
		s = new Statistik(new ArrayList<Double>(), new ArrayList<Double>());
		
	}
	
	//Author: Teamarbeit
	@Test
	@DisplayName("Gesamt Einnahmen werden upgedatet")
	void GesamtEinnahmenViewTest() {
		
		View_GesamtEinnahmen view = new View_GesamtEinnahmen();
		view.subscribe(s);
		assertSame(null, view.getView());
		s.addEinnahme(100, "any");
		assertEquals(1.0, view.getView());
		
	}
	
	//Author: Teamarbeit
	@Test
	@DisplayName("Einnahmen AVG wird upgedatet")
	void EinnahmenAvgViewTest() {
		
		View_EinnahmenAvg view = new View_EinnahmenAvg();
		view.subscribe(s);
		assertEquals(null, view.getView());
		s.addEinnahme(100, "any");
		assertEquals(1.0, view.getView());
		s.addEinnahme(300, "any");
		assertEquals(2.0, view.getView());
		
	}
	
	//Author: Marcel Blasius
	@Test
	@DisplayName("Parkdauer AVG wird upgedatet")
	void ParkdauerAvgViewTest() {
		
		View_ParkdauerAvg view = new View_ParkdauerAvg();
		view.subscribe(s);
		assertEquals(null, view.getView());
		s.addParkdauer(100);
		assertEquals(100.0, view.getView());
		s.addParkdauer(300);
		assertEquals(200.0, view.getView());
		
	}
	
	//Author: Marcel Blasius
	@Test
	@DisplayName("Besucheranzahl wird upgedatet")
	void BesucherAnzahlViewTest() {
		
		View_BesucherAnzahl view = new View_BesucherAnzahl();
		view.subscribe(s);
		assertEquals(null, view.getView());
		s.addBesucher("any");
		assertEquals(1, view.getView());
		
	}
	
	//Author: Lars Gebhard
	@Test
	@DisplayName("Einnahmen MIN wird upgedatet")
	void EinnahmenMinViewTest() {
		
		EinnahmenMinView view = new EinnahmenMinView();
		view.subscribe(p);
		assertEquals(null, view.getView());
		p.addEinnahme(1, "any");
		assertEquals(1.0, view.getView());
		p.addEinnahme(0.5, "any");
		assertEquals(0.5, view.getView());
		
	}
	
	//Author: Lars Gebhard
	@Test
	@DisplayName("Einnahmen Max wird upgedatet")
	void EinnahmenMaxViewTest() {
		
		EinnahmenMaxView view = new EinnahmenMaxView();
		view.subscribe(p);
		assertEquals(null, view.getView());
		p.addEinnahme(1, "any");
		assertEquals(1.0, view.getView());
		p.addEinnahme(2, "any");
		assertEquals(2.0, view.getView());
		
	}
	
	//Author: Marius Bauerfeind
	@Test
	@DisplayName("Parkdauer Min wird upgedatet")
	void ParkdauerMinViewTest() {
		
		View_ParkdauerMin view = new View_ParkdauerMin();
		view.subscribe(s);
		assertEquals(null, view.getView());
		s.addParkdauer(100);
		assertEquals(100.0, view.getView());
		s.addParkdauer(50);
		assertEquals(50.0, view.getView());
		
	}
	
	//Author: Marius Bauerfeind
	@Test
	@DisplayName("Parkdauer Max wird upgedatet")
	void ParkdauerMaxViewTest() {
		
		View_ParkdauerMax view = new View_ParkdauerMax();
		view.subscribe(s);
		assertEquals(null, view.getView());
		s.addParkdauer(100);
		assertEquals(100.0, view.getView());
		s.addParkdauer(200);
		assertEquals(200.0, view.getView());
		
	}
}
