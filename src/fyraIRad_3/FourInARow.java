package fyraIRad_3;

import java.util.*;

public class FourInARow {

	// There are two players: 1 and 2.
	// Player 1 starts.
	static int currentPlayer = 1;

	// Number of rows in the board
	static int ROWS = 6;

	// Number of columns in the board
	static int COLS = 9;

	// Create an empty board (already initialized to
	// 0, i.e. all places are free). Tokens of player 1
	// are represented with the number 1 in the board.
	// Those of player 2 are represented with the number 2.
	static int[][] board = new int[ROWS][COLS];

	public static void main(String[] args) {
		// You do not have to change this method
		printBoard();
		while (true) {
			int col = getColumn();
				System.out.println("Col: " + col);
			int row = getColumnsSmallestFreeRow(col);
				System.out.println("Row: " + row);
				System.out.println(currentPlayer);
			board[row][col] = currentPlayer;
			printBoard();
			if (CurrentPlayerHasWon(row, col)) {
				System.out.println("Player " + currentPlayer + " won !!");
				break;
			}
			nextPlayer();
		}
	}

	static boolean CurrentPlayerHasWon(int row, int col) {
		// TODO: write a method that determines, given row and col,
		// if the current player has at least 4 tokens in a horizontal,
		// vertical or diagonal line passing by position board[row][col].
		// It is assumed that row satisfies 0 <= row < ROWS and that
		// col satisfies 0 <= col < COLS (i.e., you do not have to check
		// here that the input position is in the board)

		// first we check horizontal
		System.out.println("Checking horizontal");
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				if (board[y][x] == currentPlayer 
						&& board[y][x+1] == currentPlayer 
						&& board[y][x+2] == currentPlayer
						&& board[y][x+3] == currentPlayer)
					return true;
			}
		}
		// then we check vertical
		System.out.println("Checking vertical");
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[y][x] == currentPlayer 
						&& board[y+1][x] == currentPlayer 
						&& board[y+2][x] == currentPlayer
						&& board[y+3][x] == currentPlayer)
					return true;
			}
		}
		// then we check positive diagonal
		System.out.println("Checking positive diagonal");
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[y][x] == currentPlayer 
						&& board[y+1][x+1] == currentPlayer
						&& board[y+2][x+2] == currentPlayer 
						&& board[y+3][x+3] == currentPlayer)
					return true;
			}
		}
		// Then we check negative diagonal
		System.out.println("Checking negative diagonal");
		for (int x = 0; x < 6; x++) {
			for (int y = 5; y > 2; y--) {
				if (board[y][x] == currentPlayer 
						&& board[y-1][x+1] == currentPlayer
						&& board[y-2][x+2] == currentPlayer 
						&& board[y-3][x+3] == currentPlayer)
					return true;
			}
		}
		System.out.println();
		return false;
	}

	public static void nextPlayer() {
		// TODO: write a method that changes the currentPlayer to be
		// the other player.
		if (currentPlayer == 1)
			currentPlayer = 2;
		else
			currentPlayer = 1;
	}

	public static int getColumnsSmallestFreeRow(int col) {
		// TODO: write a method that returns, for the column col,
		// the smallest row, larger or equal to 0, that is not
		// occupied by any of the players.
		// The method should return ROWS if all rows are occupied.
		// You can assume that col satisfies 0 <= col < COLS (i.e., you
		// do not have to check it here).
		int y = 0;
		while (y < ROWS -1 && board[y][col] != 0) {
			y++;
		}
		if(y == ROWS-1 && board[y][col] != 0) {
			return ROWS;
		}
		return y;
	}

	public static int getColumn() {
		int col = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Player " + currentPlayer + " Choose a non-full column between 1 and " + (COLS) + ": ");
		// TODO: write a method that keeps asking the current player for a
		// column between 1 and COLS (inclusive) that is not full until it
		// obtains such a column col. In that case, the method returns col - 1.
		// In other words, the method returns a col that satisfies:
		// 0 <= col < COLS and there is some row such that 0 <= row < ROWS
		// and board[row][col] is 0.
		// Make use of the nextInt Scanner method and of the
		// InputMismatchException exception when asking for the column.

		Boolean wrongInput = true;
		while (wrongInput) {
			try {
				col = in.nextInt();
				//If the input is out of bounds we continue to assk for another integer, else we stop the loop
				if (col < 1 || col > COLS) {
					System.out.print("Player " + currentPlayer + " Choose a non-full column between 1 and " + (COLS) + ": ");
				} else
					wrongInput = false;
			//If the player doesnt input a integer we catch the exception and ask for another integer
			} catch (InputMismatchException e) {
				System.out.print("Player " + currentPlayer + " Choose a non-full column between 1 and " + (COLS) + ": ");
				in.nextLine();
			}
		}
		return col-1;
	}

	public static void printBoard() {
		// You do not have to change this method
		System.out.println();

		// For each row
		for (int row = ROWS - 1; row >= 0; row--) {
			// Print separator first on row
			System.out.print("|");
			// For each column in that row
			for (int col = 0; col < COLS; col++) {
				// Print player number or space
				if (board[row][col] == 0) {
					System.out.print(" 0");
				} else {
					System.out.print(" " + board[row][col]);
				}
			}
			// Print separator and row number last on row
			System.out.println(" | " + (row + 1));
		}

		// Print separators in bottom
		for (int col = 0; col < COLS + 2; col++) {
			System.out.print("--");
		}

		System.out.println();

		// Print column numbers
		System.out.print("|");
		for (int col = 0; col < COLS; col++) {
			System.out.print(" " + (col + 1));
		}
		System.out.println(" |\n");
	}

}
