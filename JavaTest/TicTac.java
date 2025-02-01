package JavaTest;

import java.util.Scanner;

public class TicTac {

    public static void main(String[] args) {
        char player = 'X';
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);

        // Initialize the board with empty spaces
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }

        int moves = 0; // To track the number of moves
        while (true) {
            printBoard(board);
            System.out.println("Player " + player + ", enter row and column (0-2):");

            int row = sc.nextInt();
            int col = sc.nextInt();

            // Validate input
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = player;
            moves++;

            // Check if the current player has won
            if (isWin(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " won the match! 😎");
                break;
            }

            // Check for a draw
            if (moves == 9) {
                printBoard(board);
                System.out.println("It's a draw! 😐");
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }
        sc.close();
    }

    private static boolean isWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Main diagonal
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) { // Anti-diagonal
            return true;
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
