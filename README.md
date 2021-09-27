# SUDOKU
Object-oriented software development course - Assginment 1

The SUDOKU problem is defined by a 9 * 9 board on which numbers from 1 to 9 should be placed so that in each row, column and sub-square (3 * 3) all numbers are from 1-9.
Or in other words - in each of the 27 complexes (9 rows, 9 columns and 9 sub-squares) the number will not be repeated more than once (detailed explanation of the rules of the game at http://www.sudoku.name/rules/hb).

In the game of sudoku, there are exposed numbers (givens) that define a single solution.
The exposed numbers must be received from the user by printing the question:

<b>Please enter a given number and its location</b>

For example: if the user wants to place the number 9 in position (0,0) - (row, column) he will type 900.

You must continue to receive numbers from the user until a number smaller than 100 is typed. This means that the user can enter as many exposed numbers (givens) as he wants. The program will resolve the sudoku as soon as the user finishes inserting givens (insert number smaller than 100). It can be assumed that all the givens comply with the sudoku rules, meaning that there is no need for an input test.

At this point the program will resolve the given sudoku board and print the solution to the screen.

If there is no solution, print "No valid solution"



![image](https://user-images.githubusercontent.com/80900890/134884580-3cbf58de-d706-425b-94d2-31480edf8b52.png)
