package commandPattern;

import produktionscode.Parkhaus;

//Author Marius Bauerfeind
public class EinfahrenCommand extends ParkhausCommand {
	public EinfahrenCommand(Parkhaus p) {
		super(p);
	}
}