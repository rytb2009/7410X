package com.raysworks.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.raysworks.game.entity.BlankGridMoveDirection;
import com.raysworks.game.entity.PuzzleStateNode;

public class DirectionUtils {
	
	public static List<BlankGridMoveDirection> getAvailableDirections(int puzzleSize, int blankGridIndex) {
		List<BlankGridMoveDirection> validDirections = new ArrayList<>();
		outer: 
		for (BlankGridMoveDirection direction: BlankGridMoveDirection.values()) {
				if (BlankGridMoveDirection.UP.equals(direction)) {
					if (blankGridIndex >= puzzleSize) {
						 validDirections.add(direction);
					 }
				}
				if (BlankGridMoveDirection.DOWN.equals(direction)) {
					 if (blankGridIndex < puzzleSize * (puzzleSize - 1)) {
						 validDirections.add(direction);
					 }
				}
				if (BlankGridMoveDirection.LEFT.equals(direction)) {
					  for (int i = 0; i < puzzleSize; i++) {
						 if (blankGridIndex == puzzleSize * i) {
							 continue outer;
						 }
					 }
					 validDirections.add(direction);
				}
				if (BlankGridMoveDirection.RIGHT.equals(direction)) {
					for (int i = 1; i <= puzzleSize; i++) {
						 if (blankGridIndex + 1 == puzzleSize * i) {
							 continue outer;
						 }
					 }
					validDirections.add(direction);
				}
			}
		return validDirections;
	}
	
	public static PuzzleStateNode getNextNode(PuzzleStateNode puzzleStateNode, BlankGridMoveDirection direction, int puzzleSize) {
		int blankGridIndex = puzzleStateNode.getBlankGridIndex();
		int moveToIndex = -1;
		switch (direction) {
			case UP:
				 moveToIndex = blankGridIndex - puzzleSize; 
				 break;
			case DOWN:
				 moveToIndex = blankGridIndex + puzzleSize;
				 break;
			case LEFT:
				 moveToIndex = blankGridIndex - 1;
				 break;
			case RIGHT:
				 moveToIndex = blankGridIndex + 1;
				 break;
			default:
				 return null;
		}
		List<Integer> newPuzzleList = new LinkedList<>(puzzleStateNode.getPuzzleList());
		Collections.swap(newPuzzleList, blankGridIndex, moveToIndex);
		PuzzleStateNode nextNode = new PuzzleStateNode();
		nextNode.setBlankGridIndex(moveToIndex);
		nextNode.setPuzzleList(newPuzzleList);
		return nextNode;
	}
	
	public static int getManhattanceDistance(int puzzleSize, int currentPosition, int targetPosition) {
		if (targetPosition == currentPosition) {
			return 0;
		}
		Point targetPoint = new Point();
		Point currentPoint = new Point();
		for (int i = 0; i < puzzleSize; i++) {
			for (int j = 0; j < puzzleSize; j++) {
				if (targetPosition == (i * puzzleSize + j)) {
					targetPoint.x = i;
					targetPoint.y = j;
				}
				if (currentPosition == (i * puzzleSize + j)) {
					currentPoint.x = i;
					currentPoint.y = j;
				}
			}
		}
		return Math.abs(currentPoint.x-targetPoint.x) + Math.abs(currentPoint.y-targetPoint.y);
	}

}
