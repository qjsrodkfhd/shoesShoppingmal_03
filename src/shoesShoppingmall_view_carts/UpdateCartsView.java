package shoesShoppingmall_view_carts;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.UpdateOrderShoes;

public class UpdateCartsView {
	
	private Scanner keyboard;
	
	public UpdateCartsView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void UpdateCats(){
		
		System.out.println("[ 주문상품 수정 모드 ]");
		System.out.println("수정하실 주문 번호를 입력하세요: ");
		int orderNumner = keyboard.nextInt();
		System.out.println("수정하실 상품 수량: ");
		int orderCount = keyboard.nextInt();
		
		UpdateOrderShoes updateOrderShoes = new UpdateOrderShoes(orderNumner, orderCount);
		
		Controllers.getOrderController().requestUpdateCarts2(updateOrderShoes);
		
	}

}
