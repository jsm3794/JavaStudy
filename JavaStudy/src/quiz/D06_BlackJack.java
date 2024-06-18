package quiz;

import myobj.blackjackgame.Dealer;
import myobj.blackjackgame.Deck;
import myobj.blackjackgame.Player;

public class D06_BlackJack {

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
	
	public static Deck deck;
	public static Player player;
	public static Dealer dealer;
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		
		initialDeal();
	}

	private static void initialDeal() {
		for (int i = 0; i < 2; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
		
		
		
	}
}
