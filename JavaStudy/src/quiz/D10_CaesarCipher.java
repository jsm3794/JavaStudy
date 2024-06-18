package quiz;

import java.util.Scanner;

public class D10_CaesarCipher {

	/*
	 	# 시저(카이사르) 암호
	 	
	 	- 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 변경하여 암호문을 생성하는
	 	  암호 알고리즘
	 	  
	 	  [암호표]
	 	  
	 	  ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+
	 	  abcdefghijklmnopqrstuvwxyz {}[]|\;:'"/?<>,.
	 	  
	 	  * 암호화
	 	    (평문) 		 key:3		  (암호문)
	 	    HELLO!	  ----------> 	  KHOOR!
	 	    
	 	  * 복호화
	 	    			 key:3
	 	    HELLO!	  ----------> 	  KHOOR!
	 */
	
	// 1. 평문과 키 값이 전달되면 해당 평문을 암호문으로 변환하여 리턴해주는 메서드
	// 2. 암호문과 키 값이 전달되면 해당 암호문을 평문으로 변환하여 리턴해주는 메서드
	// ※ 암호화 수 있는 문자의 종류: 영어 대문자, 영어 소문자, 숫자, 특수문자
	
	public static void main(String[] args) {
		
		String cipherText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+"
				+ "abcdefghijklmnopqrstuvwxyz {}[]|\\;:'\"/?<>,.";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("평문 입력 > ");
		String plainText = sc.nextLine();
		
		System.out.print("키 입력 > ");
		int key = sc.nextInt();
		
		String encrypted = encrypt(plainText, key, cipherText);
		System.out.println("암호문: " + encrypted);
	}
	
	// 암호화
	public static String encrypt(String str, int key, String cipherText) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			int index = cipherText.indexOf(str.charAt(i));
			if (index != -1) {
				int index2 = (index + key) % cipherText.length();
				result.append(cipherText.charAt(index2));
			} else {
				result.append(str.charAt(i));
			}
		}
		return result.toString();
	}
	
	// 복호화
	public static String decrypt(String str, int key, String cipherText) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			int index = cipherText.indexOf(str.charAt(i));
			if (index != -1) {
				int index2 = (index - key) % cipherText.length();
				result.append(cipherText.charAt(index2));
			} else {
				result.append(str.charAt(i));
			}
		}
		return result.toString();
	}
}
