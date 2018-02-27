package com.raysworks.game.solver;

import com.raysworks.game.entity.PuzzleStateNode;

public class IDDFSSolver extends Solver {
	
	private boolean isSolved;

	public IDDFSSolver(int puzzleSize) {
		super(puzzleSize);
	}

	@Override
	public void solve(PuzzleStateNode rootNode) {
		int maxDepth =1;
		while (!isSolved) {
			rootNode.getChildren().clear();
			super.traversalledStateSet.clear();
			depthFirstSearch(rootNode, maxDepth);
			maxDepth++;
		}
		if (!isSolved) {
			System.out.println("IDDFS can't found solution!");			
		}
	}
	
	private void depthFirstSearch(PuzzleStateNode node, int maxDepth) {
		node.setVisited(true);
		super.tracker.addNodesIterateCount();
		if (super.isSolved(node)) {
			retriveNodesPath(node);
			System.out.println("IDDFS found solution !" + super.tracker);
			isSolved = true;
			return;
		}
	    if (maxDepth <= 0) {
	        return;
	    }	    
		addChildren(node);
		for (PuzzleStateNode childNode: node.getChildren()) {
			if (!childNode.isVisited()) {
	    		depthFirstSearch(childNode, maxDepth - 1);	    		
	    	}
		}
	}
}
