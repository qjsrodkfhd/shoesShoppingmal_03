package shoesShoppingmall_Controllers;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_dao.OrderDao;
import shoesShoppingmall_domain.OrderShoes;
import shoesShoppingmall_domain.Shoes;
import shoesShoppingmall_domain.UpdateOrderShoes;
import shoesShoppingmall_view.AlertView;
import shoesShoppingmall_view_carts.CartsListView;
import shoesShoppingmall_view_carts.DeleteUpdateShoesView;
import shoesShoppingmall_view_carts.RegisterShoesCartsView;
import shoesShoppingmall_view_carts.ShowOrderMenuView;
import shoesShoppingmall_view_carts.UpdateCartsView;
import shoesShoppingmall_view_shoes.RegisterShoesView;

public class OrderController {

	private OrderDao orderDao;
	private Scanner keyboard;

	public OrderController() {
		orderDao = new OrderDao();
		keyboard = new Scanner(System.in);

	}

	// 장바구니에 담기 뷰 불러오기
	public void requestInputCarts() {

		RegisterShoesCartsView inputCart = new RegisterShoesCartsView();
		inputCart.inputCarts();

	}

	// 장바구니에 담기
	public void requestInputCarts2(OrderShoes newOrderShoes) {

		boolean success = false;
		AlertView alertView = new AlertView();

		// 동일한 상품 판별
		success = orderDao.checkOrderProduct(newOrderShoes);

		if (success) {

			alertView.alert("중복된 상품이 있습니다, 수량만 수정합니다.");
			//수량 증가하는 dao
			success = orderDao.orderCountShoes(newOrderShoes);
			if(success){
				
				alertView.alert("장바구니 수정 완료");
				
			} else{
				
				alertView.alert("장바구니 수정 실패");
				
			}
			requestCartsList();

		} else {

			alertView.alert("중복없음");
			//장바구니에 상품을 add
			
			success = orderDao.inputCarts(newOrderShoes);

			if (success) {

				alertView.alert("장바구니에 상품이 넣어 졌습니다.");
				requestCartsList();

			} else {

				alertView.alert("장바구니에 상품 넣기가 실패하였습니다.");
				requestInputCarts();
			}
			
			
//			Controllers.getOrderController().requestShowOrderMenu();

		}
		
	}

	// 장바구니 보기
	public void requestCartsList() {

		// 주문 내역
		ArrayList<OrderShoes> cartsList = orderDao.cartsList();

		// 모든 상품 정보
		ShoesController shoesController = Controllers.getShoesController();
		ArrayList<Shoes> shoesList = shoesController.shoesList();

		// 주문 내역 표시
		CartsListView cartsList2 = new CartsListView(cartsList, shoesList);
		cartsList2.CartsList();

	}

	// 장바구니 수정 뷰 불러오기
	public void requestUpdateCarts() {

		// 주문상품 수량을 입력하는 부분 화면에서 주문번호, 수량을 가져온다.
		UpdateCartsView updateCartsView = new UpdateCartsView();
		updateCartsView.UpdateCats();

	}

	// 장바구니 수정
	public boolean requestUpdateCarts2(UpdateOrderShoes updateOrderShoes) {

		boolean success = orderDao.updated(updateOrderShoes);

		AlertView alertView = new AlertView();

		if (success) {

			alertView.alert(" 주문번호 : " + updateOrderShoes.getOrderNumber() + "에 해당하는 주문상품의 수량이 수정되었습니다. ");
			requestCartsList();

		} else {

			alertView.alert("찾으시는 제품이 없습니다.");
			requestCartsList();

		}

		return success;

	}

	// 결제
	public void requestPayMent() {

		boolean success = orderDao.payMent();
		AlertView alrtView = new AlertView();

		if (success) {

			alrtView.alert("결제를 성공하였습니다.");
			requestShowOrderMenu();

		} else {

			alrtView.alert("결제가 실패하였습니다.");
			requestShowOrderMenu();

		}
	}

	// 주문 삭제 뷰 불러오기
	public void requestDeleteShoes() {

		DeleteUpdateShoesView deleteUpdateView = new DeleteUpdateShoesView();

		deleteUpdateView.deleteUpdateShoes();

	}

	// 주문삭제
	public void requestDeleteShoes2(int updateDeleteNumber) {

		boolean success = orderDao.deleteUpdateShoes(updateDeleteNumber);

		AlertView alertView = new AlertView();

		if (success) {

			alertView.alert("주문한 제품을 삭제하였습니다.");
			requestShowOrderMenu();

		} else {

			alertView.alert("주문한 제품 삭제를 실패하였습니다.");
			requestShowOrderMenu();

		}

	}

	// 장바구니 목록 페이지 뷰 불러오기
	public void requestShowOrderMenu() {

		// 전체 상품 리스트
		Controllers.getAdminController().requestShoesManegement2();

		ShowOrderMenuView showOrderMenu = new ShowOrderMenuView();

		showOrderMenu.showMenu();

	}

	// 장바구니 목록 페이지
	public void requestShowOrderMenu2(int seletedOrderMenu) {

		AlertView alertView = new AlertView();

		if (seletedOrderMenu == 1) {

			alertView.alert("장바구니에 담기");

		} else if (seletedOrderMenu == 2) {

			alertView.alert("장바구니니 보기");

		} else if (seletedOrderMenu == 3) {

			alertView.alert("주문 수정");

		} else if (seletedOrderMenu == 4) {

			alertView.alert("주문 삭제");

		} else if (seletedOrderMenu == 5) {

			alertView.alert("결제");

		} else if (seletedOrderMenu == 6) {

			alertView.alert("사용자 페이지");

		} else {

			alertView.alert("잘못입력하셨습니다. 다시 입력해 주세요");
			requestShowOrderMenu();

		}

	}

}
