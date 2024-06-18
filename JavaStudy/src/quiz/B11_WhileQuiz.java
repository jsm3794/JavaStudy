package quiz;

public class B11_WhileQuiz {

	/*
	 	while문을 사용하여
	 	
	 	1. 1000 ~ 2000 사이의 13의 배수를 모두 출력해보세요
	 	
	 	2. 50부터 100 사이의 모든 숫자의 총합을 구해서 출력해보세요
	 	
	 	3. 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요
	 	
	 	4. 1부터 19까지 모든 숫자의 곱을 구해서 출력해보세요
	 	
	 	5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력해보세요
	 */
	
	public static void main(String[] args) {
		
		// 1) 1000 ~ 2000 사이의 13의 배수를 모두 출력해보세요
		
		int i = 1000;
		while (i++ <= 2000) {
			if (i % 13 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println("=========================================================");
		
		// 2) 50부터 100 사이의 모든 숫자의 총합을 구해서 출력해보세요
		
		i = 50;
		int total = 0;
		while (i <= 100) {
			total += i;
			++i;
		}
		System.out.println(total);
		
		System.out.println("=========================================================");
		
		// 3) 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요
		
		i = 1;
		while (i++ <= 1000) {
			if (i % 10 == 0) {
				System.out.printf("%6d", i);
				if (i % 80 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println("\n=========================================================");
		
		// 4) 1부터 19까지 모든 숫자의 곱을 구해서 출력해보세요
		
		i = 1;
		long total1 = 1;
		while (i <= 19) {
			total1 *= i;
			++i;
			System.out.println(total1);
		}
		
		System.out.println("\n=========================================================");
		
		// 5) 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력해보세요
		
		i = 8999;
		int cnt = 0;
		while (i-- >= 4999) {
			if (i % 287 == 0) {
				++cnt;
				if (cnt == 5) {
					System.out.printf("[%d번째 287의 배수: %d]\n", cnt, i);
				} else {
					System.out.print("");
				}
			}
		}

	}

}
