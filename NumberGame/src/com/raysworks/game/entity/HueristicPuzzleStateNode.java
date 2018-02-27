package com.raysworks.game.entity;

public class HueristicPuzzleStateNode extends PuzzleStateNode implements Comparable<HueristicPuzzleStateNode> {
	private int fromCost;
	private int toEstimateCost;
	private int fitness;
	
	public HueristicPuzzleStateNode() {
		
	}
	
	public HueristicPuzzleStateNode(PuzzleStateNode puzzleStateNode) {
		this.setBlankGridIndex(puzzleStateNode.getBlankGridIndex());
		this.setChildren(puzzleStateNode.getChildren());
		this.setDirection(puzzleStateNode.getDirection());
		this.setParent(puzzleStateNode.getParent());
		this.setPuzzleList(puzzleStateNode.getPuzzleList());
		this.setVisited(puzzleStateNode.isVisited());
	}
	
	public int getFromCost() {
		return fromCost;
	}
	public void setFromCost(int fromCost) {
		this.fromCost = fromCost;
	}
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	@Override
	public int compareTo(HueristicPuzzleStateNode o) {
		return Integer.compare(this.fitness, o.fitness);
	}
	@Override
	public String toString() {
		return "HueristicPuzzleStateNode [fromCost=" + fromCost + ", toEstimateCost=" + getToEstimateCost() + ", fitness=" + fitness + "]";
	}

	public int getToEstimateCost() {
		return toEstimateCost;
	}

	public void setToEstimateCost(int toEstimateCost) {
		this.toEstimateCost = toEstimateCost;
	}
}
