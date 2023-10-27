import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyActions extends KeyAdapter {
	public CustomPanel customPanel;

	public KeyActions(CustomPanel customPanel) {
		this.customPanel = customPanel;
	}

	public void keyPressed(KeyEvent e) {
		customPanel.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		customPanel.keyReleased(e);
	}

}