
import java.io.IOException;

public class Tests {

	public static void main(String[] args) throws IOException {

		if(args.length < 2) {
			System.out.println("Two arguments must be provided\nUsage - java Tests input_file output_file");
		}
		
		IO io = new IO();
		int original_board[][] = io.readFile(args[0]);
		int solved_board[][] = io.readFile(args[1]);
		
		if(validate(original_board, solved_board)) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Ivalid solution");
		}
		
	}

	private static boolean validate(int[][] original_board, int [][] solved_board) {
		
		for(int row = 0; row < solved_board.length; row++ ) {
			for(int column = 0; column < solved_board[0].length; column++ ) {
				
				/*
				 * Check to make sure the assigned points of the original board are not modified
				 */
				if(original_board[row][column] != 0) {
					if(solved_board[row][column] != original_board[row][column]) {
						return false;
					}
				}
				
				if(!isValidNumber(solved_board, row, column, solved_board[row][column])) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean isValidNumber(int[][] board, int row, int column, int number) {
		
		return isValidInRow(board, row, column, number) && isValidInColumn( board, row, column, number) &&
				isValidInGrid(board, row, column, number);
	}
	
	private static boolean isValidInGrid(int[][] board, int row, int column, int number) {
		
		int start_row = row - row % 3;
		int start_column = column - column % 3;
		for(int temp_row = 0; temp_row < 3; temp_row++ ) {
			for(int temp_column = 0; temp_column < 3; temp_column++ ) {
				if((board[temp_row + start_row][temp_column + start_column] == number
						&& ( (temp_row + start_row) != row 
						|| (temp_column + start_column) != column))
						|| board[temp_row + start_row][temp_column + start_column] <= 0
						|| board[temp_row + start_row][temp_column + start_column] > 9) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isValidInColumn(int[][] board, int row, int column, int number) {
		for(int temp_row = 0; temp_row < board.length; temp_row++ ) {
			if((board[temp_row][column] == number && row != temp_row) || board[temp_row][column] <= 0 
					|| board[temp_row][column] > 9 ) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isValidInRow(int[][] board, int row, int column, int number) {
		for(int col = 0; col < board[0].length; col++ ) {
			if((board[row][col] == number && col != column) || board[row][col] <= 0 || 
					board[row][col] > 9) {
				return false;
			}
		}
		return true;
	}

}
