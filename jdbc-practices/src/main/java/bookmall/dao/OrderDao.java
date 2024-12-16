package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
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
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// 4. Parameter binding
			pstmt.setString(1, vo.getNumber());
			pstmt.setString(2, vo.getStatus());
			pstmt.setInt(3, vo.getPayment());
			pstmt.setString(4, vo.getShipping());
			pstmt.setInt(5, vo.getUserNo());
			
			
			// 5. SQL 실행
			int count = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                vo.setNo(rs.getLong(1));
            }
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

	public boolean insertBook(OrderBookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "insert into orders_book values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// 4. Parameter binding
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setLong(2, vo.getOrderNo());
			pstmt.setInt(3, vo.getQuantity());
			pstmt.setInt(4, vo.getPrice());
			
			
			// 5. SQL 실행
			int count = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                vo.setBookNo(rs.getInt(1));
                vo.setOrderNo(rs.getInt(2));
            }
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

	public OrderVo findByNoAndUserNo(Long orderNo, Integer userNo) {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "select * from orders where no = ? and users_id = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderNo.toString());
			pstmt.setInt(2, userNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long no = rs.getLong(1);
				String number = rs.getString(2);
				String status = rs.getString(3);
				Integer payment = rs.getInt(4);
				String shipping = rs.getString(5);
				Integer users_id = rs.getInt(6);
				
				OrderVo vo = new OrderVo();
				
				vo.setNo(no);
				vo.setNumber(number);
				vo.setStatus(status);
				vo.setPayment(payment);
				vo.setShipping(shipping);
				vo.setUserNo(users_id);
				
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
		
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
//	public OrderVo findByNoAndUserNo(String orderNo, Integer userNo) {
//		List<OrderVo> result = new ArrayList<>();
//		Connection conn = null;
//		PreparedStatement pstmt =  null;
//		ResultSet rs = null;
//		
//		try {
//			conn = getConnection();
//			
//			// 3. Statement 준비하기
//			String sql = "select * from orders where no = ? and users_id = ?;";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, orderNo);
//			pstmt.setInt(2, userNo);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Long no = rs.getLong(1);
//				String status = rs.getString(2);
//				Integer payment = rs.getInt(3);
//				String shipping = rs.getString(4);
//				Integer users_id = rs.getInt(5);
//				
//				OrderVo vo = new OrderVo();
//				
//				vo.setNo(no);
//				vo.setStatus(status);
//				vo.setPayment(payment);
//				vo.setShipping(shipping);
//				vo.setUserNo(users_id);
//				
//				result.add(vo);
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("error: " + e);
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if (result.size() > 0) {
//			return result.get(0);
//		}
//		return null;
//	}

	public List<OrderBookVo> findBooksByNoAndUserNo(Long orderNo, Integer userNo) {
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "select quantity, title, book_id, orders_no, ob.price from orders_book ob join book b on b.id = ob.book_id;";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int quantity = rs.getInt(1);
				String title = rs.getString(2);
				int book_id = rs.getInt(3);
				long orders_no = rs.getInt(4);
				int price = rs.getInt(5);
				
				OrderBookVo vo = new OrderBookVo();
				
				vo.setBookNo(book_id);
				vo.setTitle(title);
				vo.setQuantity(quantity);
				vo.setOrderNo(orders_no);
				vo.setPrice(price);
				
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

	public boolean deleteBooksByNo(Long orderNo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "delete from orders_book where orders_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setLong(1, orderNo);
			
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

	public boolean deleteByNo(Long orderNo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		try {
			
			conn = getConnection();
			
			// 3. Statement 준비하기
			String sql = "delete from orders where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setLong(1, orderNo);
			
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
