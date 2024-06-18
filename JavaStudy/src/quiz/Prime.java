package quiz;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("소수 입력: ");
		int num = sc.nextInt();
		
		int i = 2, j = 2;
		boolean prime = true;
		while (i <= num) {
			while (j *j <= i) {
				if (i % j == 0) {
					prime = false;
					break;
				}
				j++;
				
			}
			
			if (prime) {
				System.out.println(i);
			}
			i++;
			
		}
	}
}
