package main;

public class SudokuSolver {
	public static void main(String [] args){
		Sudoku test = new Sudoku("1 6 7 0 0 0 0 0 0 0 5 0 6 0 0 0 4 7 0 0 0 3 0 0 0 0"
				+ " 9 6 4 1 0 5 7 0 0 0 8 0 0 0 6 0 0 0 5"
				+ " 0 0 0 9 8 0 7 1 6 7 0 0 0 0 8 0 0 0 4"
				+ " 9 0 0 0 6 0 5 0 0 0 0 0 0 0 6 7 1");
		test.printGrid();
	}
}
