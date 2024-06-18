package quiz;

import java.util.Scanner;

public class B08_CountE {

	/*
	 	사용자가 문장을 입력하면 해당 문장에 포함된
	 	알파벳 e의 개수를 출력하는 프로그램을 만들어보세요
	 	(※ 대/소문자 모두 개수에 포함)
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문장 입력: ");
		String input = sc.nextLine();
		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'e' || input.charAt(i) == 'E') {
				count++;
			}
		}
		System.out.printf("알파벳 e 또는 E가 나온 횟수: %d", count);

	}

}
