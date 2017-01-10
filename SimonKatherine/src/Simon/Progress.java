package Simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;

public class Progress extends Component implements ProgressInterfaceKatherine {

	public Progress() {
		super(40, 45, width, height);
	}

	private int round;
	private int sequence;
	private boolean gameOver;
	private static int width = 200;
	private static int height = 70;

	
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int r) {
		round = r;
		update();
	}

	@Override
	public void setSequence(int s) {
		sequence = s;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			g.setColor(new Color(255,55,90));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, ((getWidth())/2)-50, 20);
			g.drawString("Sequence Length: " + Integer.toString(sequence), ((getWidth())/2)-50, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.black);
			g.drawRect(0, 0, getWidth()-1, getHeight()-1);
			if(Integer.toString(round) !=null && Integer.toString(sequence) != null){

				g.drawString("Round " + Integer.toString(round), ((getWidth())/2)-20, 20);
				g.drawString("Sequence " + Integer.toString(sequence), ((getWidth())/2)-20, 40);
			}
		}
	}

}
