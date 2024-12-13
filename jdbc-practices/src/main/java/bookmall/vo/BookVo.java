package bookmall.vo;

public class BookVo {
	private Integer no;
	private String title;
	private Integer price;
	private Integer categoryNo;

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

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getCategoryNo() {
		return categoryNo;
	}


}
