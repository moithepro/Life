
import javax.swing.JFrame;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = -5763319334266549575L;

	public CustomFrame() {
		initLayout();
	}

	private void initLayout() {
		add(new CustomPanel(this));
		setTitle("Life");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
	}
}
