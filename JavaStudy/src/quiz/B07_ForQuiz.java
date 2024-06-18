package quiz;

public class B07_ForQuiz {

	/*
	 	1. 1000 ~ 2000 사이의 13의 배수를 모두 출력해보세요
	 	
	 	2. 50부터 100 사이의 모든 숫자의 총합을 구해서 출력해보세요
	 	
	 	3. 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요
	 	
	 	4. 1부터 19까지 모든 숫자의 곱을 구해서 출력해보세요
	 	
	 	5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력해보세요
	 */
	
	public static void main(String[] args) {
		
		// 1) 1000 ~ 2000 사이의 13의 배수를 모두 출력해보세요
		
		/*
		 	for (int i = 1000; i <= 2000; ++i) {
				if (i % 13 == 0) {
					System.out.println("13의 배수: " + i);
				}
			}
		 */
		
		for (int num = 1000; num <= 2000; ++num) {
			if (num % 13 == 0) {
				System.out.printf("%d\n", + num);
			}
		}
		
//		for (int num = 13; num <= 2000; num += 13) {
//			if (num >= 1000) {
//				System.out.printf("%d\n", + num);
//			}
//		}
		
		System.out.println("=======================================================");
		
		// 2) 50부터 100 사이의 모든 숫자의 총합을 구해서 출력해보세요
		
		/*
		 	int total = 0;
			for (int i = 50; i < 101; ++i) {
				total += i;
				if (i < 101) {
					System.out.println(total);
				}
			}
		 */
		
		int total = 0;
		
		for (int i = 50; i <= 100; ++i) {
			total += i;
		}
		System.out.println("총합은 " + total);
		
		System.out.println("=======================================================");
		
		// 3) 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요
		
		/*
		 	for (int i = 1; i <= 1000; ++i) {
				if (i % 10 == 0) {
					System.out.print("[" + i + "]\n");
					if (i % 1000 == 0) {
						System.out.print();
					}
				}
			}
		 */
		
		for (int i = 1, printCount = 0; i <= 1000; ++i) {
			if (i % 10 == 0) {
				System.out.printf("%6d", i);
				
				++printCount; // 10의 배수를 출력한 횟수를 센다
				
				if (printCount % 8 == 0) {
					System.out.println();
				}
			}
		}
		
//		for (int i = 1; i <= 1000; i += 10) {
//		System.out.printf("%6d", i);
//		
//		if (i % 80 == 0) {
//			System.out.println();
//		}
//	}
		
		System.out.println("\n=======================================================");
		
		// 4) 1부터 19까지 모든 숫자의 곱을 구해서 출력해보세요
		
		/*
		 	int total2 = 1;
			
			for (int i = 1; i <= 19; ++i) {
				total2 *= 1;
			}
			System.out.println(total2);
		 */
		
		long total2 = 1;
		
		for (int i = 1; i <= 19; ++i) {
			System.out.printf("%d x %d = %d\n", total2, i, total2 *= i);			
		}
		
		System.out.println("=======================================================");
		
		// 5) 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력해보세요
		
		/*
		 	int n = 0;
			
			for (int i = 8999; i > 4999; --i) {
				if (i % 287 == 0) {
					
				}
			}
		 */
		
		for (int i = 8999, cnt = 0; i >= 4999; --i) {
			if (i % 287 == 0) {
				++cnt;
				
				if (cnt == 5) {
					System.out.printf("[%d번째 287의 배수: %d]\n", cnt, i);
				} else {
					System.out.printf("%d번째 287의 배수: %d\n", cnt, i);
				}
			}
		}
		
		

	}

}
