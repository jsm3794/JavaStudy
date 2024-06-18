package quiz;

import java.util.Arrays;

public class C00_FunctionQuiz {

	/*
	 	# 다음 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
	 	
	 	1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	 	2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	 	3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	 	4. 숫자를 전달하면 해당 숫자의 모든 약수를 int[]로 반환하는 함수
	 	5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	 	6. 메세지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복하는 함수
	 */
	
	// 1) 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	public static boolean alphabet(char ch) {
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
	}
	
	// 2) 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	public static boolean threeMultiple(int num) {
		return num % 3 == 0;
	}
	
	// 3) 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	public static String evenOdd(int num) {
		// return num % 2 == 0 ? "짝수입니다" : "홀수입니다";
		if (num % 2 == 0) {
			return "짝수입니다";
		} else {
			return "홀수입니다";
		}
	}
	
	// 4) 숫자를 전달하면 해당 숫자의 모든 약수를 int[]로 반환하는 함수
	public static int[] divisorList(int num) {
		/*
		 	내 풀이)
		 	int cnt = 0;
			int[] index = new int[num];
			for (int i = 0; i <= num; i++) {
				if (num % i == 0) {
					index[cnt] = i;
					cnt++;
				}
			}
			
			int arr[] = new int[cnt];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = index[i];
			}
			return arr;
		 */
		
		// 풀이)
		int[] divisorArr = new int[num];
		
		// num : 전달 받은 숫자
		// div : 전달 받은 숫자를 나눠볼 숫자
		int index = 0;
		for (int div = 1; div <= num; ++div) {
			if (num % div == 0) {
				// ++이 뒤에 들어갔으므로 대입을 하고 난 후 index가 증가한다
				divisorArr[index++] = div;
			}
		}
		return Arrays.copyOf(divisorArr, index);
		
	}
	
	// 5) 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	public static boolean prime(int num) {
		return divisorList(num).length == 2;
	}
	
	// 6) 메세지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복하는 함수
	public static void printMessage(String message, int num) {
		for (int i = 0; i < num; i++) {
			System.out.println(message);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(alphabet('X'));
		System.out.println(threeMultiple(27));
		System.out.println(evenOdd(33));
		System.out.println(divisorList(13));
		System.out.println(Arrays.toString(divisorList(13)));
		System.out.println(prime(8));
		printMessage(" /)/)\n(  ..)", 10);

	}

}
