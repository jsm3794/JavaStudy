package quiz;

import java.util.Scanner;

public class B09_Numeric {

	/*
	 	사용자가 입력한 문자열이 모두 숫자로만 구성된 문자열인지
	 	판별해 주는 프로그램을 만들어보세요
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 > ");
		String text = sc.nextLine();
		int len = text.length();
		boolean allDigits = true;
		
		for (int i = 0; i < len; i++) {
			
			char ch = text.charAt(i);
			
			if (ch < '0' || ch > '9') {
				allDigits = false;
				break;
			}
		}
		
		if (allDigits) {
			System.out.print("입력한 문자열은 모두 숫자로만 구성되어 있습니다.");
		} else {
			System.out.print("입력한 문자열에 숫자 이외의 문자가 포함되어 있습니다.");
		}

	}

}
