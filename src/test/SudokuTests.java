package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Sudoku;
import main.SudokuSolver;

public class SudokuTests {

	@Test
	public void testOne() {
		
		Sudoku boardOne = new Sudoku("0 0 8 4 6 0 0 0 0"
				+ " 9 0 0 0 2 1 0 0 3"
				+ " 0 0 4 0 0 0 1 0 6"
				+ " 0 9 0 0 7 0 3 0 0"
				+ " 0 3 0 0 0 2 0 1 9"
				+ " 0 4 0 0 0 8 0 6 0"
				+ " 0 0 0 5 0 0 2 7 8"
				+ " 7 0 5 8 0 0 0 0 0"
				+ " 4 0 3 2 0 0 0 0 0");
		
		Sudoku solutionOne = SudokuSolver.solveSudoku(boardOne);
		
		String solutionOneText = "3 1 8 4 6 9 5 2 7"
				+ " 9 5 6 7 2 1 8 4 3"
				+ " 2 7 4 3 8 5 1 9 6"
				+ " 6 9 2 1 7 4 3 8 5"
				+ " 8 3 7 6 5 2 4 1 9"
				+ " 5 4 1 9 3 8 7 6 2"
				+ " 1 6 9 5 4 3 2 7 8"
				+ " 7 2 5 8 1 6 9 3 4"
				+ " 4 8 3 2 9 7 6 5 1 ";
		
		assertTrue(solutionOne.toString().equals(solutionOneText));
		
	}
	
	@Test
	public void testTwo(){
		Sudoku boardTwo = new Sudoku("5 7 0 0 0 0 0 0 3"
				+ " 2 0 0 0 0 9 1 0 5"
				+ " 0 3 0 5 0 1 0 2 0"
				+ " 3 0 9 0 0 0 0 5 0"
				+ " 0 0 0 6 0 0 3 0 4"
				+ " 0 8 2 0 3 0 6 0 0"
				+ " 0 0 0 0 0 8 0 4 1"
				+ " 1 5 7 0 9 0 0 0 0"
				+ " 0 0 0 0 0 6 0 3 0");
		
		Sudoku solutionTwo = SudokuSolver.solveSudoku(boardTwo);
		
		String solutionTwoText = "5 7 1 8 2 4 9 6 3"
				+ " 2 4 8 3 6 9 1 7 5"
				+ " 9 3 6 5 7 1 4 2 8"
				+ " 3 6 9 1 4 7 8 5 2"
				+ " 7 1 5 6 8 2 3 9 4"
				+ " 4 8 2 9 3 5 6 1 7"
				+ " 6 9 3 2 5 8 7 4 1"
				+ " 1 5 7 4 9 3 2 8 6"
				+ " 8 2 4 7 1 6 5 3 9 ";
		
		assertTrue(solutionTwo.toString().equals(solutionTwoText));
	}
	
	@Test
	public void testThree(){
		Sudoku boardThree = new Sudoku("0 7 0 0 0 0 0 0 8"
				+ " 0 0 5 0 0 6 0 0 4"
				+ " 0 0 3 0 7 0 5 0 0"
				+ " 3 9 0 0 0 4 0 0 0"
				+ " 0 0 0 0 9 3 6 7 1"
				+ " 7 0 0 2 6 0 3 0 0"
				+ " 0 0 0 0 0 7 2 8 0"
				+ " 8 6 0 9 0 0 0 1 0"
				+ " 1 0 0 6 0 0 0 5 0");
		
		Sudoku solutionThree = SudokuSolver.solveSudoku(boardThree);
		
		String solutionThreeText = "2 7 4 3 5 9 1 6 8"
				+ " 9 1 5 8 2 6 7 3 4"
				+ " 6 8 3 4 7 1 5 9 2"
				+ " 3 9 6 7 1 4 8 2 5"
				+ " 4 2 8 5 9 3 6 7 1"
				+ " 7 5 1 2 6 8 3 4 9"
				+ " 5 3 9 1 4 7 2 8 6"
				+ " 8 6 2 9 3 5 4 1 7"
				+ " 1 4 7 6 8 2 9 5 3 ";
		
		assertTrue(solutionThree.toString().equals(solutionThreeText));
	}
	
	@Test
	public void testFour(){
		
		Sudoku boardFour = new Sudoku("0 2 0 7 0 0 3 0 0"
				+ " 1 0 0 4 0 0 0 0 6"
				+ " 0 4 3 0 8 0 0 0 1"
				+ " 0 0 2 0 0 0 4 0 3"
				+ " 3 0 0 8 4 0 7 0 0"
				+ " 0 0 4 0 0 5 0 6 0"
				+ " 4 9 0 0 0 3 0 8 0"
				+ " 0 0 6 0 0 0 0 5 7"
				+ " 0 5 0 1 6 0 0 0 0");
		
		Sudoku solutionFour = SudokuSolver.solveSudoku(boardFour);
		
		String solutionFourText = "6 2 8 7 5 1 3 4 9"
				+ " 1 7 5 4 3 9 8 2 6"
				+ " 9 4 3 2 8 6 5 7 1"
				+ " 5 8 2 6 1 7 4 9 3"
				+ " 3 6 9 8 4 2 7 1 5"
				+ " 7 1 4 3 9 5 2 6 8"
				+ " 4 9 1 5 7 3 6 8 2"
				+ " 8 3 6 9 2 4 1 5 7"
				+ " 2 5 7 1 6 8 9 3 4 ";
		
		assertTrue(solutionFour.toString().equals(solutionFourText));
		
	}
	
	@Test
	public void testinValidSudoku(){
		Sudoku inValidSod = new Sudoku("1 2 0 7 0 0 3 0 0"
				+ " 1 0 0 4 0 0 0 0 6"
				+ " 0 4 3 0 8 0 0 0 1"
				+ " 0 0 2 0 0 0 4 0 3"
				+ " 3 0 0 8 4 0 7 0 0"
				+ " 0 0 4 0 0 5 0 6 0"
				+ " 4 9 0 0 0 3 0 8 0"
				+ " 0 0 6 0 0 0 0 5 7"
				+ " 0 5 0 1 6 0 0 0 0");
		
		Sudoku solutionInValid = SudokuSolver.solveSudoku(inValidSod);
		
		assertNull(solutionInValid);
	}
	
	@Test
	public void testinValidSudoku_2(){
		Sudoku inValidSod = new Sudoku("0 2 0 7 0 0 3 0 0"
				+ " 1 0 0 4 0 0 0 0 6"
				+ " 0 4 3 0 8 0 0 0 1"
				+ " 0 0 2 0 0 0 4 0 3"
				+ " 3 0 0 8 4 0 7 0 0"
				+ " 0 0 4 0 0 5 0 6 0"
				+ " 4 9 0 15 0 3 0 8 0"
				+ " 0 0 6 0 0 0 0 5 7"
				+ " 0 5 0 1 6 0 0 0 0");
		
		Sudoku solutionInValid = SudokuSolver.solveSudoku(inValidSod);
		
		assertNull(solutionInValid);
	}

}
