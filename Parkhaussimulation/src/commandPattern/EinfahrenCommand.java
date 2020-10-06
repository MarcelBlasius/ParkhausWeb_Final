package commandPattern;

import produktionscode.Parkhaus;

// Author: Jan Bauerfeind
public class EinfahrenCommand extends ParkhausCommand {
	public EinfahrenCommand(Parkhaus p) {
		super(p);
	}
}
