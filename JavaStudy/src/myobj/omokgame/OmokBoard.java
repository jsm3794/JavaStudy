package myobj.omokgame;

public class OmokBoard {

	private static final int SIZE = 10;
    private static final char EMPTY = '.';
    private char[][] board;

    public OmokBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean placeStone(int row, int col, char stone) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != EMPTY) {
            return false;
        }
        board[row][col] = stone;
        return true;
    }
    
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "┼");
            }
            System.out.println();
        }
    }
}
