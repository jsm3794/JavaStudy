package quiz;

import java.util.Scanner;

public class B11_Prime {

	/*
	 	사용자가 정수를 입력하면
	 	1부터 입력한 숫자 사이에 존재하는 모든 소수를 출력해보세요
	 	
	 	※ 소수(prime): 약수가 1과 자기 자신밖에 없는 수
	 	  (2, 3, 5, 7, 11, 13 ..)
	 */
	
	public static void main(String[] args) {
		
		/*
		 	Scanner sc = new Scanner(System.in);
			System.out.println("소수 입력: ");
			int num = sc.nextInt();
			
			int i = 2, j = 2;
			boolean prime = true;
			while (i <= num) {
				while (j * j <= i) {
					if (i % j == 0) {
						prime = false;
						break;
					}
					j++;
					
				}
				
				if (prime) {
					System.out.println(i + " ");
				}
				i++;
				
			}
		 */
		
		int targetNum = 1500;
		
		// 2부터 사용자가 입력한 숫자까리 있는 모든 숫자의 약수 개수를 체크한다
		// 해당 숫자의 약수가 2개라면 그 숫자는 소수다
		for (int checkNum = 2; checkNum <= targetNum; ++checkNum) {
			int checkCount = 0;
			System.out.print(checkNum + "\t: [");
			
			for (int divider = 1; divider <= checkNum; ++divider) {
				if (checkNum % divider == 0) {
					if (divider != checkNum) {
						System.out.print(divider + ", ");
					} else {
						System.out.print(divider + "]\n");
					}
					++checkCount;
				}
			}
			
//			if (checkCount == 2) {
//				System.out.print(" *소수");
//			}
//			System.out.println();
		}
		
		// 해당 숫자를 1과 자기 자신을 제외한 숫자로 나누어 봤을 때
		// 나누어 떨어지는 숫자가 존재한다면 소수가 아니다
		
		
		for (int i = 2; i < 230; ++i) {
			boolean prime = true;
			System.out.println("소수 입력: ");
			double sqrt = Math.sqrt(i);
			// 1과 자기자신을 제외한 모든 숫자로 나눠본다
			// (2부터 체크하는 숫자의 제곱근까지 나눠본다)
			for (int j = 2; j < i; ++j) {
				// 나누어 떨이지는게 하나라도 존재한다면 더 이상 소수가 아니므로
				// 검사를 그만해도 된다
				if (i % j == 0) {
					prime = false;
					break;
				}
			}
			
			if (prime) {
				System.out.println("소수");
			} else {
				System.out.println('X');
			}
		}

	}

}
