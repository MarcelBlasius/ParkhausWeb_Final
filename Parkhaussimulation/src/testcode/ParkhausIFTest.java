package testcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produktionscode.Car;
import produktionscode.Parkhaus;
import produktionscode.Statistik;
import produktionscode.IF_Parkhaus;
import produktionscode.IF_Statistik;


//Author Marcel Blasius
class ParkhausIFTest {

	IF_Parkhaus p;
	
	@BeforeEach
	void setup() {
		p = new Parkhaus("0", 10 ,new ArrayList<Car>(),
				new Statistik(new ArrayList<Double>(), new ArrayList<Double>()));
		
	}
	
	@Test
	@DisplayName("Autos werden korrekt hinzugefuegt")
	void addtest() {
		Car a = new Car("a" , "any","PKW");
		assertEquals(1, p.add(a));
		assertSame(a , p.cars()[0]);
		assertEquals(2, p.add(a));
		
	}
	
	@Test
	@DisplayName("Autos werden korrekt entfernt")
	void removetest() {
		Car a = new Car("a" , "any","PKW");
		assertEquals(1, p.add(a));
		assertSame(a, p.remove(a));
		assertEquals(1, p.add(new Car("1", "any","PKW")));
		
	}
	
	@Test
	@DisplayName("Anzahl geparkter Autos wird korrekt ausgegeben")
	void sizeTest() {
		
		for(int i = 0; i < 10; i ++) {
			p.add(new Car(String.valueOf(i) , "any","PKW"));
			
		}
		assertSame(10, p.size());
		
	}
	
	@Test
	@DisplayName("Array mit allen geparkten Autos wird korrekt ausgegeben")
	void ArrayTest() {
		
		Car[] carArray = new Car[10];
		for(int i = 0; i < 10; i ++) {
			Car tmp = new Car(String.valueOf(i), "any","PKW");
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
		List<Car> carListExpected = p.getCarlist();
		boolean[] parkplaetzeExpected = p.getParkplaetze();
		
		p.add(new Car("id", "any","PKW"));		
		p.undo();
		assert(statistikExpected == p.getStatistik());
		assert(carListExpected == p.getCarlist());
		assert(parkplaetzeExpected == p.getParkplaetze());
	}
	
	@Test
	@DisplayName("Undo Ausfahren funktioniert")
	void undoAusfahrenTest() {
		Car c = new Car("id", "any","PKW");
		p.add(c);	
		IF_Statistik statistikExpected = p.getStatistik();
		List<Car> carListExpected = p.getCarlist();
		boolean[] parkplaetzeExpected = p.getParkplaetze();
		p.remove(c);
		p.undo();
		assert(statistikExpected == p.getStatistik());
		assert(carListExpected == p.getCarlist());
		assert(parkplaetzeExpected == p.getParkplaetze());
	}
	
	

}
