package shoesShoppingmall_domain;

public class UpdateOrderShoes {

	private int orderNumber;
	private int orderCount;
	
	public UpdateOrderShoes() {
	
	}

	public UpdateOrderShoes(int orderNumber, int orderCount) {
		
		this.orderNumber = orderNumber;
		this.orderCount = orderCount;
		
	}

	public int getOrderNumber() {
		
		return orderNumber;
		
	}

	public void setOrderNumber(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}

	public int getOrderCount() {
		
		return orderCount;
		
	}

	public void setOrderCount(int orderCount) {
		
		this.orderCount = orderCount;
		
	}
	
}
