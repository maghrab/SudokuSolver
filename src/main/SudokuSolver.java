package main;

import java.util.Hashtable;
import java.util.Queue;
import java.util.Stack;

public class SudokuSolver {
	public static void main(String[] args) {

	}

	/**
	 * Solve the Sudoku game
	 * 
	 * @param initial
	 *            : the initial state of the game
	 * @return The solution to the Sudoku in a form of a state
	 */
	public static Sudoku solveSudoku(Sudoku initial) {

		if (!initial.isValid())
			return null;

		Stack<Sudoku> nextStates;

		// Seen states of the Sudoku
		Hashtable<String, Sudoku> seen = new Hashtable<String, Sudoku>();

		// Current states for solution
		Stack<Sudoku> solutionPath = new Stack<Sudoku>();

		seen.put(initial.toString(), initial);
		solutionPath.push(initial);

		while (!solutionPath.isEmpty()) {

			// get the next possible solution
			Sudoku temp = solutionPath.pop();
			// temp.printGrid();
			// System.out.println("");

			nextStates = temp.findNextSudoku();

			while (!nextStates.isEmpty()) {

				Sudoku nextSod = nextStates.pop();

				if (nextSod.isSolution()) {
					return nextSod; // solution is found
				}
				if (!seen.containsKey(nextSod.toString())) {
					solutionPath.push(nextSod);
					seen.put(nextSod.toString(), nextSod);
				}
			}

		}

		return null; // no solutions found
	}
}
