package quiz;

public class B07_ForQuiz2 {

	/*
	 	# for문을 사용해 숫자를 다음과 같이 출력해보세요
	 	
	 	1. 0 3 6 9 12 ... 93 96 99
	 	
	 	2. -35 -28 -21 ... 0 7 14 ... 35
	 	
	 	3. 100 200 300 ... 800 900 1000
	 	
	 	4. 100 99 98 ... 5 4 3 2 1 0
	 	
	 	5. 0 1 2 3 ... 6 7 8 9 0 1 2 3... 7 8 9 ... (30번)
	 	
	 	6. 10 9 8 7 ... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번)
	 	
	 	7. 7 77 777 7777 77777 .... 7777777777
	 */
	
	// for문 내부에서 선언한 변수는 for문의 {}가 끝나면 사라진다
	
	public static void main(String[] args) {
		
		// 1) 0 3 6 9 12 ... 93 96 99
		
		/*
		 	for (int i = 0; i < 100; ++i) {
				if (i % 3 == 0) {
					System.out.printf("%-3d", i);
				}
			}
		 */
		
		for (int i = 0; i <= 99; i += 3) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 2) -35 -28 -21 ... 0 7 14 ... 35
		
		/*
		 	for (int i = -35; i < 36; ++i) {
				if (i % 7 == 0) {
					System.out.printf("%-5d", i);
				}
			}
		 */
		
		for (int i = -35; i <= 35; ++i) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 3) 100 200 300 ... 800 900 1000
		
		/*
		 	for (int i = 100; i < 1001; ++i) {
				if (i % 100 == 0) {
					System.out.printf("%-5d", i);
				}
			}
		 */
		
		for (int i = 100; i <= 1000; i += 100) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 4) 100 99 98 ... 5 4 3 2 1 0
		
		/*
		 	for (int i = 100; i > -1; --i) {
				System.out.printf("%-5d", i);
			}
		 */
		
		for (int i = 100; i >= 0; --i) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 5) 0 1 2 3 ... 6 7 8 9 0 1 2 3... 7 8 9 ... (30번)
		
		/*
		 	for (int i = 0; i < 30; ++i) {
				for (int j = 0; j < 10; ++j) {
					System.out.printf("%-5d", j);
				}
			}
		 */
		
		for (int i = 0; i < 30; ++i) {
			System.out.print(i % 10 + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 6) 10 9 8 7 ... 3 2 1 10 9 8 ... 3 2 1 10 9 ... (30번)
		
		/*
		 	for (int i = 0; i < 30; ++i) {
				for (int j = 10; j > 0; --j) {
					System.out.printf("%-5d", j);
				}
			}
		 */
		
		for (int i = 0; i < 30; ++i) {
			System.out.print(10 - i % 10 + " ");
		}
		
		System.out.println();
		System.out.println("==========================================================");
		
		// 7) 7 77 777 7777 77777 .... 7777777777
		
		/*
		 	String n = "7";
			
	        for (int i = 0; i < 10; ++i) {
	        	if (i == 0) {
	        		System.out.printf("%s ", n);
	        	} else {
	        		n += "7";
	        		System.out.print(n);
	        		System.out.print(" ");
	        	}
	        }
		 */
		
		long num = 7;
		for (int i = 0; i < 10; ++i) {
			System.out.print(num + " ");
			num = num * 10 + 7;
		}
		System.out.println();
		System.out.println("==========================================================");
		
		String numStr = "";
		for (int i = 0; i < 10; ++i) {
			numStr += "7";
			System.out.print(numStr + " ");
		}
		System.out.println();
	}

}
