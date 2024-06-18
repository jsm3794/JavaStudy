package quiz;

import java.util.Scanner;

public class B07_GuessDigit {

	/*
	 	(1) 사용자가 int타입으로 값을 입력하면 해당 숫자가 몇 자리 숫자인지
	 	    알려주는 프로그램을 만들어보세요
	 */
	
	public static void main(String[] args) {
		
		/*
		 	// 1)
		 	Scanner sc = new Scanner(System.in);
			
			System.out.println("숫자 입력: ");
			int input = sc.nextInt();
			int digit = 0;
			
			for (int i = input; i != 0; i /= 10) {
				digit++;
			}
			System.out.printf("입력한 값은 %d이고, %d자리 숫자 입니다.", input, digit);
		 	
		 	// 2)
		 	Scanner sc = new Scanner(System.in);
			
			System.out.println("숫자 입력: ");
			int input = sc.nextInt();
			int digit = 0;
			
			for (int i = input; i != 0; digit++) {
				i /= 10;
			}
			System.out.printf("입력한 값은 %d이고, %d자리 숫자 입니다.", input, digit);
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력: ");
		int input = sc.nextInt();
		int digit = 0;
		
		for (int i = input; i != 0; i /= 10) {
			digit++;
		}
		System.out.printf("입력한 값은 %d이고, %d자리 숫자 입니다.", input, digit);

	}

}
