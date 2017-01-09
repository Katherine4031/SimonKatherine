package Simon;

import java.awt.Graphics2D;

import gui.components.Component;

public class Progress extends Component implements ProgressInterfaceKatherine {

	private int round;
	private int sequence;
	private boolean gameOver;
	public Progress(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	public void gameOver() {
		gameOver = true;
	}

	@Override
	public void setRound(int r) {
		round = r;
	}

	@Override
	public void setSequence(int s) {
		sequence = s;
	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}

}
