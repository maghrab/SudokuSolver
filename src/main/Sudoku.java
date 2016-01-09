package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Sudoku {
	String config;
	int emptySpaces;
	int nonZeroSpaces;
	
	Stack<Sudoku> nextMovements;
	
	int [][] grid;
	boolean[][] rowDigits;
	boolean[][] colDigits;
	boolean[][][] zoneDigits;
	
	public Sudoku(String config){
		
		rowDigits = new boolean[9][10];
		colDigits = new boolean[9][10];
		zoneDigits = new boolean[3][3][10];
		
		
		
		//store the configuration
		this.config = config;
		
		// number of current spaces
		emptySpaces = 81;
		
		// nonZero count
		nonZeroSpaces = 81;
		
		// fill the digit check arrays ( to check the existence of the digit in a row - column - 3x3 zone )
		
		for (int i = 0; i< 9 ; i++){
			for (int j = 0; j < 10 ; j++){
				
				rowDigits[i][j] = false;
				colDigits[i][j] = false;
				zoneDigits[i/3][i%3][j] = false;
				
			}
		}
		
		
		// fill the grid with the configuration
		try {
			grid = fillGrid(config);
		} catch (SudukoStringException e) {
			e.printStackTrace();
			System.out.println("Something is wrong with filling the grid");

		}
		
		
		
		
		
	}
	
	private int[][] fillGrid(String config) throws SudukoStringException{
		
		int counter = 81;
		int [][] tempGrid = new int[9][9];
		int row = 0;
		int col = 0;
		int digit;
		
		Scanner scanner = new Scanner(config);
		
		while(scanner.hasNext()){
			
			if (scanner.hasNextInt()){
				
				digit = scanner.nextInt();
				
				// make sure digit is valid and between 0 and 9
				if ( digit < 0 || digit > 9){
					invalid();
				}
				
				tempGrid[row][col] = digit;
				
				// make sure the number is not a zero
				// and check if the configuration is valid
				if (digit != 0 ) {
					
					nonZeroSpaces--;
				
					if (rowDigits[row][digit] == false)
						rowDigits[row][digit] = true;
					else
						invalid();

					if(colDigits[col][digit] == false)
						colDigits[col][digit] = true;
					else
						invalid();

					if(zoneDigits[row/3][col/3][digit] == false)
						zoneDigits[row/3][col/3][digit] = true;
					else
						invalid();
				}
				col++;
				counter--;
			}
			
			if ( col == 9){
				col = 0;
				row++;
			}
			
			if (row == 9){
				// we are done filling the grid
				break;
			}
			
		}
		
		// make sure we got all the digits
		if (counter != 0){
			extracted();
		}
		scanner.close();
		return tempGrid;
	}

	private void extracted() throws SudukoStringException {
		throw new SudukoStringException("Suduko doesn't contain 81 digits");
	}
	
	private void invalid() throws SudukoStringException{
		throw new SudukoStringException("Invalid Suduko input");
	}
	
	public void printGrid(){
		
		for(int i = 0; i < 9 ; i++){
			
			for(int k = 0; k < 9; k++){
				
				System.out.print(grid[i][k] + " ");
				
			}
			
			System.out.println("");
		}
		
	}
	
	public String toString(){
		
		StringBuilder newConfig = new StringBuilder();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j<9 ; j++){
				newConfig.append(grid[i][j]);
				newConfig.append(" ");
			}
		}
		
		return newConfig.toString();
	}
}


class SudukoStringException extends Exception {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SudukoStringException(String msg){
	      super(msg);
	   }
	}