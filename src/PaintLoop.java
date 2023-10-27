import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintLoop implements ActionListener{

private CustomPanel customPanel;
	
	public PaintLoop(CustomPanel customPanel) {
		this.customPanel = customPanel;
	}


	public void actionPerformed(ActionEvent e) {
		this.customPanel.repaint();
	}
}
