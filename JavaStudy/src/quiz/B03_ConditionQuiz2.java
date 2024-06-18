package quiz;

// import java.util.Scanner;

public class B03_ConditionQuiz2 {

	/*
	 	# 알맞은 조건식을 만들어보세요
	 	
	 	1. char형 변수 a가 'q'또는 'Q'일 때 true
	 	2. char형 변수 b가 공백이나 탭이 아닐 때 true
	 	3. char형 변수 c가 '0' ~ '9'일 때 true
	 	4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
	 	5. char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
	 	6. 사용자가 입력한 문자열이 quit일 때 true
	 */
	
	public static void main(String[] args) {
		
		// 1) char형 변수 a가 'q'또는 'Q'일 때 true
		
			char a = 'q';
			System.out.println(a == 'q' || a == 'Q');
			
		// 2) char형 변수 b가 공백이나 탭이 아닐 때 true
			
			char b = ' ';
			System.out.println(b != ' ' && b != '\t');
			System.out.println(!(b == ' ' || b == '\t'));
			
		// 3) char형 변수 c가 '0' ~ '9'일 때 true
			
			char c = '3';
			System.out.println('0' <= c && c <= '9');
			
		// 4) char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
			
			char d = 'x';
			System.out.println(d == 'X' || d == 'x');
			char d1 = '이';
			System.out.println(d1 >= 'a' && d1 <= 'z' || d1 >= 'A' && d1 <= 'Z');
			
		// 5) char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
			
			char e = '차';
			System.out.println(e >= 0xAC00 && e <= 0xD7A3);
			System.out.println(e >= '가' && e <= '힣');
			
		// 6) 사용자가 입력한 문자열이 quit일 때 true
			
			/*
			 	System.out.println("입력 > ");
				String s = new Scanner(System.in).next();
				System.out.println(s.equals("quit"));
			 */
			
			java.util.Scanner sc = new java.util.Scanner(System.in);
			
			System.out.println("input command > ");
			String cmd = sc.next();
			
			// 문자열 비교는 ==으로 하면 안된다
			System.out.println(cmd == "quit");
			
			// 문자열 비교는 equals()
			System.out.println(cmd.equals("quit")
					|| cmd.equals("QUIT") || cmd.equals("Quit")
					|| cmd.equals("quiT"));
			
			// 대소문자 상관없이 같은 문자열인지 비교
			System.out.println(cmd.equalsIgnoreCase("quit"));

	}

}
