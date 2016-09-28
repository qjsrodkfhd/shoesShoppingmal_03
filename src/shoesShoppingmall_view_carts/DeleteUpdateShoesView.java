package shoesShoppingmall_view_carts;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class DeleteUpdateShoesView {
	
	private Scanner keyboard;
	
	
	public DeleteUpdateShoesView(){
		
		keyboard = new Scanner(System.in);
		
	}

	public void deleteUpdateShoes(){
		
		System.out.println("삭제하실 주문번호를 입력하세요: ");
		int updateDeleteNumber = keyboard.nextInt();
		
		Controllers.getOrderController().requestDeleteShoes2(updateDeleteNumber);
		
	}
}
