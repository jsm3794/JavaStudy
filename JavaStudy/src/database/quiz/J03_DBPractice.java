package database.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J03_DBPractice {

	/*
	 	(1) 관리자 계정으로 DB에 새 계정을 추가한다
	 	
	 	(2) 관리자 계정으로 새 계정에 권한을 부여한다
	 	
	 	(3) 해당 계정에 새 테이블을 추가한다
	 		(기본키로 시퀀스를 사용해야 하고, 제약조건을 종류별로 모두 사용해야 한다)
	 		
	 	(4) 프로그램에서 스캐너로 데이터를 입력하면 DB에 행이 추가되어야 한다
	 	
	 	(5) 콘솔에서 여태까지 추가된 모든 행을 조회할 수 있어야 한다
	 */
	
	public static void main(String[] args) {
		
		String driverPath = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "testuser3";
		String password = "1234";
		
		try {
			Class.forName(driverPath);
			System.out.println("드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 못 찾음...");
		}
		
		try (
			Connection conn = DriverManager.getConnection(url, user, password);
		) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("학생의 이름 입력 > ");
			String studentName = sc.nextLine();
			System.out.print("과목 ID 입력 > ");
			int courseId = sc.nextInt();
			
			String sql = "INSERT INTO students (student_id, student_name, course_id) "
					+ "VALUES (?, ?, ?)";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, studentName);
				pstmt.setInt(1, courseId);
				pstmt.executeUpdate();
				System.out.println("새 학생이 추가되었습니다.");
			}
			
			String sql2 = "SELECT * FROM students";
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql2);
				ResultSet rs = pstmt.executeQuery();
			) {
				System.out.println("===== 모든 행 조회 =====");
                while (rs.next()) {
                	int studentId = rs.getInt("student_id");
                    String name = rs.getString("student_name");
                    int course = rs.getInt("course_id");
                    System.out.println("ID: " + studentId + ", 이름: " + name + ", 과목 ID: " + course);
                }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
