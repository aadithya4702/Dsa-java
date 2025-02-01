package JavaTest;

import java.util.Arrays;

public class SolveSudoku {

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("It is not solvable");
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int index = 1; index <= 9; index++) {
                        if (isValid(board, i, j, index)) {
                            board[i][j] = (char) ('0' + index); // Convert number to char

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // Solved
    }

    private static boolean isValid(char[][] board, int row, int col, int num) {
        char charNum = (char) ('0' + num);

        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == charNum)
                return false;
            // Check column
            if (board[i][col] == charNum)
                return false;
            // Check 3x3 grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == charNum)
                return false;
        }

        return true;
    }
}
