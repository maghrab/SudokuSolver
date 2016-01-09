package main;

import java.util.Hashtable;
import java.util.Queue;
import java.util.Stack;

public class SudokuSolver {
	public static void main(String [] args){
		Sudoku test = new Sudoku("1 6 7 0 0 0 0 0 0 0 5 0 6 0 0 0 4 7 0 0 0 3 0 0 0 0"
				+ " 9 6 4 1 0 5 7 0 0 0 8 0 0 0 6 0 0 0 5"
				+ " 0 0 0 9 8 0 7 1 6 7 0 0 0 0 8 0 0 0 4"
				+ " 9 0 0 0 6 0 5 0 0 0 0 0 0 0 6 7 1");
		test.printGrid();
		System.out.print("\n");
		Sudoku test2 = solveSudoku(test);
		test2.printGrid();
	}
	
	
	public static Sudoku solveSudoku(Sudoku initial){
		
		Stack<Sudoku> nextStates;
		
		//Seen states of the Sudoku
		Hashtable<String,Sudoku> seen = new Hashtable<String,Sudoku>();
		
		//Current states for solution
		Stack<Sudoku> solutionPath = new Stack<Sudoku>();
		
		seen.put(initial.toString(), initial);
		solutionPath.push(initial);
		
		while( !solutionPath.isEmpty() ){
			
			// get the next possible solution
			Sudoku temp = solutionPath.pop();
			//temp.printGrid();
			//System.out.println("");
			
			if (temp.isSolution()){
				return temp; // solution is found
			}
			
			nextStates = temp.findNextSudoku();
			
			while( !nextStates.isEmpty()){
				
				Sudoku nextSod = nextStates.pop();
				
				if (nextSod.isSolution()){
					return nextSod; // solution is found
				}
				if (!seen.containsKey(nextSod.toString() ) ){
					solutionPath.push(nextSod);
					seen.put(nextSod.toString(), nextSod);
				}
			}
			
			
			
		}
		
		return null; // no solutions found
	}
}
