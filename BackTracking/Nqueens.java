package BackTracking;


public class Nqueens {
    public static int count = 0;

    public static boolean issafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonal right up
        for (int i = row - 1, j = col + 1; j < board.length && i >= 0; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void queens(char[][] board, int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        // for safe spot

        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                queens(board, row + 1);
                board[row][j] = '.';
            }
        }

        /*
         * for printing all the possibilites
         * // column loop : iterates through each col(j) in current row(row)
         * for (int j = 0; j < board.length; j++) {
         * board[row][j] = 'Q';
         * queens(board, row + 1);// function call
         * //for better understanding try to comment the below line
         * board[row][j] = '.';// backtracking step
         * }
         */
    }

    public static boolean possibilites(char[][] board, int row) {
        if (row == board.length) {
            // printBoard(board);
            count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                if (possibilites(board, row + 1)) {
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("--------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        char[][] board = new char[n][n];
        // board creation with no players
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // queens(board, 0);
        // System.out.println("Wasys: " + count);

        // for one solution
        if (possibilites(board, 0)) {
            System.out.println("Sol is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
    }
}
/*
 * fun fact if u just try for n=25 the output would be lasting till days
 * as recursive call take O(n!) and issafe funtion O(n)
 * so overall O(n!)
 * only for n=10 it takes 20ms
 * for n=18 several seconds
 * for n=25 several hours or days too
 */
/*
 * This program solves the N-Queens problem using backtracking.
 * 
 * - issafe: Checks if placing a queen at a specific position is safe.
 * - queens: Finds and prints all possible solutions to the problem.
 * - possibilites: Checks if at least one solution exists and prints it.
 * - printBoard: Utility function to display the board configuration.
 * - main: Initializes the board and demonstrates solving the problem.
 */
