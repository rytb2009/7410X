package com.raysworks.game;

public enum Player {
	X, O;

	public Player opponent() {
		return this.equals(X) ? O : X;
	}

	public int getScore(Player[][] board) {
		int score = 0;
		// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
		score += evaluateLine(board, 0, 0, 0, 1, 0, 2); // row 0
		score += evaluateLine(board, 1, 0, 1, 1, 1, 2); // row 1
		score += evaluateLine(board, 2, 0, 2, 1, 2, 2); // row 2
		score += evaluateLine(board, 0, 0, 1, 0, 2, 0); // col 0
		score += evaluateLine(board, 0, 1, 1, 1, 2, 1); // col 1
		score += evaluateLine(board, 0, 2, 1, 2, 2, 2); // col 2
		score += evaluateLine(board, 0, 0, 1, 1, 2, 2); // diagonal
		score += evaluateLine(board, 0, 2, 1, 1, 2, 0); // anti diagonal
		return score;
	}

	private int evaluateLine(Player[][] board, int row1, int col1, int row2, int col2, int row3, int col3) {
		int score = 0;
		Player one = board[row1][col1];
		Player two = board[row2][col2];
		Player three = board[row3][col3];
		Player oppoent = this.opponent();
		if (this.equals(one)) {
			score = 1;
		} else if (oppoent.equals(one)) {
			score = -1;
		}

		if (this.equals(two)) {
			if (score == 1) { 
				score = 10;
			} else if (score == -1) { 
				return 0;
			} else { 
				score = 1;
			}
		} else if (oppoent.equals(two)) {
			if (score == -1) { 
				score = -10;
			} else if (score == 1) { 
				return 0;
			} else { 
				score = -1;
			}
		}

		if (this.equals(three)) {
			if (score > 0) { 
				score *= 10;
			} else if (score < 0) {
				return 0;
			} else { 
				score = 1;
			}
		} else if (oppoent.equals(three)) {
			if (score < 0) { 
				score *= 10;
			} else if (score > 1) { 
				return 0;
			} else { 
				score = -1;
			}
		}
		return score;

	}

	public boolean isWin(Player[][] board, Move move) {
		if (move == null) {
			return false;
		}
		int moveRow = move.getRow();
		int moveCol = move.getCol();
		int verticalCount = 0;
		int horizontalCount = 0;
		int diagonalCount = 0;
		int antiDiagonalCount = 0;
		for (int i = 0; i < 3; i++) {
			if (this.equals(board[moveRow][i])) {
				verticalCount++;
			}
			if (this.equals(board[i][moveCol])) {
				horizontalCount++;
			}
			if (this.equals(board[i][i])) {
				diagonalCount++;
			}
			if (this.equals(board[i][2 - i])) {
				antiDiagonalCount++;
			}
		}
		return verticalCount == 3 || horizontalCount == 3 || diagonalCount == 3 || antiDiagonalCount == 3;
	}
}
