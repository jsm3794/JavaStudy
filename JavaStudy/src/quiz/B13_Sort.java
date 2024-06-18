package quiz;

import java.util.Arrays;
import java.util.Random;

public class B13_Sort {

	/*
	 	1 ~ 1000 사이의 랜덤 정수 값이 30개 들어있는 배열을 하나 생성한 후
	 	해당 배열의 내용은 작은 값부터 차례대로 저장한 새로운 배열을 만들어 원본과 함께 출력해주세요
	 */
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = new int[30];
		int[] arr2 = new int[30];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(1000) + 1;
			arr2[i] = arr[i];
		}
		
		for (int i = 0; i < arr2.length - 1; i++) {
			for (int j = i + 1; j < arr2.length; j++) {
				if (arr2[i] > arr2[j]) {
					int temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
			}
		}
		
		System.out.println("원본     정렬");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%-8d", arr[i]);
			System.out.printf("%-8d\n", arr2[i]);
		}
		
		/*
		 	1. 제일 작은 수를 찾는다
		 	2. 맨 앞에 넣는다
		 	3. 위의 과정을 숫자 개수 만큼 반복한다
		 */
		
		int[] numbers = new int[30];
        int[] sorted = new int[30];

        // 랜덤 정수 값으로 배열 초기화
        for (int i = 0; i < numbers.length; i++) {
        	numbers[i] = (int) (Math.random() * 1000) + 1;
        }

        // 복사
        System.arraycopy(numbers, 0, sorted, 0, numbers.length);

        // 정렬
        Arrays.sort(sorted);

        // 정렬된 배열과 원본 배열 출력
        System.out.println("원본 배열: " + Arrays.toString(numbers));
        System.out.println("정렬된 배열: " + Arrays.toString(sorted));

		
		/*
		 	1. 맨 앞의 값을 계쏙 교환하며 제일 큰 값을 맨 뒤로 보낸다
		 	2. 위의 과정을 반복한다
		 */
		
		// Arrays.copyOf(원본배열, 길이) : 전달한 원본 배열의 복사본을 반환한다
		int[] sorted2 = Arrays.copyOf(numbers, numbers.length);
		
		for (int i = 0; i < sorted2.length -1; ++i) {
			for (int j = 0; j < sorted2.length - 1 - i; ++j) {
				int a = j;
				int b = j + 1;
				if (sorted2[a] > sorted2[b]) {
					int temp = sorted2[a];
					sorted2[a] = sorted2[b];
					sorted2[b] = temp;
				}
			}
			System.out.printf("%d번쨰 정렬 후: %s\n", i, Arrays.toString(sorted2));
		}

	}

}
