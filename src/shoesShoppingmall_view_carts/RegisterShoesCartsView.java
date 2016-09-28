package shoesShoppingmall_view_carts;

import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.OrderShoes;
import shoesShoppingmall_domain.Shoes;

public class RegisterShoesCartsView {

	private Scanner keyboard;
	
	public RegisterShoesCartsView(){
			
		keyboard = new Scanner(System.in);
		
	}
	
	public void inputCarts(){

		System.out.println("장바구니로 담을 주문(제품)번호를 입력하세요: ");
		int orderNumber = keyboard.nextInt();
		System.out.println("담으실 수량을 입력하세요: ");
		int orderCount = keyboard.nextInt();

		OrderShoes OrderShoes = new OrderShoes(orderNumber, orderCount);

		Controllers.getOrderController().requestInputCarts2(OrderShoes);
		
	}
}
