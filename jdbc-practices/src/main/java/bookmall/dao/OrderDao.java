package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {
	
	public Boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "insert into orders values(null, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(1, vo.getUserNo());
			pstmt.setString(2, vo.getNumber());
			pstmt.setInt(3, vo.getPayment());
			pstmt.setString(4, vo.getShipping());
			pstmt.setString(5, vo.getStatus());
			
			
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

	public void insertBook(OrderBookVo mockOrderBookVo01) {
		// TODO Auto-generated method stub
		
	}

	public OrderVo findByNoAndUserNo(long l, Integer no) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderBookVo> findBooksByNoAndUserNo(Integer no, Integer no2) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteBooksByNo(Integer no) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "delete from order_book where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(1, no);
			
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

	public boolean deleteByNo(Integer no) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "delete from orders where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(1, no);
			
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
}
