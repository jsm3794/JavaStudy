package myobj.omokgame;

import java.util.Scanner;

public class OmokGame {

	// 오목을 만들어 주세요
	
	OmokBoard board;
	OmokPlayer p1;
	OmokPlayer p2;
	boolean blackTurn;
	
	public static void main(String[] args) {
		
		OmokGame game = new OmokGame("p1", "p2");
	}
	
	public OmokGame(String p1Name, String p2Name) {
		OmokBoard board = new OmokBoard();
		OmokPlayer p1 = new OmokPlayer(p1Name, '○');
		OmokPlayer p2 = new OmokPlayer(p2Name, '●');
		blackTurn = true;
	}
	
	public void playGame() {
		Scanner sc = new Scanner(System.in);
        while (true) {
        	OmokPlayer currPlayer = blackTurn ? p1 : p2;
            System.out.println(currPlayer.getName() + "의 차례 (" + currPlayer.getStone() + ")");

            System.out.print("row 입력 (0-9): ");
            int row = sc.nextInt();
            System.out.print("column 입력 (0-9): ");
            int col = sc.nextInt();

            if (!board.placeStone(row, col, currPlayer.getStone())) {
                System.out.println("다시 시도하세요");
                continue;
            }
            blackTurn = !blackTurn;
        }
	}
	
	
	
	
}
