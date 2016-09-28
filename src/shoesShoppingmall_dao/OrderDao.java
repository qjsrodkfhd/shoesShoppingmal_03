package shoesShoppingmall_dao;

import java.util.ArrayList;

import shoesShoppingmall_domain.OrderShoes;
import shoesShoppingmall_domain.UpdateOrderShoes;
import shoesShoppingmall_repository.OrderRepository;
import shoesShoppingmall_repository.ShoesRepository;

public class OrderDao {

	public OrderDao() {
		new OrderRepository();
	}

	// 장바구니보기
	public ArrayList<OrderShoes> cartsList() {

		ArrayList<OrderShoes> orders = null;
		orders = OrderRepository.getOrders();

		return orders;

	}

	// 장바구니수정 (수량)
	public boolean updated(UpdateOrderShoes UpdateorderShoes) {

		boolean success = false;

		for (int i = 0; i < OrderRepository.getOrders().size(); i++) {
			if (UpdateorderShoes.getOrderNumber() == OrderRepository.getOrders().get(i).getOrderNumber()) {

				OrderRepository.getOrders().get(i).setOrderCount(UpdateorderShoes.getOrderCount());
				OrderRepository.getOrders().get(i).setOrderNumber(UpdateorderShoes.getOrderNumber());
				success = true;
				break;

			}
		}

		return success;

	}

	// 장바구니담기(상품등록)
	public boolean inputCarts(OrderShoes orderShoes) {

		boolean success = false;

		// 주문번호1증가
		int currentOrderNumber = OrderRepository.getOrderNumber();
		int nextOrderNumber = currentOrderNumber + 1;
		OrderRepository.setOrderNumber(nextOrderNumber);
		orderShoes.setOrderNumber(nextOrderNumber);

		ArrayList<OrderShoes> orderShoesList = OrderRepository.getOrders();
		orderShoesList.add(orderShoes);

		success = true;
		

		return success;

	}

	// 주문상품 장바구니 존재여부 판별 dao(단, 존재한다면 수량만 수정)
	public boolean checkOrderProduct(OrderShoes newOrderShoes) {

		boolean success = false;

		for (int i = 0; i < OrderRepository.getOrders().size(); i++) {
			// 중복체크
			if (newOrderShoes.getProductNumber() == OrderRepository.getOrders().get(i).getProductNumber()) {
				// 중복이 있으면 true;
				success = true;
				break;
			}
		}

		return success;

	}

	public boolean orderCountShoes(OrderShoes newOrderShoes) {

		boolean success = false;

		for (int i = 0; i < OrderRepository.getOrders().size(); i++) {

			OrderRepository.getOrders().get(i)
					.setOrderCount(OrderRepository.getOrders().get(i).getOrderCount() + newOrderShoes.getOrderCount());
			success = true;

		}

		return success;

	}

	// 결제
	public boolean payMent() {

		boolean success = false;

		ArrayList<OrderShoes> orderShoes = new ArrayList<OrderShoes>();
		OrderRepository.setOrders(orderShoes);
		// 결제가 완료되면 0
		OrderRepository.setOrderNumber(0);

		success = true;

		return success;

	}

	// 삭제
	public boolean deleteUpdateShoes(int updateDeleteNumber) {

		boolean success = false;

		for (int i = 0; i < OrderRepository.getOrders().size(); i++) {
			if (updateDeleteNumber == OrderRepository.getOrders().get(i).getOrderNumber()) {

				success = true;
				OrderRepository.getOrders().remove(i);
				break;

			}
		}

		return success;
	}
}
