package shoesShoppingmall_domain;

public class OrderShoes {
	
	private int orderNumber; //주문번호, 시스템에 의해 자동으로 1씩 증가
	private int productNumber; //주문한 제품번호
	private int orderCount; //수량
	
	public OrderShoes(){
		
		
	}

	public OrderShoes(int productNumber, int orderCount) {
		
		this.productNumber = productNumber;
		this.orderCount = orderCount;
		
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getOrderNumber() {
		
		return orderNumber;
		
	}

	public void setOrderNumber(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}

	public int getProductNumber() {
		
		return productNumber;
		
	}

	public void setProductNumber(int productNumber) {
		
		this.productNumber = productNumber;
		
	}

	public int getOrderCount() {
		
		return orderCount;
		
	}

}
