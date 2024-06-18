package quiz;

import java.util.Scanner;

public class B08_Palindrome {

	/*
	 	사용자가 단어를 입력하면
	 	해당 단어가 좌우대칭을 이루는 단어인지 판별해주는 프로그램을 만들어 보세요
	 	
	 	>> LEVEL
	 	-> 좌우대칭입니다.
	 	
	 	>> Apple
	 	-> 좌우대칭이 아닙니다.
	 	
	 	>> BOB
	 	-> 좌우대칭입니다.
	 	
	 	>> ABBA
	 	-> 좌우대칭입니다.
	 */
	
	public static void main(String[] args) {
		
		/*
		 	Scanner sc = new Scanner(System.in);
			System.out.print("단어 입력 >> ");
			String word = sc.nextLine();
			int len = word.length();
			boolean isPalindrome = true;
			
			for (int i = 0; i < len; i++) {
				if (word.charAt(i) != word.charAt(len -1 - i)) {
					isPalindrome = false;
				}
			}
			if (isPalindrome) {
				System.out.println("-> 좌우대칭입니다.");
			} else {
				System.out.println("-> 좌우대칭이 아닙니다.");
			}
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 입력 >> ");
		String word = sc.nextLine();
		int len = word.length();
		boolean isPalindrome = true;
		
		for (int i = 0; i < len; i++) {
//			System.out.printf("%c vs %c\n", 
//					word.charAt(i), word.charAt(len -1 - i));
			
			char ch1 = word.charAt(i);
			char ch2 = word.charAt(len - 1 - i);
			
			if (ch1 != ch2) {
				isPalindrome = false;
			}
		}
		
		if (isPalindrome) {
			System.out.printf("\"" + word + "\"는 좌우대칭입니다.");
		} else {
			System.out.printf("\"" + word + "\"는 좌우대칭이 아닙니다.");
		}

	}

}
