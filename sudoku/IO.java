import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class IO {

	public int[][] readFile(String filename) throws IOException {
		
		FileInputStream fstream = new FileInputStream(filename);
		
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line;
		int[][] result = new int[9][9];
		
		int row = 0;
		while ((line = br.readLine()) != null)   {
			
			String[] values = line.split(",");
			for(int index = 0; index < values.length; index++) {
				if(values[index].trim().equals("-")) {
					result[row][index] = 0; //Unassigned Values are initialised to '0'
				}
				else {
					result[row][index] = Integer.parseInt(values[index].trim());
				}
			}
			row++;
		}
		
		in.close();

		return result;
	}
	
	
	public void writeFile(String filename, int [][] grid) throws IOException {
		
		FileOutputStream fstream = new FileOutputStream(filename);
		
		DataOutputStream out = new DataOutputStream(fstream);
		
		for(int row = 0 ; row < grid.length; row++) {
			for(int column = 0 ; column < grid[0].length; column++) {
				out.writeChars(String.valueOf(grid[row][column]));
				if(column < grid[0].length - 1) {
					out.writeChar(',');
				}
			}
			out.writeChar('\n');//output \n after the end of the row
		}
		
		
		out.close();
	}
}
