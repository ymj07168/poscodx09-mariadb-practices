package bookmall.vo;

public class OrderVo {
	private String no;
	private int userNo;
	private int payment;
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
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
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
