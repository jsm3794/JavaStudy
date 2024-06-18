package quiz;

import java.util.Scanner;

public class B00_WonToDollar {

	/*
	 	한국 돈을 입력하면 달러로 얼마인지 출력해주는 프로그램을 만들어보세요
	 */
	
	public static void main(String[] args) {
		
		/*
			내 풀이)
			Scanner sc = new Scanner(System.in);
			
			System.out.println("한국 돈 입력 > ");
			// $1 = 1373.32원
			int exchangeRate = sc.nextInt();
			double won = 0.00073;
			double dollar = exchangeRate * won;
					
			System.out.printf("%.2f", dollar);
		 */
		
		// Scanner, print(), printf()
		Scanner sc = new Scanner(System.in);
		
		System.out.println("KRW > ");
		int krw = sc.nextInt();
		
		// $1 당 1373.55원
		double exchangeRate = 1373.55;
		
		double usd = krw / exchangeRate;
		
		System.out.printf("%dKRW은 %.2fUSD입니다.\n", krw, usd);

	}

}
