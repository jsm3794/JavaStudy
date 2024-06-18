package quiz;

// import java.util.Random;

public class B12_TempPassword {

	/*
	 	알파벳 대문자로만 구성된 랜덤 4자리 비밀번호를 20개 생성하여 출력해보세요
	 */
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i <= 20; i++) {
			
			for (int j = 0; j < 4; j++) {
				System.out.print((char)(Math.random() * 26 + 65));
			}
			System.out.println();
		}
		
		
		for (int i = 0; i <= 20; i++) {
			String password = "";
			for (int j = 0; j < 4; j++) {
				password += (char)(Math.random() * 26 + 25);
			}
			System.out.println(i + "번째 비밀번호: " + password);
		}

	}

}
