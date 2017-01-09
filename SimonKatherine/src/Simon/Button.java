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

	private Color color;
	private Color displayColor;
	private int x;
	private int y;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}

}
