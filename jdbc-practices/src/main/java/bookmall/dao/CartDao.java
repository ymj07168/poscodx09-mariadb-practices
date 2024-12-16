package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.UserVo;

public class CartDao {

	public Boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(1, vo.getQuantity());
			pstmt.setInt(2, vo.getBookNo());
			pstmt.setInt(3, vo.getUserNo());
			
			// 5. SQL 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public List<CartVo> findByUserNo(Integer no) {
		
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "select quantity, title, book_id, users_id from cart join book on book.id = cart.book_id where users_id = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Integer quantity = rs.getInt(1);
				String title = rs.getString(2);
				Integer book_id = rs.getInt(3);
				Integer users_id = rs.getInt(4);
				
				CartVo vo = new CartVo();
				
				vo.setUserNo(users_id);
				vo.setBookNo(book_id);
				vo.setTitle(title);
				vo.setQuantity(quantity);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean deleteByUserNoAndBookNo(Integer userNo, Integer bookNo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "delete from cart where users_id = ? and book_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bookNo);
			
			// 5. SQL 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.5:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;
	}

}
