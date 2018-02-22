package com.raysworks.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.raysworks.game.entity.BlankGridMoveDirection;
import com.raysworks.game.entity.PuzzleStateNode;

public class PuzzleGenerator {

	public static PuzzleStateNode generatePuzzle(int puzzleSize, int randomMoves) {
		int totalNumbers = puzzleSize * puzzleSize;
		List<Integer> sortedList = IntStream.rangeClosed(1, totalNumbers).boxed().collect(Collectors.toList());
		PuzzleStateNode rootNode = new PuzzleStateNode();
		rootNode.setPuzzleList(sortedList);
		rootNode.setBlankGridIndex(totalNumbers - 1);
		int moveCount = 0;
		PuzzleStateNode puzzleNode = rootNode;
		while (moveCount < randomMoves) {
			puzzleNode = randomMove(puzzleNode, puzzleSize);
			if (!sortedList.equals(puzzleNode.getPuzzleList())) {
				moveCount++;				
			}	
		}
		return puzzleNode; 
	}	
	
	private static PuzzleStateNode randomMove(PuzzleStateNode puzzleNode, int puzzleSize) {
		List<BlankGridMoveDirection> availableDirections = DirectionUtils.getAvailableDirections(puzzleSize, puzzleNode.getBlankGridIndex());
		int randomDirection = (int) (Math.random() * availableDirections.size());
		return DirectionUtils.getNextNode(puzzleNode, availableDirections.get(randomDirection), puzzleSize);
	}
}
