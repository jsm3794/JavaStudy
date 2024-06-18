package quiz;

public class B10_Gugudan {

	/*
	 	1. 구구단을 다음과 같이 가로로 출력해보세요
	 	
	 	2단: 2x1=2 2x2=4 2x3=6 ...
	 	3단: 3x1=3 3x2=6 ...
	 	4단: ...
	 	
	 	2. 구구단을 다음과 같이 세로로 출력해보세요
	 	
	 	2단		3단		4단		...
	 	2x1=2	3x1=3	4x1=4	...
	 	2x2=4	3x2=6	4x2=8	...
	 */
	
	public static void main(String[] args) {
		
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d단: ", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d\t", i, j, i * j);
				if (j == 9) {
					System.out.println();
				}
			}
		}
		System.out.println();
		System.out.println("========================================================================================================");
		
		
		
		for (int j = 0; j <= 9; j++) {
			System.out.println();
			for (int i = 2; i <= 9; i++) {
				if (j == 0) {
					System.out.print(i + "단:\t\t");
				} else {
					System.out.printf("%d x %d = %d\t", i, j, i * j);
				}
			}
			
		}

	}

}
