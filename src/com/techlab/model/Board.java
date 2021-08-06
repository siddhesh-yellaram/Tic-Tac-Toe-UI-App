package com.techlab.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Cell> cells = new ArrayList<Cell>();
	private int size;

	public Board(int size) {
		this.size = size;
		for (int i = 0; i < this.size * this.size; i++)
			cells.add(new Cell());
	}

	public void setMarkOnCell(int index, Mark mark) throws CellIsAlreadyMarked {
		cells.get(index).setMark(mark);
	}

	public boolean isBoardFullyMarked() {
		for (Cell cell : this.cells) {
			cell = (Cell) cell;
			if (cell.getMark().equals(Mark.EMPTY))
				return false;
		}
		return true;
	}

	public List<Cell> getCells() {
		return cells;
	}

	public int getSize() {
		return size;
	}
}
