package quiz;

import java.util.Arrays;

public class B14_Array2Quiz {

	public static void main(String[] args) {
		
		int[][] myArr = {
				new int[5],
				new int[7],
				new int[3],
				new int[10],
				{1, 1, 1, 1}
		};
		
		// 1. myArr의 모든 값을 100 ~ 200 사이의 랜덤 정수로 바꾸기
		
		int ranNum = 0;
		for (int i = 0; i < myArr.length; i++) {
			ranNum += myArr[i].length;
			for (int j = 0; j < myArr[i].length; j++) {
				myArr[i][j] = (int)(Math.random() * 101 + 100);
			}
		}
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.println(Arrays.toString(myArr[i]));
		}
		System.out.println();
		
		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균을 구하기
		
		int total = 0;
		double average;
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				total += myArr[i][j];
			}
		}
		average = (double)total / ranNum;
		System.out.printf("총합: %d, 평균: %.2f\n", total, average);
		System.out.println();
		
		// 3. 각 행(row)의 합을 구해서 출력하기
		
		int[] rowSum = new int[myArr.length];
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				rowSum[i] += myArr[i][j];
			}
		}
		
		for (int i = 0; i < rowSum.length; i++) {
			System.out.printf("%d번째 행의 합: %d\n", i, rowSum[i]);
		}
		System.out.println();
		
		// 4. 각 열(col)의 합을 구해서 출력하기
		
		int maxColumnSize = 0;
		for (int i = 0; i < myArr.length; ++i) {
			maxColumnSize = maxColumnSize < myArr[i].length ?
					myArr[i].length : maxColumnSize;
		}
		
		int[] colSum = new int[maxColumnSize];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				colSum[j] += myArr[i][j];
			}
		}
		
		for (int i = 0; i < colSum.length; ++i) {
			System.out.printf("%d번째 열의 합: %d\n", i, colSum[i]);
		}
		System.out.println();
		
		for (int i = 0; i < myArr.length; ++i) {
			System.out.print("{");
			for (int j = 0; j < myArr[i].length; ++j) {
				System.out.printf("%03d ", myArr[i][j]);
			}
			System.out.println("}");
		}
		
	}

}
