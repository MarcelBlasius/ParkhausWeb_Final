package views;

import java.util.ArrayList;
import java.util.List;

import interfaces.IF_AbstractPublisher;

// Author: Team
public class AbstractPublisher implements IF_AbstractPublisher {

	private List<View> views = new ArrayList<View>();

	public void addView(View view) {
		this.views.add(view);
	}

	public void update() {
		for (View view : views) {
			view.update();
		}

	}
}
