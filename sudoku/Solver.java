
import java.io.IOException;

public class Solver {

	
	public static void main(String[] args) throws IOException {

		IO io = new IO();
		int board[][] = io.readFile(args[0]);
		Grid grid  = new Grid(board);
		
		System.out.println("Grid before Solving\n");
		grid.print();
		
		//solve Sudoku
		grid.SolveSudoku();
		
		System.out.println("After Solving\n");
		grid.print();
		
		io.writeFile(args[1], grid.getGrid());
		
	}

	
	
}
