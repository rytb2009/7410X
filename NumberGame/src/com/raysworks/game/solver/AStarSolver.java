package com.raysworks.game.solver;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.raysworks.game.DirectionUtils;
import com.raysworks.game.entity.HueristicPuzzleStateNode;
import com.raysworks.game.entity.PuzzleStateNode;

public class AStarSolver extends Solver {

	private HueristicPuzzleStateNode targetNode;
	
	public AStarSolver(int puzzleSize) {
		super(puzzleSize);
	}		

	@Override
	public void solve(PuzzleStateNode rootNode) {
		Queue<HueristicPuzzleStateNode> queue = new PriorityQueue<>();
		rootNode.setVisited(true);
		queue.add(new HueristicPuzzleStateNode(rootNode));
		while(!queue.isEmpty()) {
			HueristicPuzzleStateNode hueristicNode = queue.remove();			
			if (isBestSolutionFound(hueristicNode)) {
				return;					
			}
			addChildren(hueristicNode);
//			System.out.println(hueristicNode);
			PuzzleStateNode child= null;
			while((child = hueristicNode.getUnvisitedChildNode()) != null) {
				child.setVisited(true);
				super.tracker.addNodesIterateCount();
				HueristicPuzzleStateNode hueristicChildNode = new HueristicPuzzleStateNode(child);
				setFitness(hueristicChildNode, hueristicNode.getFitness());
				queue.add(hueristicChildNode);
			}
		}		
	}
	
	private boolean isBestSolutionFound(HueristicPuzzleStateNode node) {
		if (targetNode != null && targetNode.getFitness() < node.getFitness()) {
			retriveNodesPath(targetNode);
			System.out.println("A Star found the best solution! " + targetNode + "\n" + super.tracker);
			return true;
		}
		if (super.isSolved(node)) {
			targetNode = node;
		}
		return false;
	}
	
	private void setFitness(HueristicPuzzleStateNode node, int previousFromCost) {
		List<Integer> puzzleList = node.getPuzzleList();
		node.setFromCost(previousFromCost++);
		int toEstimateCost = 0;
		for (int i = 0; i < puzzleList.size(); i++) {
			int value = puzzleList.get(i);
			if (value != puzzleSize * puzzleSize) {
				toEstimateCost += DirectionUtils.getManhattanceDistance(puzzleSize, i, value - 1);				
			}
		}
		node.setToEstimateCost(toEstimateCost);
		node.setFitness(node.getFromCost() + node.getToEstimateCost());
	}
}
