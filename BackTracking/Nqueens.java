// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: N-Queens Problem
 * 
 * Description: 
 * Place N queens on an NxN chessboard such that no two queens attack each other.
 * This class includes methods to count solutions, print all solutions, and print a single solution.
 * 
 * Intuition:
 * Use backtracking. Try placing a queen in each column of the current row. 
 * Before placing, check if it's safe (no other queen in the same column, left-diagonal, or right-diagonal).
 * If safe, place the queen, move to the next row, and recursively try to place the rest.
 * Backtrack by removing the queen (setting it back to '.') and trying the next column.
 * 
 * Complexity: O(N!) Time, O(N^2) Space.
 */
public class NQueens {
    public static int count = 0;

    public static boolean issafe(char[][] board, int row, int col) {
        // Check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check diagonal right up
        for (int i = row - 1, j = col + 1; j < board.length && i >= 0; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void queens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                queens(board, row + 1);
                board[row][j] = '.'; // Backtrack
            }
        }
    }

    public static boolean possibilites(char[][] board, int row) {
        if (row == board.length) {
            count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';
                if (possibilites(board, row + 1)) {
                    return true;
                }
                board[row][j] = '.'; // Backtrack
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
        int n = 4; // Testing with N=4
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        if (possibilites(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
    }
}
