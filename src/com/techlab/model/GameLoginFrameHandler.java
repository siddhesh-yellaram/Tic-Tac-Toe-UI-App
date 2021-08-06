package com.techlab.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.techlab.presentation.GameLoginFrame;
import com.techlab.presentation.GameMainFrame;

public class GameLoginFrameHandler implements ActionListener {
	GameLoginFrame loginFrame;

	public GameLoginFrameHandler(GameLoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Board board = new Board(3);
		Game game = new Game(board);

		game.addPlayers(new Player(this.loginFrame.getPlayerName1(), Mark.X));
		game.addPlayers(new Player(this.loginFrame.getPlayerName2(), Mark.O));

		new GameMainFrame(game);

		this.loginFrame.dispose();
	}
}
