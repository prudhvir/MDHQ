Sudoku Program

Assumptions:
Its assumed that input is a 9 X 9 grid and the input is in the format specified in
sudoku/grid.txt

1. This algorithm works on a backtracking mechanism. It works as follows:
   1. Try to find a point that is unassigned and put in a value (>0 and <=9) 
      in that point if it is valid, and then fill the rest of the grid.
   2. At any time, if all the digits are tried in a point and nothing works out,
      backtrack to the previous point in the stack and put another value 
      in that point and then fill the rest of the grid.
   3. At any time, if there is no unassigned point, return true to indicate that
      puzzle is solved. 

   find row and column of unassigned point
   if no point is found, return true

   for digits 1 to 9
	put that digit in row and column if its valid and recursively fill
        the rest of the grid

	if it is succesful return true
	else, unassign this point and put another

   if all the digits are exhausted, backtrack to the previous point in the stack 

2. Assume there are K unassigned points in the grid.
   Best Case:
	Everything works out in the first guess and you do not backtrack at all.
        In this case, the complexity is O(K)
   Worst Case:
        There are 9 possible digits in each unassigned point and you backtrack and
        try to put every possible digit in that point.
        In this case, the complexity is O(9^K)

3. This program is designed this way such that, instead of exhaustively examining
   all the possibilities of digit at each point, we can find a solution where we 
   choose one of the available options and try to solve the problem recursively. 
   At some point, if we realise that this choice doesn't work out, we backtrack
   and try to choose other alternatives.

4. Some other decisions:
   1. To use an additional boards at each stage to backtrack. This would have 
      been worse as the space complexity is increased.
   2. To pass the board as a parameter to solveSudoku() method. This would have 
      been worse as the number of recursive calls increase, the stack space to 
      store the board also increases.
