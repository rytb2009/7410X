package com.raysworks.game;

public class Move {
	private int row;
	private int col;
	private int score;
	
	public Move(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public Move(int row, int col, int score) {
		super();
		this.row = row;
		this.col = col;
		this.setScore(score);
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Move [row=" + row + ", col=" + col + ", score=" + getScore() + "]";
	}
	
}
