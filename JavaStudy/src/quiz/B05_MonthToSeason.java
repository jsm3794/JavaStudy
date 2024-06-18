package quiz;

import java.util.Scanner;

public class B05_MonthToSeason {

	/*
	 	사용자로부터 몇 월인지 입력받으면 해당하는 계절을 출력해보세요
	 	(switch-case문, if문으로 한 번씩 만들기)
	 */
	
	public static void main(String[] args) {
		
		/*
		 	내 풀이)
		 	Scanner sc = new Scanner(System.in);
			System.out.println("몇 월인지 입력하세요: ");
			int month = sc.nextInt();
			
			switch (month) {
				case 3:
				case 4:
				case 5:
					System.out.println("봄 입니다.");
					break;
					
				case 6:
				case 7:
				case 8:
					System.out.println("여름 입니다.");
					break;
				
				case 9:
				case 10:
				case 11:
					System.out.println("가을 입니다.");
					break;
					
				case 12:
				case 1:
				case 2:
					System.out.println("겨울 입니다.");
					break;
				
			}
		 */
		
		/*
		 	답안 1)
		 	System.out.print("월을 입력(숫자): ");
			// int month = new Scanner(System.in).nextInt();
			Scanner sc = new Scanner(System.in);
			int month = sc.nextInt();
			
			String seasonName;
			
			switch (month) {
				default:
					seasonName = "없는 달";
					break;
				case 11: case 12: case 1: case 2:
					seasonName = "겨울";
					break;
				case 3: case 4:
					seasonName = "봄";
					break;
				case 5: case 6: case 7: case 8:
					seasonName = "여름";
					break;
				case 9: case 10:
					seasonName = "가을";
					break;
				}
				System.out.printf("%d월은 %s입니다.\n", month, seasonName);
		 */
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("월을 입력(영어): ");
			
			String seasonName;
			
			String monthName = sc.next();
			monthName = monthName.toLowerCase();
			
			// "문자열".toLowerCase() : 어떤 문자열을 모두 소문자로 바꿔준다
			// monthName = month.toLowerCase();
			
			// 비교시 소문자 또는 대문자로 통일한 후에 비교하면
			// 대소문자 상관없이 비교가 가능하다
			
			switch (monthName) {
				case "sep": case "oct":
					seasonName = "Autumn";
					break;
				case "nov": case "dec": case "jan": case "feb":
					seasonName = "Winter";
					break;
				case "mar": case "apr":
					seasonName = "Spring";
					break;
				case "may": case "jun": case "jul": case "aug":
					seasonName = "Summer";
					break;
				default:
					seasonName = "Invalid month";
					break;
			}
			System.out.printf("'%s' is '%s' in Korea\n",
					monthName.toUpperCase(), seasonName);
			
			// 문자열(뿐만 아니라 대문자로 시작하는 모든 타입들) 비교시에는 equals()
			if (monthName.equals("Jan")) {
				
			}

	}

}
