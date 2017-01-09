package Simon;

public class Progress extends Component implements ProgressInterfaceKatherine {

	private int round;
	private int sequence;
	private boolean gameOver;
	public Progress()
	{
		
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

}
