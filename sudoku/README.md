MDHQ

====
MobileDev HQ - Sudoku Solver

To compile the program run the following commands:

```bash
$ make clean
$ make
```

One input file is expected to be in the directory, and the filename has to be passed as an argument to run the program. An output file also needs to be specified to write the output of the solved grid to a file. 

To run the program, run the following command:

```bash
$ java Solver input_file_name output_file_name
```

For example

```bash
$ java grid.txt solvedGrid.txt
```

To test the program, run the following command:

```bash
$ java Tests input_file_name solved_file_name
```

For example

```bash
$ java Tests grid.txt solvedGrid.txt
```

This will print 'Valid' if the solution is valid and the original points in intial board are not modified.
Else, it will return 'Invalid Solution'
