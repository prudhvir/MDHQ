
import java.util.Stack;

public class Grid {

	private int[][] grid;
	private static Stack<UnAssignedPoint> unAssignedPoints;

	public Grid(int[][] in) {
		this.grid = new int[in.length][in[0].length];
		setGrid(in);
		unAssignedPoints = new Stack<Grid.UnAssignedPoint>();
	}
	
	
	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public void assignNumber(int row, int column, int number) {
		getGrid()[row][column] = number;
	}
	
	public boolean isValidNumber(int row, int column, int number) {
		
		return notInRow(row, number) && notInColumn(column, number) &&
				notinGrid(row - row % 3, column - column % 3, number);
	}
	
	private boolean notinGrid(int start_row, int start_column, int number) {
		for(int row = 0; row < 3; row++ ) {
			for(int column = 0; column < 3; column++ ) {
				if(getGrid()[row + start_row][column + start_column] == number) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean notInColumn(int column, int number) {
		for(int row = 0; row < getGrid().length; row++ ) {
			if(getGrid()[row][column] == number) {
				return false;
			}
		}
		return true;
	}
	
	private boolean notInRow(int row, int number) {
		for(int column = 0; column < getGrid()[0].length; column++ ) {
			if(getGrid()[row][column] == number) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUnAssigned() {
		for(int row = 0; row < getGrid().length; row++ ) {
			for(int column = 0; column < getGrid()[0].length; column++ ) {
				if(getGrid()[row][column] == 0) {
					unAssignedPoints.push(new UnAssignedPoint(row,column));
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean SolveSudoku()
	{
	    
	    if (!isUnAssigned())
	       return true; 
	 
	    // Try every number possible from 1 to 9
	    for (int number = 1; number <= 9; number++)
	    {
	        // if looks promising
	        if (isValidNumber(unAssignedPoints.peek().getRow(), unAssignedPoints.peek().getColumn(), number))
	        {
	            //Assign a number
	        	assignNumber(unAssignedPoints.peek().getRow(),unAssignedPoints.peek().getColumn(),number);
	            
	            // return, if success
	            if (SolveSudoku())
	                return true;
	 
	            // Number assignment failed, so make it unassigned by putting a value '0'
	            assignNumber(unAssignedPoints.peek().getRow(),unAssignedPoints.peek().getColumn(),0);
	        }
	    }
	    
	    //Backtrack to the previous assigned point
	    if(unAssignedPoints.size() == 0) {
	    	System.out.println("No points to backtrack - No Solution");
	    	return false;
	    }
	    else
	    	unAssignedPoints.pop();
	    
	    return false;
	}
	
	
	public void print()
	{
	    for (int row = 0; row < getGrid().length; row++)
	    {
	       for (int column = 0; column < getGrid()[0].length; column++)
	             System.out.print(getGrid()[row][column] + " ");
	        System.out.println();
	    }
	}
	
	private class UnAssignedPoint {
		
		private int row;
		private int column;
		
		public UnAssignedPoint(int row, int column) {
			setRow(row);
			setColumn(column);
		}

		public int getRow() {
			return row;
		}
		
		public void setRow(int row) {
			this.row = row;
		}
		
		public int getColumn() {
			return column;
		}
		
		public void setColumn(int column) {
			this.column = column;
		}
	}
}
