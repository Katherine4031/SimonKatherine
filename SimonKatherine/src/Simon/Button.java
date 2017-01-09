package Simon;

import java.awt.Color;
import java.awt.RenderingHints;

public class Button extends Component implements ButtonInterfaceKatherine {

	private Color color;
	private Color displayColor;
	
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
		
	}

}
