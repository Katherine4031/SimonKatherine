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
		super(0, 0, width, height);
	}

	private Color color;
	private Color displayColor;
	private Action action;
	private static int width = 50;
	private static int height = 50;
	

	@Override
	public void setColor(Color c) {
		color = c;
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
		
		g.fillOval(0, 0, width, height);
		g.setColor(Color.black);
		g.drawOval(0, 0, width-1, height-1);
		}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+width/2), 2)+Math.pow(y-(getY()+height/2), 2));
		return distance < width/2;
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
