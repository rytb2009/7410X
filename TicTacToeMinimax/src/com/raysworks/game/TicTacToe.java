package com.raysworks.game;

public class TicTacToe {

    public static void main(String[] args) {	
    	Player player = Player.X;
    	GameStateNode node = new GameStateNode();
    	Player[][] board = new Player[3][3];
		node.setBoard(board);
		node.setPlayer(player);		
		while (hasCellEmpty(board)) {
			Move move = MiniMaxSolver.minimax(node);
			System.out.println(move.getRow() + "" + move.getCol());			
			board[move.getRow()][move.getCol()] = player;
			player = player.opponent();
			node.setPlayer(player);
		}
		System.out.println("Expanded Nodes: " + MiniMaxSolver.nodeCounter);
	}
    
	private static boolean hasCellEmpty(Player[][] board) {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				if (board[row][col] == null) {
					return true;
				}
			}
		}
		return false;
	}
}