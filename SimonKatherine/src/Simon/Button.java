package Simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.Component;

public class Button extends Component implements ButtonInterfaceKatherine {

	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public Button() {
		super(0, 0, 100, 100);
	}

	private Color color;
	private Color displayColor;
	private int x;
	private int y;
	private Action action;
	
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setColor(Color c) {
		color = c;
		displayColor = c;
		update();
	}

	@Override
	public void highlight() {
		displayColor = color;
		update();
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null) 
			g.setColor(displayColor);
		else 
			g.setColor(Color.gray);
		
		g.fillOval(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawOval(0, 0, getWidth()-1, getHeight()-1);
		}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x > 0 && x < getX() + getWidth() && y > 0 && y < getY() + getHeight()){
			return true;
		}
		return false;
	}

	@Override
	public void setAction(Action a) {
		action = a;
	}

	@Override
	public void dim() {
		update();
	}

}
