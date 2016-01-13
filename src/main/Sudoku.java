/**
 * Sudoku class
 * @author Ahmed Elmaghraby
 * 
 *  Sudoku class is used to hold the states of each step when solving the game.
 *  It also ensures the validity of each movement
 *  
 */

package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Sudoku {

	// attributes
	private String config;
	private int emptySpaces;
	private int nonZeroSpaces;

	// the board ( grid )
	private int[][] grid;

	// arrays to hold the boolean value whether that digit appear in row/col/
	// 3x3 zone
	private boolean[][] rowDigits;
	private boolean[][] colDigits;
	private boolean[][][] zoneDigits;

	// scanner to parse the string
	private Scanner scanner;

	/**
	 * Constructor
	 * 
	 * @param config
	 *            : string holding the representation of the current Sudoku
	 *            state
	 */
	public Sudoku(String config) {

		// Initialize the boolean arrays
		rowDigits = new boolean[9][10];
		colDigits = new boolean[9][10];
		zoneDigits = new boolean[3][3][10];

		// store the configuration
		this.config = config;

		// number of current spaces
		emptySpaces = 81;

		// nonZero count
		nonZeroSpaces = 81;

		// fill the digit check arrays ( to check the existence of the digit in
		// a row - column - 3x3 zone )

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 10; j++) {

				rowDigits[i][j] = false;
				colDigits[i][j] = false;
				zoneDigits[i / 3][i % 3][j] = false;

			}
		}

		// fill the grid with the configuration

		grid = fillGrid(config);

	}

	/**
	 * fillGrid : scans the string to create a 9x9 board representing the state
	 * @param config : string with the representation of the state
	 * @return 2D array (9x9 board) 
	 * @return null - if the state is not valid sudoku state.
	 */
	private int[][] fillGrid(String config) {

		int counter = 81;
		int[][] tempGrid = new int[9][9];
		int row = 0;
		int col = 0;
		int digit;

		scanner = new Scanner(config);

		while (scanner.hasNext()) {

			if (scanner.hasNextInt()) {

				digit = scanner.nextInt();

				// make sure digit is valid and between 0 and 9
				if (digit < 0 || digit > 9) {
					return null;
				}

				tempGrid[row][col] = digit;

				// make sure the number is not a zero
				// and check if the configuration is valid
				if (digit != 0) {

					nonZeroSpaces--;
					
					// check if the digit is already in the row
					if (rowDigits[row][digit] == false)
						rowDigits[row][digit] = true;
					else
						return null;
					
					// check if the digit is already in the column
					if (colDigits[col][digit] == false)
						colDigits[col][digit] = true;
					else
						return null;

					// check if the digit is already in the 3x3 zone
					if (zoneDigits[row / 3][col / 3][digit] == false)
						zoneDigits[row / 3][col / 3][digit] = true;
					else
						return null;
				}
				col++;
				counter--;
			}

			
			if (col == 9) {
				col = 0;
				row++;
			}

			if (row == 9) {
				// we are done filling the grid
				break;
			}

		}

		// make sure we got all the digits
		if (counter != 0) {
			return null;
		}
		scanner.close();
		return tempGrid;
	}

	/**
	 * Check if the sudoku state is a solution
	 * @return True if it is the solution. False if it is not
	 */
	public boolean isSolution() {

		return (nonZeroSpaces == 0);
	}

	/**
	 * Print the grid into the console
	 *  -- for testing purposes --
	 */
	public void printGrid() {

		for (int i = 0; i < 9; i++) {

			for (int k = 0; k < 9; k++) {

				System.out.print(grid[i][k] + " ");

			}

			System.out.println("");
		}

	}

	/**
	 * put the digit into the grid in the given row/col
	 * @param digit
	 * @param row
	 * @param col
	 */
	public void putDigit(int digit, int row, int col) {
		grid[row][col] = digit;
		rowDigits[row][digit] = true;
		colDigits[col][digit] = true;
		zoneDigits[row / 3][col / 3][digit] = true;
		nonZeroSpaces--;
	}

	/**
	 * find the next possible next states
	 * @return a stack containing the possible next states from the current sudoku state
	 */
	public Stack<Sudoku> findNextSudoku() {

		Stack<Sudoku> nextStates = new Stack<Sudoku>();

		// find an empty space to fill in
		int row = 0;
		int col = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					row = i;
					col = j;

					for (int digit = 1; digit <= 9; digit++) {
						if (rowDigits[row][digit])
							continue; // digit already used in row
						if (colDigits[col][digit])
							continue; // digit already used in column
						if (zoneDigits[row / 3][col / 3][digit])
							continue; // digit already used in zone

						// This is a legal digit! Add it to possible moves.
						Sudoku temp = new Sudoku(this.toString());
						temp.putDigit(digit, row, col);
						nextStates.push(temp);
					}

					// if we couldn't fill the next possible location, then we return current stack of states
					if (grid[i][j] == 0) {
						return nextStates;
					}

				}
			}
		}

		return nextStates;
	}

	/**
	 * Check if the grid ( Sudoku state ) is valid
	 * @return true if the Sudoku state is valid, otherwise return false
	 */
	public boolean isValid() {
		if (grid == null)
			return false;
		return true;
	}

	/**
	 * Return the string representation of the current state
	 */
	public String toString() {

		StringBuilder newConfig = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newConfig.append(grid[i][j]);
				newConfig.append(" ");
			}
		}

		return newConfig.toString();
	}
}
