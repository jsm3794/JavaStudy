package example;
import java.util.Random;
import java.util.Scanner;

public class RandomDice {

	public static void main(String[] args) {
		
		Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("랜덤 주사위 던지기 프로그램을 시작합니다!");
        System.out.println("주사위를 던지려면 아무 키나 입력하세요. 종료하려면 'exit'을 입력하세요.");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int diceRoll = ran.nextInt(6) + 1;
            System.out.println("주사위를 던졌습니다. 나온 숫자: " + diceRoll);
        }

        sc.close();

	}

}
