package com.raysworks.game.entity;

import java.util.LinkedList;
import java.util.List;

public class PuzzleStateNode {
	private List<PuzzleStateNode> children = new LinkedList<>();
	private PuzzleStateNode parent;
	private BlankGridMoveDirection direction;
	private List<Integer> puzzleList;
	private int blankGridIndex;  
	private boolean visited;
	
	public BlankGridMoveDirection getDirection() {
		return direction;
	}
	public void setDirection(BlankGridMoveDirection direction) {
		this.direction = direction;
	}
	public List<Integer> getPuzzleList() {
		return puzzleList;
	}
	public void setPuzzleList(List<Integer> puzzleList) {
		this.puzzleList = puzzleList;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public int getBlankGridIndex() {
		return blankGridIndex;
	}
	public void setBlankGridIndex(int blankGridIndex) {
		this.blankGridIndex = blankGridIndex;
	}

	public List<PuzzleStateNode> getChildren() {
		return children;
	}

	public void setChildren(List<PuzzleStateNode> children) {
		this.children = children;
	}	
	
	public void addChild(PuzzleStateNode childNode) {
		getChildren().add(childNode);
	}

	public PuzzleStateNode getUnvisitedChildNode() {
		return children.stream().filter(n -> !n.visited).findFirst().orElse(null);
	}
	public PuzzleStateNode getParent() {
		return parent;
	}
	public void setParent(PuzzleStateNode parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "PuzzleStateNode [children=" + children.size() + ", direction=" + direction + ", puzzleList=" + puzzleList
				+ ", blankGridIndex=" + blankGridIndex + ", visited=" + visited + "]";
	}
	
	
}
