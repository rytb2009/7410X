package com.raysworks.game.solver;

import java.util.Stack;

import com.raysworks.game.entity.PuzzleStateNode;

public class DFSSolver extends Solver {

	public DFSSolver(int puzzleSize) {
		super(puzzleSize);
	}

	@Override
	public void solve(PuzzleStateNode rootNode) {
		Stack<PuzzleStateNode> stack = new Stack<>();
		stack.push(rootNode);
		while(!stack.isEmpty()) {
			PuzzleStateNode node = stack.peek();
			node.setVisited(true);
			if (super.isSolved(node)) {
				System.out.println("DFS found solution!");
				return;
			}
			addChildren(node);
			PuzzleStateNode child = node.getUnvisitedChildNode();
			if(child != null) {
				child.setVisited(true);
				stack.push(child);
			} else {
				stack.pop();
			}
		}
		System.out.println("DFS can't found solution!");
	}

}
