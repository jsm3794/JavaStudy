package quiz;

public class B12_TempPassword2 {

	// 대문자, 소문자, 특수문자, 숫자로 구성된
	// 6자리 랜덤 비밀번호르 20개 생성하여 출력하는 프로그램을 만들어보세요

	// ※ 비밀번호로 사용 가능한 특수문자의 아스키코드 범위 33 ~ 47

	public static void main(String[] args) {

//		for (int i = 0; i <= 20; i++) {
//
//			for (int j = 0; j < 6; j++) {
//				char up = (char) ((Math.random() * 26) + 'A');
//				char low = (char) ((Math.random() * 26) + 'a');
//				char special = (char) ((Math.random() * 15) + '!');
//				int num = (int) (Math.random() * 10);
//				
//				int ran = (int)(Math.random() * 4);
//				
//				if (ran == 0) {
//					System.out.print(up);
//				} else if (ran == 1) {
//					System.out.print(low);
//				} else if (ran == 2) {
//					System.out.print(special);
//				} else if (ran == 3) {
//					System.out.print(num);
//				}
//				
//			}
//			System.out.println();
//
//		}
		
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"  + 
		"0123456789!\"#$%&'()*+,-./";
		
		for (int i = 0; i < 20; ++i) {
			String password = "";
			
			for ( int keyLen = 0; keyLen < 6; ++keyLen) {
				int randomIndex = (int)(Math.random() * charset.length());
				password += charset.charAt(randomIndex);
			}
			System.out.println(password);
		}

	}

}
