package quiz;

import java.util.HashMap;

public class D08_CountFruits {

	// 크기 1000의 String[]을 만들고 다음의 과일들을 무작위로 추가한 후
	// 해당 배열 내부에 각 과일이 몇 개씩 들어있는지 세어서 출력해주세요
	final public static String[] FRUITS = 
		{"Apple", "Banana", "Orange", "Mango", "Kiwi", "Pineapple", 
				"Peach", "Watermelon", "Grape"};
	
	public static void main(String[] args) {
		
		String[] fruitsArr = new String[1000];
		
		for (int i = 0; i < fruitsArr.length; i++) {
			int ranIndex = (int)(Math.random() * FRUITS.length);
			fruitsArr[i] = FRUITS[ranIndex];
		}
		
		HashMap<String, Integer> fruits = new HashMap<>();
		
		for (String fruit : fruitsArr) {
			fruits.putIfAbsent(fruit, 0);
			fruits.put(fruit, fruits.get(fruit) + 1);
		}
		
		for (String fruit : fruits.keySet()) {
			System.out.println(fruit + ": " + fruits.get(fruit) + "개");
		}
		System.out.println("------------------------------------");
		
		for (String fruit : fruitsArr) {
			Integer value = fruits.get(fruit);
			if (value == null) {
				fruits.put(fruit, 1);
			} else {
				fruits.put(fruit, value + 1);
			}
		}
		
		for (String fruit : FRUITS) {
			Integer count = fruits.get(fruit);
			if (count != null) {
				System.out.println(fruit + ": " + count + "개");
			}
		}
	}
}
