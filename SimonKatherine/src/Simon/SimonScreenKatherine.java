package Simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.components.ClickableScreen;

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
		ButtonInterfaceKatherine b = null;
		for(MoveInterfaceKatherine m : sequence){
			if(b != null){
				b.dim();
			}
			
			b = m.getButton();
			b.highlight();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String s) {
		try{
			label.setText(s);
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
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
		ButtonInterfaceKatherine b = new Button(0, 0, 100, 100);
		int rndIdx = (int)(Math.random()*button.length);
		
		while(rndIdx == lastSelectedButton){
			rndIdx = (int)(Math.random()*button.length);
		}
		return new Move(b);
	}

	private ProgressInterfaceKatherine getProgress() {
		return new Progress();
	}

	private void addButtons() {
		int numberOfButtons = 5;
		button = new ButtonInterfaceKatherine[numberOfButtons];
		Color[] colors = {Color.blue, Color.red, Color.yellow, Color.green, Color.black};
		for(int i = 0; i < numberOfButtons; i++){
			//optional: circle
			button[i] = getAButton();
			button[i].setColor(colors[i]);
			//change position of i
			button[i].setX(50*i + 100);
			button[i].setY(200);
			
			final ButtonInterfaceKatherine b = button[i];
			
			button[i].setAction(new Action(){

				public void act(){
					
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try{
									Thread.sleep(800);
								}catch(InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}	
					
						});
						blink.start();
					}
			
					if(b == sequence.get(sequenceIndex).getButton()){
						sequenceIndex++;
					}
					else{
						progress.gameOver();
						return;
					}
			
					if(sequenceIndex == sequence.size()){
						Thread nextRound = new Thread(SimonScreenKatherine.this);
						nextRound.start(); 
					}
				}
				
			});	
			
			viewObjects.add(b);
		}
	}

	private ButtonInterfaceKatherine getAButton() {
		return new Button();
	}

}
