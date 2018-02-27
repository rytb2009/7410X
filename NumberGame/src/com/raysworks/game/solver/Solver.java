package com.raysworks.game.solver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.raysworks.game.DirectionUtils;
import com.raysworks.game.entity.BlankGridMoveDirection;
import com.raysworks.game.entity.PuzzleStateNode;
import com.raysworks.game.entity.TreeNodeIterateTracker;


public abstract class Solver {
	
	protected int puzzleSize;
	protected Set<List<Integer>> traversalledStateSet = new HashSet<>();
	protected TreeNodeIterateTracker tracker = new TreeNodeIterateTracker();
	private List<PuzzleStateNode> resultNodesList = new LinkedList<>();
	
	public Solver(int puzzleSize) {
		this.puzzleSize = puzzleSize;
	}
	
	public abstract void solve(PuzzleStateNode rootNode);
	
	public List<PuzzleStateNode> getResultNodesList() {
		return this.resultNodesList;
	}
	
	protected boolean isSolved(PuzzleStateNode goalNode) {
		List<Integer> puzzleList = goalNode.getPuzzleList();
		if (puzzleList != null && puzzleList.stream().sorted().collect(Collectors.toList()).equals(puzzleList)) {			
			return true;
		}
		return false;
	}
	
	protected void retriveNodesPath(PuzzleStateNode goalNode) {
		tracker.addTreeDepth();
		resultNodesList.add(goalNode);
		PuzzleStateNode parent = goalNode.getParent();
		if (parent != null && parent.getDirection() != null) {
			retriveNodesPath(parent);
		}
	}	

	protected void addChildren(PuzzleStateNode node) {
		List<BlankGridMoveDirection> availableDirections = DirectionUtils.getAvailableDirections(puzzleSize, node.getBlankGridIndex());
		for (BlankGridMoveDirection direction: availableDirections) {
			PuzzleStateNode childNode = DirectionUtils.getNextNode(node, direction, puzzleSize);
			childNode.setDirection(direction);
			if (traversalledStateSet.contains(childNode.getPuzzleList())) {
				continue;
			} else {
				traversalledStateSet.add(childNode.getPuzzleList());
				childNode.setParent(node);
				node.addChild(childNode);
			}
		}
	}
}
