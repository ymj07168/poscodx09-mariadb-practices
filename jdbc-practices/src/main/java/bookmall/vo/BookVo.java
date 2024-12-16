package bookmall.vo;

public class BookVo {
	private int no;
	private String title;
	private int price;
	private int categoryNo;

	public BookVo(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	public void setCategoryNo(int no) {
		this.categoryNo = no;
	}

	public String getTitle() {
		return title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryNo() {
		return categoryNo;
	}


}
