package quiz;

import java.util.Scanner;

public class B05_MonthToSeason2 {

	/*
	 	사용자로부터 몇 월인지 입력받으면 해당하는 계절을 출력해보세요
	 	(switch-case문, if문으로 한 번씩 만들기)
	 */
	
	public static void main(String[] args) {
		
		/*
		 	내 풀이)
		 	Scanner sc = new Scanner(System.in);
			String season;
			System.out.println("몇 월인지 입력하세요: ");
			int month = sc.nextInt();
			
			if (month >= 3 && month <= 5) {
				System.out.println("봄 입니다.");
			} else if (month >= 6 && month <= 8) {
				System.out.println("여름 입니다.");
			} else if (month >= 9 && month <= 11) {
				System.out.println("가을 입니다.");
			} else {
				System.out.println("겨울 입니다.");
			}
		 */
		
			System.out.println("월을 입력(숫자): ");
			Scanner sc = new Scanner(System.in);
			int month = sc.nextInt();
			
			String seasonName;
			
			if (month ==3 && month == 4) {
				seasonName = "봄";
			} else if (month >=5 && month <= 8) {
				seasonName = "여름";
			} else if (month ==9 && month == 10) {
				seasonName = "가을";
			} else if (month == 11 || month == 12 || month == 1 || month == 2) {
				seasonName = "겨울";
			} else {
				seasonName = "없는 달";
			}
			System.out.printf("%d월은 %s입니다.\n", month, seasonName);

	}

}
