package com.techlab.model;

public class Cell {
	private Mark mark;
	
	public Cell() {
		mark = Mark.EMPTY;
	}
	
	public Mark getMark() {
		return this.mark;
	}
	
	public void setMark(Mark mark1) throws CellIsAlreadyMarked {
		if(this.getMark().equals(Mark.EMPTY)) {
			this.mark = mark1;
		}
		else {
			throw new CellIsAlreadyMarked("\nCell is Already Marked");
		}
	}
}
