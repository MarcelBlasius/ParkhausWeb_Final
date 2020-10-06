package fahrzeugTypen;

import interfaces.IF_Fahrzeugtypen;

// Author: Jan Bauerfeind
public abstract class Fahrzeugtypen implements IF_Fahrzeugtypen {

	private double gebuehr;
	private double quadratmeter;

	public double getGebuehr() {
		return gebuehr;
	}

	public void setGebuehr(double gebuehr) {
		this.gebuehr = gebuehr;
	}

	public double getQuadratmeter() {
		return quadratmeter;
	}

	public void setQuadratmeter(double quadratmeter) {
		this.quadratmeter = quadratmeter;
	}
}