package quiz;

import java.util.Scanner;

import myobj.baskin.BaskinGame;
import myobj.baskin.BaskinGame2;
import myobj.baskin.BaskinPlayer;

public class C07_31Game {

	/*
	 	# 31 Game
	 	
	 	- 프로그램을 시작하면 게임에 참여하는 인원과 마지막 숫자를 설정한다
	 	- 이전 사람이 골랐던 숫자에 +1 ~ +3씩 더할 수 있다
	 	- 게임을 진행하다가 마지막 숫자를 입력하게 되는 사람이 패배한다
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("참여하려는 인원은 몇명? ");
		int playerSize = sc.nextInt();
		System.out.print("이 게임의 마지막 숫자는? ");
		int lastNum = sc.nextInt();
		
		BaskinGame game = new BaskinGame(lastNum);
		BaskinPlayer player = new BaskinPlayer(playerSize);
		
		int turn = 0;
		
		while (true) {
			int playerNum = player.getPlayerNum(turn);
			System.out.printf("플레이어%d의 차례 > ", playerNum);
			int result = game.next(sc.nextInt());
			
			if (result == -1) {
				System.out.println("[경고] 1 ~ 3 사이의 숫자를 입력해주세요");
				continue;
			} else if (result == -2) {
				System.out.println("[경고] 그 숫자는 더할 수 없습니다");
				continue;
			}
			
			System.out.printf("플레이어%d > %d!\n", playerNum, result);
			
			if (game.isEnd()) {
				System.out.printf("플레이어%d님의 패배입니다!\n", playerNum);
				break;
			}
			
			++turn;
		}
	}
}
