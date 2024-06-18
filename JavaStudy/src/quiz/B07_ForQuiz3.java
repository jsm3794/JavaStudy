package quiz;

import java.util.Scanner;

public class B07_ForQuiz3 {

	/*
	 	사용자로부터 숫자를 입력받으면
	 	0부터 해당 숫자 사이에 존재하는 모든 3의 배수를 한줄에 6개씩 출력해보세요
	 	(단, 음수를 입력받는 경우에도 올바르게 동작해야 함)
	 */
	
	public static void main(String[] args) {
		
		/*
		 	Scanner sc = new Scanner(System.in);
			System.out.print("숫자 입력: ");
			int num = sc.nextInt();
			
			if (num > 0) {
				for (int i = 0, cnt = 0; i <= num ; i++) {
					if (i % 3 == 0) {
						System.out.print(i + " ");
						
						if (++cnt % 6 == 0) {
							System.out.println();
						}
					}
					
				}
			} else {
				for (int i = 0, cnt = 0; i >= num ; i--) {
					if (i % 3 == 0) {
						System.out.print(i + " ");
						
						if (--cnt % 6 == 0) {
							System.out.println();
						}
					}
					
				}
			}
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("목표 숫자: ");
		int target = sc.nextInt();
		int absValue = Math.abs(target);
		
		// 풀이 3)
		for (int i = 0, cnt = 0; i <= absValue; ++i) {
			if (i % 3 ==0) {
				if (target < 0) {
					System.out.printf("%+d\t", -i);
				} else {
					System.out.printf("%+d\t", i);
				}
				
				if (++cnt % 6 == 0) {
					System.out.println();
				}
			}
		}
		
		// 풀이 2)
//		for (int i = 0, cnt = 0; i <= Math.abs(target); ++i) {
//			if (i % 3 ==0) {
//				if (target < 0) {
//					System.out.printf("%+d\t", -i);
//				} else {
//					System.out.printf("%+d\t", i);
//				}
//				
//				if (++cnt % 6 == 0) {
//					System.out.println();
//				}
//			}
//		}
		
		// 풀이 1)		
//		if (target > 0) {
//			for (int i = 0, cnt = 0; i <= target; ++i) {
//				if (i % 3 == 0) {
//					// 정수와 문자탕팁을 더하면 문자코드값과 정수값을 더해버린다
//					// 문자타입도 이어붙이기를 하기 위해서는 문자열과의 +가 필요하다
//					System.out.print("" + i + '\t');
//					
//					if (++cnt % 6 == 0) {
//						System.out.println();
//					}
//				}
//			}
//		} else {
//			// target이 음수일 때 도착하는 곳
//			for (int i = 0, cnt = 0; i >= target; --i) {
//				if (i % 3 == 0) {
//					System.out.print("" + i + '\t');
//					
//					if (--cnt % 6 == 0) {
//						System.out.println();
//					}
//				}
//			}
//		}
//		

	}

}
