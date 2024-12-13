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
			String sql = "insert into cart values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. Parameter binding
			pstmt.setInt(2, vo.getQuantity());
			pstmt.setInt(3, getBookPriceById(vo.getBookNo()));
			pstmt.setInt(4, vo.getBookNo());
			pstmt.setInt(5, vo.getUserNo());
			
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
			String sql = "select id, quantity, price, book_id, users_id from cart where users_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt(1);
				Integer quantity = rs.getInt(2);
				Integer price = getBookPriceById(rs.getInt(3));
				Integer book_id = rs.getInt(4);
				Integer users_id = rs.getInt(5);
				
				CartVo vo = new CartVo();
				
				vo.setUserNo(users_id);
				vo.setBookNo(book_id);
				vo.setQuantity(quantity);
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
	
    // 도서 번호를 통해 도서의 가격을 가져오는 메서드
    public Integer getBookPriceById(Integer bookId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer price = null;

        try {
            conn = getConnection();

            // 3. Statement 준비하기
            String sql = "select price from book where id = ?";
            pstmt = conn.prepareStatement(sql);

            // 4. Parameter binding
            pstmt.setInt(1, bookId);

            // 5. SQL 실행 및 결과 처리
            rs = pstmt.executeQuery();
            if (rs.next()) {
                price = rs.getInt(1); // 도서 가격 가져오기
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return price;
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
