package quiz;

import java.util.Scanner;

public class D09_isPhoneNumber {

	/*
	 	전달받은 문자열이 올바른 핸드폰 번호인지 검사하는 메서드를 만들어보세요
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 입력 > ");
		String input = sc.nextLine();
		
		if (isPhoneNumber(input)) {
			System.out.println("올바른 핸드폰 번호입니다.");
		} else {
			System.out.println("잘못된 형식의 핸드폰 번호입니다.");
		}
	}
	
	public static boolean isPhoneNumber(String str) {
		if (str.length() != 13) {
			return false;
		}
		
		if (str.charAt(3) != '-' || str.charAt(8) != '-') {
			return false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (i == 3 || i == 8) {
				continue;
			}
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
