package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class E09_SaveGame {

	/*
	 	컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	 	프로그램 종료시 여태까지 게임 전적을 파일에 저장해주세요
	 	
	 	프로그램 실행시에는 파일에 저장되어있는 전적 데이터를 읽어 예전 기록이
	 	계속해서 이어지도록 만들어보세요
	 */
	
	private static final String FILE_PATH = "myfiles/game_record.sav";
	private static int win = 0;
	private static int lose = 0;
	private static int draw = 0;
	
	public static void main(String[] args) {
		
		loadRecord();
		playGame();
	}
	
	public static void loadRecord() {
		try (
			FileInputStream fin = new FileInputStream(FILE_PATH);
			DataInputStream din = new DataInputStream(fin);
				) {
			win = din.readInt();
			lose = din.readInt();
			draw = din.readInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveRecord() {
		try (
			FileOutputStream fout = new FileOutputStream(FILE_PATH);
			DataOutputStream dout = new DataOutputStream(fout);
				) {
			dout.writeInt(win);
			dout.writeInt(lose);
			dout.writeInt(draw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void resetRecord() {
		win = 0;
		draw = 0;
		lose = 0;
		saveRecord();
		System.out.println("게임 전적이 초기화되었습니다.");
	}
	
	public static void playGame() {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		String[] options = {"가위", "바위", "보"};
		
		System.out.println("가위바위보 게임 시작 \n"
				+ "(종료하려면 'exit' 입력, 전적 초기화는 'reset' 입력)");
		System.out.println("---------------------------------------------");
		
		while (true) {
			System.out.print("유저 > ");
			String userChoice = sc.nextLine();
			
			if (userChoice.equals("exit")) {
				break;
			}
			
			if (userChoice.equals("reset")) {
				resetRecord();
				continue;
			}
			
			if (!userChoice.equals("가위") && !userChoice.equals("바위") 
					&& !userChoice.equals("보")) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			
			int comChoiceIndex = ran.nextInt(3);
			String comChoice = options[comChoiceIndex];
			System.out.println("컴퓨터 > " + comChoice);
			
			if (userChoice.equals(comChoice)) {
				System.out.println("비겼습니다!");
				System.out.println("--------------------");
				draw++;
			} else if ((userChoice.equals("가위")) && (comChoice.equals("보")) || 
					(userChoice.equals("바위")) && (comChoice.equals("가위")) || 
					(userChoice.equals("보")) && (comChoice.equals("바위"))) {
				System.out.println("이겼습니다!");
				System.out.println("--------------------");
				win++;
			} else {
				System.out.println("졌습니다!");
				System.out.println("--------------------");
				lose++;
			}
			
			saveRecord();
			
			System.out.printf("현재 전적: %d승 %d무 %d패\n", win, draw, lose);
		}
	}
}
