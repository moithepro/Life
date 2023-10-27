import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseActions extends MouseAdapter {
	public CustomPanel customPanel;
	public MouseActions(CustomPanel customPanel) {
		this.customPanel = customPanel;
	}
	public void mouseClicked(MouseEvent e) {
		customPanel.mouseClicked(e);
	}
}
