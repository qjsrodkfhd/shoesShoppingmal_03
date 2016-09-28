package shoesShoppingmall_repository;

import java.util.ArrayList;

import shoesShoppingmall_domain.OrderShoes;

public class OrderRepository {

	private static ArrayList<OrderShoes> orders;
	private static int orderNumber;
	
	public OrderRepository(){
		
		orders = new ArrayList<OrderShoes>();
		orderNumber = 0;
		
	}

	public static int getOrderNumber() {
		
		return orderNumber;
		
	}

	public static void setOrderNumber(int orderNumber) {
		
		OrderRepository.orderNumber = orderNumber;
		
	}

	public static void setOrders(ArrayList<OrderShoes> orders) {
		OrderRepository.orders = orders;
	}

	public static ArrayList<OrderShoes> getOrders() {
		
		return orders;
		
	}
	
}
