import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1102244149546943132L;
	private int DELAYRR;
	private int DELAY = 200;
	Timer timer;
	Timer paintTimer;
	private Color backgroundColor = new Color(0x101820);
	private Color cellColor = new Color(0xFEE715);
	private int cellSize = 30;
	private SlotMatrix all;
	private boolean looping;
	private JFrame frame;

	public CustomPanel(CustomFrame customFrame) {
		frame = customFrame;
		initVars();
		initLayout();
	}

	private void initVars() {
		int screenWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getWidth();
		int screenHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getHeight();
		DELAYRR = (int) Math.ceil(1000.0 / GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDisplayMode().getRefreshRate());
		all = new SlotMatrix(((int) screenHeight) / cellSize, ((int) screenWidth) / cellSize);
		makeGlider();
		timer = new Timer(DELAY, new Loop(this));
		paintTimer = new Timer(DELAYRR, new PaintLoop(this));
		paintTimer.start();
		looping = false;
	}

	private void clear() {
		all.clear();
	}

	private void paintMatrix(Graphics g) {
		g.setColor(cellColor);
		for (int r = 0; r < all.getRows(); r++) {
			for (int c = 0; c < all.getCols(); c++) {
				if (all.get(r, c).isAlive()) {
					g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
				} else {
					g.drawRect(c * cellSize, r * cellSize, cellSize, cellSize);
				}

			}
		}
	}

	private void initLayout() {
		addMouseListener(new MouseActions(this));
		addKeyListener(new KeyActions(this));
		setFocusable(true);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(backgroundColor);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintMatrix(g);
	}

	public void update() {
		all.updateGen();
	}

	@Override
	public void repaint() {
		super.repaint();
		Toolkit.getDefaultToolkit().sync();
	}

	private void start() {
		looping = true;
		timer.start();

	}

	private void stop() {
		looping = false;
		timer.stop();

	}

	public void makeGlider() {
		try {
			all.get(all.getRows() / 2, all.getCols() / 2 - 1).setAlive(true);
			all.get(all.getRows() / 2 + 1, all.getCols() / 2).setAlive(true);
			all.get(all.getRows() / 2 + 1, all.getCols() / 2 + 1).setAlive(true);
			all.get(all.getRows() / 2, all.getCols() / 2 + 1).setAlive(true);
			all.get(all.getRows() / 2 - 1, all.getCols() / 2 + 1).setAlive(true);
		} catch (Exception e) {

		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (looping) {
				stop();
			} else {
				start();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.dispose();
			System.exit(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			clear();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		Point mouse = e.getPoint();
		Slot s = all.get(((int) mouse.getY()) / cellSize, ((int) mouse.getX()) / cellSize);
		if (s != null)
			s.setAlive(!s.isAlive());
	}

}
