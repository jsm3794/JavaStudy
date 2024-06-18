package quiz;

import java.util.Scanner;

/*
 	# Updown 게임을 만들어보세요
 	
 	1. 게임이 시작되면 1 ~ 100 사이의 랜덤 숫자가 정답이 된다
 	
 	2. 사용자가 숫자를 입력하면 Up인지 Down인지 알려준다
 	
 	3. 만약 사용자가 현재 좁혀놓은 범위를 벗어나는 숫자를 입력했다면
 	   기회를 소진하지 않고 다시 입력할 수 있는 기회를 준다
 	   
 	   ex> 50
 	       Down! (남은기회 4회)
 	       75
 	       추측 범위를 벗어난 숫자입니다... (남은 기회 4회)
 	       
 	4. 6번 안에 못맞추면 정답이 뭐였는지 알려주고 프로그램을 종료한다
 	
 	5. 사용자가 정답을 맞추면 축하한다고 해주고 프로그램을 종료한다
 */

public class B12_UpdownGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int answer = (int)((Math.random() * 100) + 1);
		int guess;
		int minRange = 1;
		int maxRange = 100;
		int cnt = 6;
		System.out.print("1 ~ 100 사이의 숫자를 입력 > ");
		
		for (int i = 0; i <= 6; i++) {
			guess = sc.nextInt();
			
			if (guess < minRange || guess > maxRange) {
				System.out.printf("추측 범위를 벗어난 숫자입니다... (남은 기회: %d회)\n", cnt);
				continue;
			} else if (guess > answer) {
				System.out.printf("Down! (남은 기회: %d회)\n", --cnt);
				maxRange = guess - 1;
			} else if (guess < answer) {
				System.out.printf("Up! (남은 기회: %d회)\n", --cnt);
				minRange = guess + 1;
			} else if (guess == answer) {
				System.out.println("정답입니다!");
				break;
			} 
			
			if (cnt == 0) {
				System.out.println("기회를 모두 소진했니다. 정답은 " + answer + "입니다.");
				break;
			}
			System.out.printf("%d ~ %d 사이의 숫자를 입력 > ", minRange, maxRange);
		}
		
	}

}
