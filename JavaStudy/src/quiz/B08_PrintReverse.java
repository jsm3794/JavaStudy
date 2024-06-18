package quiz;

import java.util.Scanner;

public class B08_PrintReverse {

	/*
	 	사용자가 문장을 입력하면 해당 문장을 거꾸로 출력해보세요
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문장 출력: ");
		String input = sc.nextLine();
		int len = input.length();
		
		// 마지막 인덱스부터 0까지 반복하며 한 글자씩 출력하기
		for (int i = len - 1; i >= 0; i--) {
			System.out.print(input.charAt(i));
		}
		
		// 마지막 인덱스에서 1씩 더 빼면서 한 글자씩 출력하기
		for (int i = 0; i < len; i++) {
			System.out.print(input.charAt(len -1 - i));
		}

	}

}
