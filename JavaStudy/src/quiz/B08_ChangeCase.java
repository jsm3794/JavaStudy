package quiz;

import java.util.Scanner;

public class B08_ChangeCase {

	/*
	 	사용자가 영어로 된 문장을 입력하면 대소문자를
	 	반대로 바꿔서 출력해주는 프로그램을 만들어보세요
	 	
	 	입력> I Like To Try Apple
	 	출력> i lIKE tO tRY aPPLE
	 	
	 	※ 입력에 공백 또는 영어가 아닌 문자가 포함되어 있다면 메세지를 출력
	 	
	 	입력> 한글
	 	출력> 이 프로그램에는 영어와 공백만 입력하실 수 있습니다.
	 */
	
	public static void main(String[] args) {
		
		/*
		 	Scanner sc = new Scanner(System.in);
			System.out.println("입력 > ");
			String text = sc.nextLine();
			int len = text.length();
			
			for (int i = 0; i < len; i++) {
				char ch = text.charAt(i);
				if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
					
				}
			}
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 > ");
		String text = "I Like To Try Apple";
		int len = text.length();
		int diff = Math.abs('A' - 'a');
		
		for (int i = 0; i < len; i++) {
			char ch = text.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				System.out.print((char)ch - 'a' + 'A');
				// System.out.print((char)(ch - diff));
			} else if (ch >= 'A' && ch <= 'Z') {
				System.out.print((char)ch - 'A' + 'a');
				// System.out.print((char)(ch + diff));
			} else {
				System.out.println(ch);
			}
		}

	}

}
