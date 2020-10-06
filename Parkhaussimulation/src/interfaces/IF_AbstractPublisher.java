package interfaces;

import views.View;

// Author: Team
public interface IF_AbstractPublisher {

	// Registriert die View
	public void addView(View view);

	// Aktualisieren aller registrierten Views
	public void update();
}
