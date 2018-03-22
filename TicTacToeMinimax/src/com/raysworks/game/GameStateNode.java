package com.raysworks.game;

public class GameStateNode {
	private Player[][] board;
	private Move move;
	private Player player;
	
	public Move getMove() {
		return move;
	}
	public void setMove(Move move) {
		this.move = move;
	}
	public Player[][] getBoard() {
		return board;
	}
	public void setBoard(Player[][] board) {
		this.board = board;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	@Override
	public String toString() {
		String boardPrint = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == null) {
					boardPrint += (i + "" + j) + " ";					
				} else {
					boardPrint += board[i][j] + " ";
				}
			}
		}
		return "GameStateNode [board=" + boardPrint + ", player= " + player + ", move=" + move + "]";
	}
}
