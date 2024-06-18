package quiz;

import java.util.Scanner;

public class B00_AgeCalculator {

	/*
	 	이름과 태어난 년도를 입력하면 이름과 나이를 출력해주는 프로그램을 만들어보세요
	 	
	 	ex) 김동우 1997
	 	    김동우(28세)
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름과 년도를 입력 > ");
		String name = sc.next();
		int birthYear = sc.nextInt();
		int currentYear = 2024;
		
		int age = (currentYear - birthYear);
		
		System.out.printf("%s(%d세)\n", name, age);

	}

}
