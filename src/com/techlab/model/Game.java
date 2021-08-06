package com.techlab.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board;
	private List<Player> players;
	private boolean isPlayer1TurnStarted;
	private GameState gameStatus;


	public Game(Board board) {
		this.board = board;
		this.players = new ArrayList<Player>();
		this.isPlayer1TurnStarted = true;
		gameStatus = GameState.RUNNING;
	}
	
	public void addPlayers(Player player) {
		this.players.add(player);
	}

	public void play(int index) throws CellIsAlreadyMarked {
		
		Player currentPlayer = this.getCurrentPlayer();
		ResultAnalyser checkResult = new ResultAnalyser(board);
		board.setMarkOnCell(index, currentPlayer.getpMark());
		this.setGameStatus(checkResult.analysePlayerResult());
		this.setPlayer1Turn();
	}

	private void setGameStatus(GameState gameStatus) {
		this.gameStatus = gameStatus;
	}

	private void setPlayer1Turn() {
		if(this.isPlayer1TurnStarted) {
			this.isPlayer1TurnStarted = false;
		}
		else {
			this.isPlayer1TurnStarted = true;
		}
	}

	public Board getBoard() {
		return board;
	}
	
	public Player getCurrentPlayer() {
		if(this.isPlayer1TurnStarted) {
			return this.players.get(0);
		}
		else {
			return this.players.get(1);
		}
	}
	
	public GameState getGameStatus() {
		return gameStatus;
	}
	
	public Player getNextPlayer() {
		if(this.isPlayer1TurnStarted) {
			return this.players.get(1);
		}
		else {
			return this.players.get(0);
		}
	}

}
