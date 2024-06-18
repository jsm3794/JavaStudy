package quiz;

import java.util.Scanner;

public class B00_AgeCalc {

	// 답안
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름과 년도를 입력 > ");
		String name = sc.next();
		int bornYear = sc.nextInt();
		int thisYear = 2024;
		
		// 올해 - 태어난해 + 1 = 한국 나이
		int age = thisYear - bornYear + 1;
		
		System.out.printf("%s(%d세)\n", name, age);
		
	}
}
