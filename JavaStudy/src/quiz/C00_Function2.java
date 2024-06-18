package quiz;

import java.util.Arrays;
import java.util.Random;

public class C00_Function2 {

	/*
	 	1. 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수
	 	
	 	2. 문자열을 전달하면 해당 문자열을 거꾸로 뒤집은 문자열을 반환하는 함수
	 	
	 	3. 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환하는 함수
	 	
	 	4. 문자열을 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수
	 */
	
	// 1) 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수
	
	// 풀이 1)
	public static int[] getRandomNumbers(int start, int end, int size) {
		int[] arr = new int[size];
		
		int currIndex = 0;
		while (currIndex < size) {
			int num = (int)(Math.random() * (end - start + 1) + start);
			
			boolean repeated = false;
			for (int i = 0; i < currIndex; ++i) {
				if (arr[i] == num) {
					repeated = true;
					break;
				}
			}
			if (!repeated) {
				arr[currIndex++] = num;
			}
		}
		return arr;
		
	}
	
	// 풀이 2)
	public static String shuffle(String text) {
		int len = text.length();
		
		// (1) 문자열 길이를 활용해 중복없는 랜덤 순서 인덱스 배열을 먼저 생성한다
		// ex> 길이가 10일때 0 ~ 9의 중복없는 랜덤 배열을 생성한다
		int[] ranNums = getRandomNumbers(0, len - 1, len);
		
		// (2) 생성된 배열을 활용해 문자열을 섞어서 출력한다
		String shuffled = "";
		
		for (int i = 0; i < ranNums.length; ++i) {
			shuffled += text.charAt(ranNums[i]);
		}
		return shuffled;
	}
	
	/*
	 	내 풀이)
	 	public static char[] shuffleString(String input) {
		 	char[] ch = input.toCharArray();
			int len = input.length();
			Random ran = new Random();
			
			for (int i = 0; i < len; i++) {
				int randomIndex = ran.nextInt(len);
				char temp = ch[i];
				ch[i] = ch[randomIndex];
				ch[randomIndex] = temp;
			}
			return ch;
		}
	 */
	
	// 2) 문자열을 전달하면 해당 문자열을 거꾸로 뒤집은 문자열을 반환하는 함수
	public static String reverseString(String str) {
		
		int len = str.length();
		String result = "";
		for (int i = 0; i < len; i++) {
			result += str.charAt(len - i - 1);
		}
		return result;
	}
	
	// 3) 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환하는 함수
	public static boolean palindrome(String txt) {
		int len = txt.length();
		for (int i = 0; i < len / 2; i++) {
			if (txt.charAt(i) != txt.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	// 4) 문자열을 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수
	public static int[] getLottoNumbers() {
		return getRandomNumbers(1, 45, 7);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(getRandomNumbers(0, 6, 7)));
		System.out.println(shuffle("안녕하세요"));
		// System.out.println(shuffleString("안녕하세요"));
		System.out.println(reverseString("안녕하세요"));
		System.out.println(palindrome("level"));
		System.out.println(palindrome("noon"));
		System.out.println(palindrome("ABBA"));
		System.out.println(palindrome("Abba"));
		System.out.println(Arrays.toString(getLottoNumbers()));

	}

}
