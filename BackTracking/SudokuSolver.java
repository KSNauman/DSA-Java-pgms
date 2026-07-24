// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: Sudoku Solver
 * 
 * Description: 
 * Solve a 9x9 Sudoku puzzle by filling empty cells (represented by 0) such that 
 * every row, column, and 3x3 sub-grid contains the digits 1-9 exactly once.
 * 
 * Intuition:
 * Use backtracking. For each empty cell, try placing digits from 1 to 9. 
 * Before placing a digit, verify if it's safe (check its row, column, and 3x3 grid). 
 * If it leads to a valid solution recursively, return true. Otherwise, backtrack (reset to 0).
 * 
 * Complexity: O(9^(N*N)) Time in worst-case (N=9), O(N*N) Space for call stack.
 */
public class SudokuSolver {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Check column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        // Check row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case: Reached the end
        if (row == 9 && col == 0) {
            return true;
        }
        
        // Calculate next cell
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow += 1;
            nextCol = 0;
        }

        // If not empty, skip
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        
        // Try all digits
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    public static void printSudo(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exist");
            printSudo(sudoku);
        } else {
            System.out.println("Solution doesnt exist");
        }
    }
}
