package quiz;

import java.util.Scanner;

public class B03_Square {

	/*
	 	※ 직사각형의 넓이를 계산하고 출력하시오
	 	
	 	[조건]
	 	
	 	> 문자열 변수로 직사각형 이름 입력받기
	 	> 실수형 변수로 가로, 세로 길이 입력받기
	 	> 이름과 넓이 출력하기
	 	  (이름에 쌍따옴표 넣고 넓이는 소수점 2자리까지 출력 printf 활용)
	 	> 넓이가 100초과 500미만이라면 true 출력
	 	
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력: ");
		String name = sc.next();
		
		System.out.println("가로 입력: ");
		double x = sc.nextDouble();
		
		System.out.println("세로 입력: ");
		double y = sc.nextDouble();
		
		double z = x * y;
		// double area = Math.round(x * y * 100) / 100/0;
		
		System.out.printf("\"%s\" 직사각형의 넓이는 %.2f\n", name, z);
		
		System.out.println(100 < z && z < 500);
		
		
		
		

	}

}
