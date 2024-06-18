package myobj;

import java.util.Arrays;

public class PirateGame {

	int[] holes = new int[20];
	public int currentPlayer = 0;
	Player[] players = new Player[4];
	int successCount = 0;
	
	public boolean gameEnd = false;
	
	public PirateGame() {
		genHoles();
		initializePlayers();
	}
	
	void genHoles() {
		for (int i = 0; i < 4; i++) {
			holes[i] = (int)(Math.random() * 20 + 1);
			for (int j = 0; j < i; j++) {
				if (holes[i] == holes[j]) {
					--i;
					break;
				}
			}
		}
	}
	
	void initializePlayers() {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Player " + (i + 1), 0 ,0);
		}
	}
	
	public void printHoles() {
		System.out.println("꽝 위치: " + Arrays.toString(holes));
	}
	
	public void startGame(int choice) {
		Player currentPlayer = players[this.currentPlayer];
		boolean isBomb = false;
		for (int hole : holes) {
			if (hole == choice) {
				isBomb = true;
				break;
			}
		}
		
		if (isBomb) {
			System.out.println("꽝!");
			currentPlayer.score -= 100;
		} else {
			System.out.println("통과!");
			currentPlayer.score -= 50;
		}
		
		for (Player player : players) {
			if (player != currentPlayer) {
				player.score += 30 + successCount;
			}
			successCount++;
		}
		this.currentPlayer = (this.currentPlayer + 1) % 4;
		
		for (Player player : players) {
			if (player.score < 0) {
				gameEnd = true;
				break;
			}
		}
	}
	
	// 최종 점수 및 순위 출력
	public void printFinalScores() {
	    System.out.println("최종 점수 및 소지금 변동: ");
	    for (Player player : players) {
	        int rank = getRank(player);
	        int moneyChange = calcMoneyChange(rank);
	        player.updateMoney(moneyChange);
	        System.out.println(player.name + ": 점수 - " 
	            + player.score + ": 소지금 변동 - " + moneyChange);
	    }
	}
	
	// 플레이어의 순위 계산
	public int getRank(Player player) {
		int rank = 1;
		for (Player otherPlayer : players) {
			if (otherPlayer != player && otherPlayer.score > player.score) {
				rank++;
			}
		}
		return rank;
	}
	
	public int calcMoneyChange(int rank) {
		switch (rank) {
			case 1 :
				return 1000;
			case 2 :
				return 500;
			case 3 :
				return -500;
			case 4 :
				return -1000;
			default :
				return 0;
		}
	}
}

