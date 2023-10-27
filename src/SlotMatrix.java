import java.util.ArrayList;
import java.util.List;

public class SlotMatrix {
	private Slot[][] data;

	public SlotMatrix(int rows, int cols) {
		data = new Slot[rows][cols];
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				data[r][c] = new Slot(false, this, r, c);
			}
		}
	}

	public Slot get(int rows, int cols) {
		try {
			return data[rows][cols];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public List<Slot> getNeighbors(Slot a) {
		return getNeighbors(a.getRow(), a.getCol());
	}

	public List<Slot> getNeighbors(int r, int c) {
		List<Slot> neighbors = new ArrayList<Slot>();
		try {
			neighbors.add(data[r - 1][c - 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r - 1][c]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r - 1][c + 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r][c - 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r][c + 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r + 1][c - 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r + 1][c]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			neighbors.add(data[r + 1][c + 1]);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		return neighbors;
	}

	public int getRows() {
		return data.length;
	}

	public int getCols() {
		return data[0].length;
	}

	public Slot[][] getArray() {
		Slot[][] arr = new Slot[data.length][];
		for (int r = 0; r < data.length; r++) {
			arr[r] = new Slot[data[r].length];
			for (int c = 0; c < data[r].length; c++) {
				arr[r][c] = data[r][c];
			}
		}
		return arr;
	}

	public void updateGen() {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				data[r][c].updateGen();
			}
		}
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				data[r][c].finallyUpdateGen();
			}
		}
	}

	public void clear() {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				data[r][c].setAlive(false);
			}
		}
	}
}