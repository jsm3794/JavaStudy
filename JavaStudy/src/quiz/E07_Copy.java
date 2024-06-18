package quiz;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E07_Copy {

	// 폴더의 경로를 전달하면 같은 경로에 폴더 이름2를 만들고
	// 안에 모든 내용을 복사해주는 메서드를 만들어보세요
	
	// ex1> dog 폴더의 경로를 전달하면 안에 있는 모든 강아지 사진이 복사된 dog2 폴더가 생겨야 함
	// ex2> myimage 폴더의 경로를 전달하면 myimage2를 만들고 안에 모든 내용이 복사되어야함
	
	/*
	 	public static void copy(String path) {
			
			// String dest = path + "2"; // 원래 경로에 2를 붙이면 목적지의 경로!
			
			// 원래 경로에 들어있는 파일들의 목록을 꺼낸다!
			String[] files = new File(path).list();
			
			for (String file : files) {
				FileReader in = new FileReader(file);
				FileWriter out = new FileWriter(dest와 file을 적절히 잘 사용한 경로);
				
				// 읽은 후 읽은 내용을 그대로 원하는 위치에 다시 쓰면 복사가 된다
				in으로 읽고
				out으로 쓰면 복사 완료!
			}
		}
	 */
	
	public static void main(String[] args) {
		String[] paths = {"myimage", "myimage/animal/cat", "myimage/animal/dog", 
				"myimage/animal/panda", "myimage/fruit", "myimage/memo/emails.txt"};
		
		for (String path : paths) {
			boolean success = copyDir(path);
			if (success) {
				System.out.println("복사 성공!");
			} else {
				System.out.println("복사 실패!");
			}
		}
	}
	
	public static boolean copyDir(String sourcePath) {
		File sourceDir = new File(sourcePath);
		
		String targetPath = sourcePath + "2";
		File targetDir = new File(targetPath);
		
		if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("잘못된 경로입니다: " + sourcePath);
            return false;
        }
		
		if (!targetDir.exists()) {
			targetDir.mkdir();
			System.out.println("폴더 생성됨: " + targetDir.getAbsolutePath());
		} else {
			 System.out.println("이미 해당 폴더가 있습니다: " + targetDir.getAbsolutePath());
	            return false;
		}
		return copyContents(sourceDir, targetDir);
	}

	private static boolean copyContents(File sourceDir, File targetDir) {
		File[] files = sourceDir.listFiles();
		if (files != null) {
			for (File file : files) {
				File newFile = new File(targetDir, file.getName());
				if (file.isDirectory()) {
					newFile.mkdir();
					if (!copyContents(file, newFile)) {
						return false;
					} else {
						try (FileReader in = new FileReader(file);
							FileWriter out = new FileWriter(newFile)) {
							int ch;
							while ((ch = in.read()) != -1) {
								out.write(ch);
							}
							
							in.close();
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
							return false;
						}
					}
				}
			}
			System.out.println("내용 복사 성공!");
			return true;
		} else {
			System.out.println("복사할 파일이 없음");
			return false;
		}
	}
}
