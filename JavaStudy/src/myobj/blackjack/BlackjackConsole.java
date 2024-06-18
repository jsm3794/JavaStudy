package myobj.blackjack;

import java.util.Scanner;

public class BlackjackConsole {

	/*
	 	1. 컴퓨터(딜러)와 사람(플레이어)이 카드를 뽑아야 한다.
	 	
	 	2. 처음에는 둘 모두 2장씩 받는다. 이 때 카드는 한장 가려놓아야 한다.
	 	
	 	3. 플레이어는 카드를 받은 후 상황을 보고 
	 	   계속 뽑을지(hit) 그만 뽑을지 결정해야 한다.
	 	   
	 	4. 플레이어가 hit를 선택하면 카드를 한 장 더 받는다.
	 	
	 	5. 플레이어가 stand를 선택하면 딜러는 가려놨던 카드를 오픈 후 카드를 뽑기 시작한다.
	 	   이 때 딜러는 의사 결정을 할 수 없고 정해진 규칙에 따라야 한다.
	 	   
	 	   ※ 딜러의 규칙 - 가진 카드의 합이 16 이하라면 뽑는다. 17 이상이면 멈춘다.
	 	   
	 	6. J, Q, K는 모두 10의 가치를 지닌다.
	 	
	 	7. A는 필요에 따라 1로 쓸 수도 있고 11로 쓸 수도 있다.
	 	   (A는 11의 가치를 지니고 있다가 카드의 합이 21이 넘어가면 1이 된다)
	 	   
	 	8. 가진 카드의 합이 21을 넘어가면 버스트, 정확하게 21이면 블랙잭이다.
	 	   플레이어가 버스트를 당하면 딜러는 카드를 뽑지도 않고 승리한다.
	 	   
	 	   참고자료 - https://www.247blackjack.com/
	 */
	
	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		
		Player player = new Player(0, 3000);
		Player dealer = new Player(1, 0);
		
		CardDeck deck = new CardDeckImpl();
		
		System.out.println("#### 블랙잭 ####");
		while (true) {
			System.out.println("베팅 금액 > ");
			int bet = sc.nextInt();
			
			player.addCard(deck.draw());
			player.addCard(deck.draw());
			
			dealer.setPrintType(Player.DEALER_NOT_OPEN);
			dealer.addCard(deck.draw());
			dealer.addCard(deck.draw());
			
			player.printHand();
			dealer.printHand();
			
			while (true) {
				System.out.print("1.hit\t2.stand\n> ");
				int select = sc.nextInt();
				
				if (select == 1) {
					player.addCard(deck.draw());
					player.printHand();
					
					int value = GameLogic.getValue(player.getHand());
					
					if (value >= 21) {
						break;
					}
					else if (select == 2) {
						break;
					} else {
						System.out.println("제대로 돌려주세요...");
					}
				}
				
				System.out.println("-- 게임 결과 --");
				player.printHand();
				dealer.setPrintType(Player.DEALER_OPEN);
				dealer.printHand();
				
				if (GameLogic.getValue(player.hand) <= 21) {
					// 딜러가 카드를 뽑는 곳 (16이하라면 계속 뽑는다, 플레이어가 버스트라면 뽑지 않아도 된다)
					while (GameLogic.getValue(dealer.getHand()) <= 16) {
						dealer.addCard(deck.draw());
						dealer.printHand();
						Thread.sleep(1000); // 현재 프로그램을 1초 멈춘다
					}
				}
			}
			
			int result = GameLogic.check(player.getHand(), dealer.getHand());
			
			switch (result) {
				case GameLogic.PLAYER_WIN:
					player.earnMoney(bet);
					System.out.println("플레이어가 이겼습니다!");
					System.out.println("현재 플레이어의 소지금: " + player.getMoney());
					break;
				case GameLogic.DEALER_WIN:
					player.lossMoney(bet);
					System.out.println("딜러가 이겼습니다!");
					System.out.println("현재 딜러의 소지금: " + player.getMoney());
					break;
				case GameLogic.PUSH:
					System.out.println("비겼습니다!");
					break;
			}
			
			player.resetHand();
			dealer.resetHand();
			
			
		}
	}
}
