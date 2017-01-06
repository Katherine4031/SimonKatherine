package Simon;

import gui.practice.GUIApplication;

public class SimonGameKatherine extends GUIApplication {

	public SimonGameKatherine() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SimonScreenKatherine ssk = new SimonScreenKatherine(getWidth(), getHeight());
		setScreen(ssk);
	}

	public static void main(String[] args) {
		SimonGameKatherine sgk = new SimonGameKatherine();
		Thread app = new Thread(sgk);
		app.start();
	}

}
