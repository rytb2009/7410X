package com.raysworks.game;

import java.util.ArrayList;
import java.util.List;

public class MiniMaxSolver {
	
	public static int nodeCounter = 0;

	public static Move minimax(GameStateNode thisNode) {
		nodeCounter++;
		List<Move> nextMoves = generateMoves(thisNode);
		Player player = thisNode.getPlayer();
		Player[][] board = thisNode.getBoard();
		int bestScore = (player == Player.X) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore;
		int bestRow = -1;
	    int bestCol = -1;
		GameStateNode nextNode = new GameStateNode();
		nextNode.setBoard(board);
		nextNode.setPlayer(player.opponent());
		if (nextMoves.isEmpty()) {
			bestScore = player.getScore(board);
//	        System.out.println("score: " + bestScore);
		} else {
			for (Move move : nextMoves) {
				board[move.getRow()][move.getCol()] = player;
				nextNode.setMove(move);
				if (player == Player.X) { 
					Move nextMove = minimax(nextNode);
					currentScore = nextMove.getScore();
					if (currentScore > bestScore) {
						bestScore = currentScore;
						bestRow = move.getRow();
		                bestCol = move.getCol();
					}
				} else { 
					Move nextMove = minimax(nextNode);
					currentScore = nextMove.getScore();
					if (currentScore < bestScore) {
						bestScore = currentScore;
						bestRow = move.getRow();
		                bestCol = move.getCol();
					}
				}
				board[move.getRow()][move.getCol()] = null;
			}
		}
		nextNode.setMove(new Move(bestRow, bestCol, bestScore));
		return nextNode.getMove();
	}

	public static List<Move> generateMoves(GameStateNode thisNode) {
		List<Move> nextMoves = new ArrayList<>(); 
		Player[][] board = thisNode.getBoard();
		Move thisMove = thisNode.getMove();
		if (Player.X.isWin(board, thisMove) || Player.O.isWin(board, thisMove)) {
			return nextMoves; 
		}	

		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				if (board[row][col] == null) {
					nextMoves.add(new Move(row, col));
				}
			}
		}
		return nextMoves;
	}
}
