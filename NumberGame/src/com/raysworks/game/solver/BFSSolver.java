package com.raysworks.game.solver;

import java.util.LinkedList;
import java.util.Queue;

import com.raysworks.game.entity.PuzzleStateNode;

public class BFSSolver extends Solver {

	public BFSSolver(int puzzleSize) {
		super(puzzleSize);
	}

	@Override
	public void solve(PuzzleStateNode rootNode) {
		Queue<PuzzleStateNode> queue = new LinkedList<>();
		queue.add(rootNode);
		rootNode.setVisited(true);
		while(!queue.isEmpty()) {
			PuzzleStateNode node = queue.remove();
			if (super.isSolved(node)) {
				retriveNodesPath(node);
				System.out.println("BFS found solution!\n" + super.tracker);
				return;
			}
			addChildren(node);
//			System.out.println(node);
			PuzzleStateNode child= null;
			while((child = node.getUnvisitedChildNode()) != null) {
				super.tracker.addNodesIterateCount();
				child.setVisited(true);
				queue.add(child);
			}
		}
		System.out.println("BFS can't found solution!");
	}

}
