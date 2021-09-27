
import java.util.Scanner;


public class sudoku {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] board = new int[9][9];
    public static boolean[][] given = new boolean[9][9];
    public static int row;
    public static int column;

    public static void main(String[] args) {
        boolean gameOver = false;
        System.out.println("Welcome to Fatma – Sudoku, to start the game press enter");
        sc.nextLine();
        getGivens();
        initBoard();
        while (!gameOver) {
            if (Hasama())
                gameOver = nextMove();
            else {
                boolean valid = goToLastHasama();
                if (!valid) {
                    System.out.print("No valid solution");
                    gameOver = true;
                }

            }

        }
    }// main

    private static void initBoard() {// initializing the board
        row = 0;
        column = 0;
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (!given[i][j]){
                    board[i][j]=0;
                }
            }
        }
    }


    public static boolean nextMove() { // determining if the program has finished or another step is needed
        if (row == 8 && column == 8) {
            printBoard();
            return true;
        }
        if (column == 8) {
            column = 0;
            row++;
        } else
            column++;
        return false;

    }

    private static void printBoard() {// a function that prints the board at the end of the number assignments
        System.out.println("This is the solution:");
        System.out.println();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if ((j != 8) || (j == 8 && i == 8))
                    System.out.print("\t" + board[i][j]);
                if (j == 8 && i != 8)
                    System.out.println("\t" + board[i][j]);
            }

    }

    public static void getGivens() { // a function for receiving the given numbers from the user
        System.out.println("Please enter a given number and its location");
        int num = sc.nextInt();
        while (num >= 100 && num <= 999) {
            board[(num / 10) % 10][num % 10] = num / 100;
            given[(num / 10) % 10][num % 10] = true;
            System.out.println("Please enter a given number and its location");
            num = sc.nextInt();
        }
        System.out.println("Looking for a solution...");
    }

    public static boolean Hasama() { // a function to assign numbers to the board where they are not given
        if (given[row][column])
            return true;
        int i = board[row][column] + 1;
        while (i<10) {
            if (canInsert(i)) {
                board[row][column] = i;
                return true;
            } else
                i++;
        }
        board[row][column]=0;
        return false;
    }

    public static boolean goToLastHasama(){ // a function that changes the row and column fields to the last assignment of a non given not zero number
        while(row>=0){
            while (column>0){
                column--;
                if (!given[row][column]) {
                    return true;
                }
            }
            column=8;
            row--;
        }
        return false;
    }
    public static boolean canInsert(int i) { // a function checking if there is a legal assignment for the number i in the current board
        for(int j=0; j<9;j++){
            if (board[j][column]==i) // checking if i exists in the column
                return false;
            if (board[row][j]==i) // checking if i exists in the line
                return false;
        }
        int columnOffset = (column)/3 * 3; // checking if i exists in the 3*3 square
        int rowOffset = (row)/3 * 3;
        for (int j=0; j<3; j++){
            for (int k=0; k<3; k++){
                if (board[rowOffset+j][columnOffset+k]==i){
                    return false;
                }
            }
        }
        return true;
    }
}
