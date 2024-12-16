package bookmall.vo;

public class OrderVo {
	private String no;
	private Integer userNo;
	private Integer payment;
	private String shipping;
	private String status;
	
	
	public String getNo() {
		return no;
	}
	public String getNumber() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



}
