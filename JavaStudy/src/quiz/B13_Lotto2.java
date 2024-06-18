package quiz;

public class B13_Lotto2 {

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

		int currIndex = 0;
		int[] winNums = new int[7];
		int bonusNum = 0;
		int attempts = 0;
		
		 // 1 ~ 45 사이의 중복 없는 로또 당첨 번호 생성
		while (currIndex < 7) {
			int num = (int) (Math.random() * 45 + 1);

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
		
		// 보너스 번호 생성
		bonusNum = (int) (Math.random() * 45 + 1);
		
		// 1등 또는 2등에 당첨될 때까지 반복
		while (true) {

			int[] userNums = new int[6];
			currIndex = 0;
			while (currIndex < 6) {
				int num = (int) (Math.random() * 45 + 1);

				boolean repeated = false;
				for (int i = 0; i < currIndex; ++i) {
					if (userNums[i] == num) {
						repeated = true;
						break;
					}
				}

				if (!repeated) {
					userNums[currIndex] = num;
					++currIndex;
				}
			}

			// 당첨 여부 확인
			int matchingNums = 0;
			boolean bonusMatch = false;
			for (int i = 0; i < userNums.length; i++) {
				for (int j = 0; j < winNums.length; j++) {
					if (userNums[i] == winNums[j]) {
						++matchingNums;
						break;
					}
				}
			}

			// 보너스 번호 확인
			for (int i = 0; i < userNums.length; i++) {
				if (userNums[i] == bonusNum) {
					bonusMatch = true;
					break;
				}
			}
			
			// 당첨 번호 출력
			System.out.print("로또 번호: ");
			for (int i = 0; i < userNums.length; ++i) {
				System.out.print(userNums[i] + " ");
			}
			System.out.println();

			System.out.print("당첨 번호: ");
			for (int i = 0; i < winNums.length; ++i) {
				System.out.print(winNums[i] + " ");
			}
			System.out.println("보너스 번호: " + bonusNum);
			
			// 당첨 여부 확인 후 출력
			if (matchingNums == 6 && !bonusMatch) {
				System.out.println("1등 당첨!");
				break;
			} else if (matchingNums == 6 && bonusMatch) {
				System.out.println("2등 당첨!");
				break;
			}

			++attempts;

		}
		System.out.println(attempts + "번 만에 당첨되었습니다");

	}

}
