import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class E06_Charset {

	/*
	 	# Charset
	 	
	 	- ASCII 코드까지는 모든 Charset이 동일하지만 그 이후부터는 각 회사마다
	 	  각자가 개발한 문자표를 사용한다
	 	- MS949 : 마이크로스프트의 문자표
	 	- EUC-KR : 이클립스가 기본적으로 사용하는 문자표
	 	- UTF-8 : 가장 표준이 되는 문자표로 모든 문자를 포함하고 있어 용량이 크다
	 	- Writer 또는 Reader를 사용할때 어떤 문자표를 사용하여 byte로 변환/복구 할것인지
	 	  설정 할 수 있다
	 */
	
	public static void main(String[] args) {
		// 인스턴스 생성시 문자표를 선택할 수 있는 오버로딩이 있다
		try {
			FileWriter out = new FileWriter("myfiles/encodingTest.txt", 
					Charset.forName("UTF-8"));
			
			// charset : 문자열을 byte로 쪼갤때의 규칙을 정한다
			out.write("한글을 씁니다..\n");
			out.write("한글을 씁니다..\n");
			out.write("한글을 씁니다..\n");
			out.write("한글을 씁니다..\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		FileReader in = null;
		
		try {
			// FileReader를 만들때도 원하는 charset을 설정할 수 있다
			in = new FileReader("myfiles/encodingTest", 
					Charset.forName("EUC-KR"));
			
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.print((char)ch);
			}
		}
	}
}
