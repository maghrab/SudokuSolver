package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {
	String config;
	int emptySpaces;
	
	ArrayList<Sudoku> nextMovements;
	int [][] grid;
	boolean[][] rowDigits;
	boolean[][] colDigits;
	boolean[][][] zoneDigits;
	
	public Sudoku(String config){
		
		//store the configuration
		this.config = config;
		
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
		
		Scanner scanner = new Scanner(config);
		
		while(scanner.hasNext()){
			//System.out.println("loop");
			if (scanner.hasNextInt()){
				
				tempGrid[row][col] = scanner.nextInt();
				row++;
				counter--;
			}
			
			if ( row == 9){
				row = 0;
				col++;
			}
			
			if (col == 9){
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
	
	public void printGrid(){
		
		for(int i = 0; i < 9 ; i++){
			
			for(int k = 0; k < 9; k++){
				
				System.out.print(grid[i][k] + " ");
				
			}
			
			System.out.println("");
		}
		
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