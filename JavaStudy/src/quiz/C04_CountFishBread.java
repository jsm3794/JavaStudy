package quiz;

import java.util.Arrays;

import myobj.Fbread;

public class C04_CountFishBread {

	public static void main(String[] args) {
		
		// 붕어빵 100개 만들기
		Fbread[] breads = new Fbread[100];
		
		for(int i = 0; i < breads.length; ++i) {
			breads[i] = new Fbread();
		}
		
		// 붕어빵 맛 개수 세기
		int[] flavorCount = new int[Fbread.kindOfFlavors];
		
		for(int i = 0; i < breads.length; ++i) {
			flavorCount[breads[i].flavor] += 1;
		}
		
		System.out.println(Arrays.toString(flavorCount));
		System.out.println("총 가격: FbreadsgetTotalPrice(breads)");
	}

}
