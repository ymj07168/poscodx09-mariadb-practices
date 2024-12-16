package bookmall.vo;

public class CartVo {
	private int userNo;
	private int quantity;
	private int bookNo;
	private String title;
//	private Integer price;

//	public Integer getPrice() {
//		return price;
//	}
//
//	public void setPrice(Integer price) {
//		this.price = price;
//	}

	public void setUserNo(int no) {
		this.userNo = no;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setBookNo(int no) {
		this.bookNo = no;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object getBookTitle() {
		return title;
	}

}
