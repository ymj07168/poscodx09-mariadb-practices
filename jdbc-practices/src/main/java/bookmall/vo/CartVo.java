package bookmall.vo;

public class CartVo {
	private Integer userNo;
	private Integer quantity;
	private Integer bookNo;
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setUserNo(int no) {
		this.userNo = no;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setBookNo(int no) {
		this.bookNo = no;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public Object getBookTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
