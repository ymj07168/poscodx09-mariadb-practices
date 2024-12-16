package bookmall.vo;

public class OrderBookVo {
	private long orderNo;
	private int bookNo;
	private int quantity;
	private int price;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOrderNo(long no) {
		this.orderNo = no;
	}

	public void setBookNo(int no) {
		this.bookNo = no;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public long getOrderNo() {
		return orderNo;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public Object getBookTitle() {
		return this.title;
	}

}
