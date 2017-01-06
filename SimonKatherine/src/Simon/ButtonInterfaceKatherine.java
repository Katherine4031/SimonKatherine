package Simon;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceKatherine extends Clickable {

	public void setX(int x);
	public void setY(int y);
	public void setColor(Color c);
	public void setAction(Action a);
	public void highlight();
		
}
