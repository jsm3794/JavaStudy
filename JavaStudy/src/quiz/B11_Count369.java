package quiz;

import java.util.Scanner;

public class B11_Count369 {

	/*
	 	사용자가 숫자를 입력하면 해당 숫자까지 369게임이 진행됐을 떄 박수를 총 몇 번 쳐야하는지 출력해보세요
	 	
	 	1. 숫자를 문자열로 취급하여 검사하는 방식
	 	
	 	2, 그냥 숫자로 검사하는 방식
	 */
	
	public static void main(String[] args) {
		
		boolean DEBUG_MODE = true;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 > ");
		int num = sc.nextInt();
		
		int i = 1, n;
		int totalClaps = 0;
		int cnt = 0;
		
		while (i <= num) {
			n = i;
			while (n != 0) {
				int digit = n % 10;
				if (digit != 0 && digit % 3 == 0) {
					if(DEBUG_MODE) {
						System.out.print(i + ":" + "짝" + "\n");
					}
					totalClaps++;
					cnt++;
				}
				n /= 10;
			}
			i++;
			System.out.println();
		}
		System.out.println("박수 쳐야하는 총 횟수: " + totalClaps);
		

	}

}
