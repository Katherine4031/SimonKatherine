package Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.ClickableScreen;

public class SimonScreenKatherine extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceKatherine[] button;
	private ProgressInterfaceKatherine progress;
	private ArrayList<MoveInterfaceKatherine> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenKatherine(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		 label.setText("");
		 nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequence(sequence.size());
		changeText("Simon's turn");
		playSequence();
		changeText("Player's turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceKatherine b;
		for(int i = 0; i < sequence.size(); i++){
			if(b != null){
				dim();
			}
			//b = sequence[i].getButton();
			b.highlight();
			
			int sleepTime;
			try{
				//equation?
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String s) {
		try{
			Thread.sleep(1000);
			label.setText(s);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKatherine>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKatherine randomMove() {
		Button b;
		int rndIdx = (int)(Math.random()*button.length);
		
		while(rndIdx == lastSelectedButton){
			rndIdx = (int)(Math.random()*button.length);
		}
		return getMove(b);
	}

	private ProgressInterfaceKatherine getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons(List<Visible> viewObjects) {
		int numberOfButtons = 5;
		Color[] colors = {Color.blue, Color.red, Color.yellow, Color.green, Color.black};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceKatherine b = getAButton();
			//circle
			b.setColor(colors[i]);
			b.setX(0);
			b.setY(0);
			
			b.setAction(new Action(){

				public void act(){
					
				}
			});
			
			if(acceptingInput){
				Thread blink = new Thread(new Runnable(){

					public void run(){
						b.highlight();
						try{
							Thread.sleep(800);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					//b.dim();
					
				});
				blink.start();
			}
			
			if(b == sequence.get(sequenceIndex).getButton()){
				sequenceIndex++;
			}
			else{
				progress.gameOver();
			}
			
			if(sequenceIndex == sequence.size()){
				Thread nextRound = new Thread(SimonScreenKatherine.this);
				nextRound.start(); 
			}
			viewObjects.add(b);
		}
	}

	private ButtonInterfaceKatherine getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
