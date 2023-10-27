import java.util.List;

public class Slot {
	private boolean alive;
	private boolean aliveNextGen;
	private SlotMatrix all;
	private int row;
	private int col;

	public Slot(boolean alive, SlotMatrix all, int row, int col) {
		this.alive = alive;
		this.aliveNextGen = alive;
		this.all = all;
		this.row = row;
		this.col = col;
	}

	public void updateGen() {
		List<Slot> neighbors = all.getNeighbors(this);
		int count = 0;
		for (Slot slot : neighbors) {
			if (slot.isAlive()) {
				count++;
			}
		}
		if (isAlive()) {
			if (count < 2 || count > 3) {
				setAliveNextGen(false);
			}else {
				setAliveNextGen(true);
			}
		}else {
			if(count == 3) {
				setAliveNextGen(true);
			}else {
				setAliveNextGen(false);
			}
		}

	}
	public void finallyUpdateGen() {
		alive = aliveNextGen;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setAliveNextGen(boolean aliveNextGen) {
		this.aliveNextGen = aliveNextGen;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;
	}

}
