package quiz;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05_EmailListFile {

	// D11번 문제에 있는 기자들의 이메일들로만 이루어진 파일을 myfiles 폴더에 생성해보세요
	
	public static void main(String[] args) {
		
		D11_ReporterList2 reporter = new D11_ReporterList2();
		Pattern emailPattern = Pattern.compile("(\\w+@(\\w+\\.)+(\\w+))");
        Matcher matcher = emailPattern.matcher(D11_ReporterList2.reporters);
        
        FileWriter out = null;
        
        try {
			out = new FileWriter("myfiles/emails.txt");
			
			while (matcher.find()) {
				out.write(matcher.group() + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
