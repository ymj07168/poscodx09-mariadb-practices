package bookmall.vo;

public class OrderBookVo {
	private Integer orderNo;
	private Integer bookNo;
	private Integer quantity;
	private Integer price;

	public void setOrderNo(Integer no) {
		this.orderNo = no;
	}

	public void setBookNo(Integer no) {
		this.bookNo = no;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public Integer getOrderNo() {
		return orderNo;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public Object getBookTitle() {
		return null;
	}

}
