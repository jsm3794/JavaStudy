package quiz;

import java.util.Scanner;

import myobj.PirateGame;

public class C05_PirateGame {

	/*
	 	통아저씨 게임을 만들어보세요
	 	
	 	1. 게임이 시작되면 꽝 자리가 정해진다
	 	
	 	2. 플레이어는 아저씨가 튀어나올때까지 돌아가면서 계속 자리를 선택해야 한다
	 	   (플레이어는 4명으로 고정한다)
	 	
	 	3. 칼을 찌를 수 있는 홈은 20개가 있고 그 중 4개가 꽝이 된다
	 	   (꽝의 위치는 매 판 시작시 랜덤으로 설정된다)
	 	   
	 	4. 아저씨가 발사되면 해당 플레이어의 점수를 깎고 나머지의 점수를
	 	   찌르는데 성공한 횟수에 비례하여 증가시킨다
	 	   
	 	5. 각 게임이 끝날 떄 순위에 따라 소지금이 변동된다 순위에 따라 소지금이 변동된다 
	 	   (1위 +1000, 2위 +500, 3위 -500, 4위 -1000)
	 	
	 	6. 게임을 그만하겠다고 하거나 또는 한 사람의 소지금이 -가 된다면 게임이 종료된다
	 	   게임이 종료되면서 최종 스코어를 출력해준다
	 	   (이름, 점수, 남은 소지금(+얼마 벌었나) 등)
 */

	public static void main(String[] args) {
		
		boolean DEBUG_MODE = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			PirateGame game = new PirateGame();
			
			if (DEBUG_MODE) {
				game.printHoles();
				
				while (!game.gameEnd) {
					System.out.println("현재 " + (game.currentPlayer + 1) + "번 플레이어 차례입니다.");
					System.out.print("자리를 선택하세요: ");
					int choice = sc.nextInt();
					if (choice < 1 || choice > 20) {
						System.out.print("올바르지 않은 숫자입니다. 1~20끼지의 숫자를 입력하세요: ");
						continue;
					}
					game.startGame(choice);
				}
				System.out.println("한 플레이어의 소지금이 -가 되어 게임을 종료합니다.");
				game.printFinalScores();
			}
			game.gameEnd = false;
		}
	}

}