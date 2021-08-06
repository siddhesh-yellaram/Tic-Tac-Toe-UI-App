package com.techlab.model;

public class ResultAnalyser {
	private Board board;
	private int size;

	public ResultAnalyser(Board board) {
		this.board = board;
		size = board.getSize();
	}

	private GameState checkPlayerRow() {
		int playerMarkO;
		int row = 0;

		while (row < size) {
			playerMarkO = 0;

			for (int i = 0; i < size; i++) {
				if (board.getCells().get(size * row + i).getMark().equals(Mark.O)) {
					playerMarkO++;
				} else if (board.getCells().get(size * row + i).getMark().equals(Mark.X)) {
					playerMarkO--;
				}
			}

			row++;
			
			if (Math.abs(playerMarkO) == size) {
				return GameState.FINISHED;
			}
		}

		return GameState.RUNNING;

	}

	private GameState checkPlayerColumn() {
		int playerMarkO;
		int column = 0;

		while (column < size) {
			playerMarkO = 0;

			for (int i = 0; i < size; i++) {
				if (board.getCells().get(i * size + column).getMark().equals(Mark.O)) {
					playerMarkO++;
				} else if (board.getCells().get(i * size + column).getMark().equals(Mark.X)) {
					playerMarkO--;
				}
			}
			
			column++;
			
			if (Math.abs(playerMarkO) == size) {
				return GameState.FINISHED;
			}
		}
		
		return GameState.RUNNING;
	}

	private GameState checkPlayerLeftDiagonal() {
		int playerMarkO = 0;

		for (int i = 0; i < size; i++) {
			if (board.getCells().get((i * (size + 1))).getMark().equals(Mark.O)) {
				playerMarkO++;
			} else if (board.getCells().get((i * (size + 1))).getMark().equals(Mark.X)) {
				playerMarkO--;
			}
		}

		if (Math.abs(playerMarkO) == size) {
			return GameState.FINISHED;
		} else {
			return GameState.RUNNING;
		}

	}

	private GameState checkPlayerRightDiagonal() {
		int playerMarkO = 0;

		for (int i = 0; i < size; i++) {
			if (board.getCells().get(((i + 1) * (size - 1))).getMark().equals(Mark.O)) {
				playerMarkO++;
			} else if (board.getCells().get(((i + 1) * (size - 1))).getMark().equals(Mark.X)) {
				playerMarkO--;
			}
		}

		if (Math.abs(playerMarkO) == size) {
			return GameState.FINISHED;
		} else {
			return GameState.RUNNING;
		}
	}

	private GameState checkGameIsDraw() {

		if (board.isBoardFullyMarked()) {
			return GameState.DRAW;
		} else {
			return GameState.RUNNING;
		}

	}

	public GameState analysePlayerResult() {
		if (this.checkPlayerRow().equals(GameState.FINISHED)) {
			return this.checkPlayerRow();
		} else if (this.checkPlayerColumn().equals(GameState.FINISHED)) {
			return this.checkPlayerColumn();
		} else if (this.checkPlayerLeftDiagonal().equals(GameState.FINISHED)) {
			return this.checkPlayerLeftDiagonal();
		} else if (this.checkPlayerRightDiagonal().equals(GameState.FINISHED)) {
			return this.checkPlayerRightDiagonal();
		} else if (this.checkGameIsDraw().equals(GameState.DRAW)) {
			return this.checkGameIsDraw();
		} else {
			return GameState.RUNNING;
		}
	}
}
