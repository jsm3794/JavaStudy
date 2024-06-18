package quiz;

import java.util.Random;

public class B13_RandomScores {

	/*
	 	1. 100개의 점수를 랜덤으로 생성하여 배열에 저장
	 	   (점수는 0 ~ 100점)
	 	   
	 	2. 배열에 저장된 값을 한 줄에 10개씩 출력
	 	   (단, 60점 미만인 점수는 X로 표시)
	 	   
	 	3. 모든 점수의 평균 점수를 출력 (소수 둘쨰 자리까지 출력)
	 	
	 	4. 생성된 랜덤 점수 중 가장 높은 점수와 가장 낮은 점수를 출력
	 	
	 	※ 모든 과정을 하나의 반복으로 처리하는 것은 금지
	 */
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] scores = new int[100];
		int len = scores.length;
		
		// 1) 100개의 점수를 랜덤으로 생성하여 배열에 저장
		
		for (int i = 0; i < len; i++) {
			scores[i] = ran.nextInt(101);
			// System.out.print(scores[i] + "점\t");
		}
		System.out.println();
		
		// 2) 배열에 저장된 값을 한 줄에 10개씩 출력
		
		for (int i = 0; i < len; i++) {
			
			if (scores[i] < 60) {
				System.out.printf("%-6c", 'X');
			} else {
				System.out.printf("%-6d", scores[i]);
			}
			if ((i + 1) % 10 == 0) {
				System.out.println();
				System.out.println();
			}
		}
		
		// 3) 모든 점수의 평균 점수를 출력 (소수 둘쨰 자리까지 출력)
		
		int total = 0;
		double average;
		
		for (int i = 0; i < len; i++) {
			total += scores[i];
		}
		average = (double)total / len;
		System.out.printf("총 점수: %d\n평균 점수: %.2f점", total, average);
		System.out.println();
		
		// 4) 생성된 랜덤 점수 중 가장 높은 점수와 가장 낮은 점수를 출력
		
		int maxScore = 0, minScore = 100;
		
		// # 삼항연산자
		// - 조건 ? 예 : 아니요;
		// - ? 앞의 조건이 참일때는 :의 왼쪽값을 선택
		// - ? 앞의 조건이 거짓일때는 :의 오른쪽값을 선택
		for (int i = 0; i < len; i++) {
			maxScore = maxScore > scores[i] ? maxScore : scores[i];
			minScore = minScore < scores[i] ? minScore : scores[i];
			
			// maxScore = Math.max(maxScore, i);
			// minScore = Math.min(minScore, i);
			
			// 현재 최고값과 i번째 값을 비교해서 i번째 값이 더 크면
			// 최고값으로 변경한다
//			if (scores[i] > maxScore) {
//				maxScore = scores[i];
//			}
//			
//			if (scores[i] < minScore) {
//				minScore = scores[i];
//			}
		}
		System.out.printf("가장 높은 점수: %d점\n가장 낮은 점수: %d점", maxScore, minScore);

	}

}
