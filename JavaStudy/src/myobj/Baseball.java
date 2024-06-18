package myobj;

import java.util.Random;
import java.util.Scanner;

public class Baseball {

	int maxAttempts = 9;
	int ranNum = 4;
	int[] answer;
	
	public void Game() {
		generateAnswer();
		
	}
	
	public void generateAnswer() {
		
		Random ran = new Random();
		answer = new int[ranNum];
		boolean[] input = new boolean[10];
		int i = 0;
		while (i < ranNum) {
			int num = ran.nextInt(10);
			if (input[num]) {
				answer[i++] = num;
				input[num] = true;
			}
		}
	}
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임을 시작합니다. ");
		System.out.print("숫자 입력 > ");
		System.out.println();
		
		for (int attempts = 1; attempts <= maxAttempts; attempts++) {
			System.out.println("시도 횟수: " + attempts + "\n숫자 입력 > ");
		}
		
		
	}
}
