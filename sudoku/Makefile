#
### A simple makefile for compiling three java classes
#
##
## define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# # # the -g flag compiles with debugging information
# # #
JFLAGS = -g
# #
# # # typing 'make' will invoke the first target entry in the makefile 
# # # (the default one in this case)
# # #
default: IO.class Grid.class Solver.class
# #
# # # this target entry builds the IO class
# # # the IO.class file is dependent on the IO.java file
# # # and the rule associated with this entry gives the command to create it
# # #
IO.class: IO.java
	$(JCC) $(JFLAGS) IO.java
#
Grid.class: Grid.java
	$(JCC) $(JFLAGS) Grid.java
#
Solver.class: Solver.java
	$(JCC) $(JFLAGS) Solver.java
##
## To start over from scratch, type 'make clean'.  
## Removes all .class files, so that the next make rebuilds them
## #
clean: 
	$(RM) *.class
