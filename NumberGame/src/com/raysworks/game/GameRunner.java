package com.raysworks.game;

import java.util.List;

import com.raysworks.game.entity.PuzzleStateNode;
import com.raysworks.game.solver.AStarSolver;
import com.raysworks.game.solver.BFSSolver;
import com.raysworks.game.solver.Solver;

public class GameRunner {

	public static void main(String[] args) {
		int puzzleSize = 4;
		int randomMoves = 50;
		// BFS:
		PuzzleStateNode rootNode = PuzzleGenerator.generatePuzzle(puzzleSize, randomMoves);
		System.out.println("BFS - " + puzzleSize + " * " + puzzleSize + " Puzzle with " + randomMoves + " random moves: ");
		printPuzzle(rootNode.getPuzzleList());
		BFSSolver bfsSolver = new BFSSolver(puzzleSize);
		runSolver(bfsSolver, rootNode);
		System.out.println("\n");
		
		System.out.println("A Star - " + puzzleSize + " * " + puzzleSize + " Puzzle with " + randomMoves + " random moves: ");
		printPuzzle(rootNode.getPuzzleList());
		AStarSolver aPlusSolver = new AStarSolver(puzzleSize);
		runSolver(aPlusSolver, rootNode);
		System.out.println("\n");
////		// IDDFS:
//		
//		System.out.println("IDDFS - " + puzzleSize + " * " + puzzleSize + " Puzzle with " + randomMoves + " random moves: ");
//		printPuzzle(rootNode.getPuzzleList());
//		IDDFSSolver idDfsSolver = new IDDFSSolver(puzzleSize);
//		runSolver(idDfsSolver, rootNode);
//		System.out.println("\n");
		// DFS:
//		puzzleSize = 3;
//		randomMoves = 5;
//		rootNode = PuzzleGenerator.generatePuzzle(puzzleSize, randomMoves);
//		DFSSolver dfsSolver = new DFSSolver(puzzleSize);
//		System.out.println("DFS - " + puzzleSize + " * " + puzzleSize + " Puzzle with "  + randomMoves + " random moves: ");
//		printPuzzle(rootNode.getPuzzleList());
//		runSolver(dfsSolver, rootNode);
	}
	
	private static void printPuzzle(List<Integer> puzzleList) {
		for(int i: puzzleList) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	private static void runSolver(Solver solver, PuzzleStateNode rootNode) {
		solver.solve(rootNode);
		List<PuzzleStateNode> resultNodes = solver.getResultNodesList();
		System.out.print("Total Moves: " + resultNodes.size() + "  \t");
		for (int i = resultNodes.size() - 1; i >= 0 ; i--) {
			System.out.print(resultNodes.get(i).getDirection().getCode() + " ");
		}
	}
}
