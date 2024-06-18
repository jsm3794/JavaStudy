package quiz;

import java.util.ArrayList;

public class D01_ArrayListQuiz {

	/*
	 	1. 리스트에 1000 ~ 1999 사이의 랜덤 정수를 100개 추가하기
	 	
	 	2. 원본에서 짝수를 모두 제거한 후 원본에 남아있는 값의 개수를 세기
	 	
	 	3. 2번의 결과에서 홀수를 모두 제거한 후 원본에 남아있는 값의 개수를 세기
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		// 랜덤 정수 100개 추가
		for (int i = 0; i < 100; i++) {
			int ranNum = (int)(Math.random() * 1000 + 1000);
			list.add(ranNum);
		}
		System.out.println("랜덤 정수: " + list);
		
		// 짝수 제거
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
				i--;
			}
		}
		System.out.println("짝수를 제거한 후 남아있는 값의 개수: " + list.size());
		
		// 홀수 제거
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 != 0) {
				list.remove(i);
				i--;
			}
		}
		System.out.println("홀수를 제거한 후 남아있는 값의 개수: " + list.size());
		
		
		ArrayList<Integer> origin = new ArrayList<>();
		
		ArrayList<Integer> evenList = new ArrayList<>();
		ArrayList<Integer> oddList = new ArrayList<>();
		
		int len = origin.size();
		for (int i = 0; i < len; ++i) {
			int value;
			switch ((value = origin.get(i)) / 2) {
				case 0:
					evenList.add(value);
					break;
				case 1:
					oddList.add(value);
					break;
			}
		}
		
		System.out.println("짝수 리스트: " + evenList);
		System.out.println("홀수 리스트: " + oddList);
	}
}
