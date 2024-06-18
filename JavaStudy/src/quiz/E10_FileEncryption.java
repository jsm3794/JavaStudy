package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E10_FileEncryption {

	/*
	 	frankenstein.txt를 시저 암호방식으로 암호화한 새 파일
	 	frankenstein_encrypted.enc를 생성해보세요
	 	
	 	(1) char 단위로 한 글자씩 암호화하는 속도를 측정해보기
	 	
	 	(2) char[] 방식으로 암호화하는 속도를 측정해보기
	 	
	 	(3) Buffered 클래스에 붙여 암호화하는 속도를 측정해보기
	 	
	 	(4) 이미 같은 이름의 결과 파일이 경로에 존재한다면 
	 		파일의 이름 뒤에 (숫자)를 붙여 다음 파일이 생기게 만들기
	 	
	 		frankenstein_encrypted(1).enc
	 		frankenstein_encrypted(2).enc
	 		frankenstein_encrypted(3).enc...
	 */
	
	private static final int SHIFT = 3;
	
	public static void main(String[] args) {
		
		String inputPath = "myfiles/frankenstein.txt";
		String outputPath = generateFilePath("myfiles/frankenstein_encrypted.enc");
		
		fileEncrypt1(inputPath);
		fileEncrypt2(inputPath);
		fileEncrypt3(inputPath);
	}
	
	// 1) char 단위로 한 글자씩 암호화하는 속도를 측정해보기
	public static void fileEncrypt1(String inputPath) {
		String outputPath = generateFilePath("myfiles/frankenstein_encrypted(1).enc");
		
		long start = System.currentTimeMillis();
		try (
			FileReader in = new FileReader(inputPath);
			FileWriter out = new FileWriter(outputPath);
		) {
			int ch;
			while ((ch = in.read()) != -1) {
				out.write(encryptChar((char) ch));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long time1 = end - start;
		System.out.println("char: " + time1 + "ms");
	}

	// 2) char[] 방식으로 암호화하는 속도를 측정해보기
	public static void fileEncrypt2(String inputPath) {
		String outputPath = generateFilePath("myfiles/frankenstein_encrypted(2).enc");
		
		long start = System.currentTimeMillis();
		try (
			FileReader in = new FileReader(inputPath);
			FileWriter out = new FileWriter(outputPath);
		) {
			char[] buff = new char[2048];
			
			int len;
			while ((len = in.read(buff)) != -1) {
				for (int i = 0; i < len; i++) {
					buff[i] = encryptChar(buff[i]);
				}
				out.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long time2 = end - start;
		System.out.println("char[]: " + time2 + "ms");
	}
	
	// 3) Buffered 클래스에 붙여 암호화하는 속도를 측정해보기
	public static void fileEncrypt3(String inputPath) {
		String outputPath = generateFilePath("myfiles/frankenstein_encrypted(3).enc");
		
		long start = System.currentTimeMillis();
		
		try (
			BufferedReader in = new BufferedReader(new FileReader(inputPath));
	        BufferedWriter out = new BufferedWriter(new FileWriter(outputPath));
		) {
			int ch;
			while ((ch = in.read()) != -1) {
				out.write(encryptChar((char) ch));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long time3 = end - start;
		System.out.println("Buffered: " + time3 + "ms");
	}

	private static char encryptChar(char ch) {
		if (Character.isLetter(ch)) {
			char base = Character.isLowerCase(ch) ? 'a' : 'A';
			return (char) ((ch - base + SHIFT) % 26 + base);
		}
		return ch;
	}
	
	private static String generateFilePath(String baseFilePath) {
		File file = new File(baseFilePath);
        if (!file.exists()) {
            return baseFilePath;
        }

        String newPath;
        int count = 1;
        while (true) {
            newPath = baseFilePath.replace(".enc", "(" + count + ").enc");
            file = new File(newPath);
            if (!file.exists()) {
                return newPath;
            }
            count++;
        }
	}
	
	
}
