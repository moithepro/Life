
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Loop implements ActionListener{
	private CustomPanel customPanel;
	
	public Loop(CustomPanel customPanel) {
		this.customPanel = customPanel;
	}


	public void actionPerformed(ActionEvent e) {
		this.customPanel.update();
	}
	
}
