package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class J03_ExecuteUpdate {

	// SELECT문에는 exectueQuery() 메서드를 사용하고
	// INSERT, UPDATE, DELETE문에는 executeUpdate() 메서드를 사용한다
	
	public static void main(String[] args) {
		try (
			Connection conn = DBConnector.getConnection();
		) {
			String sql1 = "INSERT INTO fruits VALUES(?, ?, ?)";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql1);
			) {
				pstmt.setString(1, "포도");
				pstmt.setInt(2, 3300);
				pstmt.setInt(3, 10);
				
				// executeUpdate()는 몇 행이 변경되었는지를 int값으로 반환해준다
				int row = pstmt.executeUpdate();
				System.out.printf("%d행이 성공적으로 추가되었습니다.\n", row);
			}
			
			String sql2 = "UPDATE fruits SET qty + 1 WHERE rownum = 1";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql2);
			) {
				int row = pstmt.executeUpdate();
				System.out.printf("%d행이 수정되었습니다.\n", row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
