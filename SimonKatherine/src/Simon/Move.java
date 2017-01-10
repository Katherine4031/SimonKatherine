package Simon;

public class Move implements MoveInterfaceKatherine {

	private ButtonInterfaceKatherine button;
	public Move(ButtonInterfaceKatherine b) {
		this.button = b;
	}
	public ButtonInterfaceKatherine getButton() {
		return button;
	}

}
