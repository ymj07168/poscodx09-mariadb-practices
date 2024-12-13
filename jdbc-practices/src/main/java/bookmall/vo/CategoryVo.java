package bookmall.vo;

public class CategoryVo {
	private Integer no;
	private String category;

	public CategoryVo(String category) {
		this.category = category;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
    @Override
    public String toString() {
        return "CategoryVo [no=" + no + ", category=" + category + "]";
    }

}
