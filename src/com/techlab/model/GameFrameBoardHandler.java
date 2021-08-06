package com.techlab.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.techlab.presentation.GameMainFrame;

public class GameFrameBoardHandler implements ActionListener {
	private Board board;
	private Game game;
	private GameMainFrame gameMainFrame;

	public GameFrameBoardHandler(GameMainFrame frame, Game game) {
		this.game = game;
		this.gameMainFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int playerCellLoc = Integer.parseInt(e.getActionCommand());

		if (game.getCurrentPlayer().getpMark().equals(Mark.X)) {
			this.gameMainFrame.setButtons(playerCellLoc, "X");
		} else {
			this.gameMainFrame.setButtons(playerCellLoc, "O");
		}

		try {
			game.play(playerCellLoc);
		} catch (CellIsAlreadyMarked e1) {
			e1.printStackTrace();
		}

		if (game.getGameStatus().equals(GameState.DRAW)) {
			this.gameMainFrame.setResult("Draw", false);
			return;
		} else if (game.getGameStatus().equals(GameState.FINISHED)) {
			String name = game.getNextPlayer().getpName();
			this.gameMainFrame.setResult(name, true);
			return;
		}

		this.gameMainFrame.setTitleName(game.getCurrentPlayer().getpName());
	}
}
