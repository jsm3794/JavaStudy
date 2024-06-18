package quiz;

// import java.util.Arrays;

public class B13_Lotto {

	/*
	 	(1) 1 ~ 45 사이의 중복 없는 랜덤 숫자 7개를 생성하여
		 	로또 당첨 번호를 배열로 만들어 보세요
		 	
		 	1. 숫자를 랜덤으로 뽑는다
		 	2. 이전에 뽑았던 숫자중에 방급 뽑은 숫자가 없는지 확인한다
		 	3. 있으면 다시 뽑고 없으면 넘어간다
		 	
		(2) 1등 또는 2등에 당첨될때까지 랜덤 로또 번호를 계속 생성하여
		    몇 번 만에 당첨되었는지 출력해보세요
		    
		    - 로또 구매자는 번호를 6개 고른다
		    - 보너스 번호를 제외하고 모두 맞추면 1등
		    - 보너스 번호를 포함하여 모두 맞추면 2등
	 */
	
	public static void main(String[] args) {
		
		/*
		 	int[] num = new int[45];
			int len = num.length;
			
			for (int i = 0; i < len; i++) {
				num[i] = i + 1;
			}
			
			// 랜덤으로 섞기
			for (int i = 0; i < 10000; i++) {
				int ran1 = (int)(Math.random() * len);
				int ran2 = (int)(Math.random() * len);
				
				int temp = num[ran1];
				num[ran1] = num[ran2];
				num[ran2] = temp;
			}
			
			int[] lottoNum = new int[7];
			for (int i = 0; i < lottoNum.length; i++) {
				lottoNum[i] = num[i];
				System.out.printf("%d ", lottoNum[i]);
			}
			// System.out.println(Arrays.toString(lottoNum));
		 */
		
		// 1) 1 ~ 45 사이의 중복 없는 랜덤 숫자 7개를 생성하여 로또 당첨 번호를 배열로 만들어 보세요
		int currIndex = 0;
		
		int[] winNums = new int[7];
		
		while (currIndex < 7) {
			int num = (int)(Math.random() * 45 + 1);
			
			boolean repeated = false;
			for (int i = 0; i < currIndex; ++i) {
				if (winNums[i] == num) {
					// 이전에 뽑은 숫자 중에 중복되는 숫자가 있음
					repeated = true;
					break;
				}
			}
			
			// 중복된 숫자가 존재한다면 currIndex가 증가하지 않기 때문에
			// 현재 인덱스에 숫자를 다시 뽑게 된다
			
			if (!repeated) {
				winNums[currIndex] = num;
				++currIndex;	
			}
		}
		
		// 출력
		for (int i = 0; i < winNums.length; ++i) {
			System.out.print(winNums[i] + " ");
		}
		System.out.println();

	}

}
