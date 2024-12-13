package bookshop.example;

public class Book {

	private int no;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int i, String string, String string2) {
		this.no = i;
		this.title = string;
		this.author = string2;
		this.stateCode = 1;
	}
	
	
	
	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getStateCode() {
		return stateCode;
	}



	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}



	public void rent() {
		this.stateCode = 0;
		System.out.println(title+"이(가) 대여됐습니다.");
	}
	
	public void print() {
		System.out.println("책 제목:"+ title + ", 작가:" + author + ", 대여유무:"+ (stateCode == 1 ? "재고있음" : "대여중"));
	}

}
