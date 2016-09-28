package shoesShoppingmall_view_carts;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class ShowOrderMenuView {
	
	private Scanner keyboard;
	
	public ShowOrderMenuView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void showMenu(){
		
		System.out.println("                    원하시는 페이지 번호를 입력하세요.                    ");
		System.out.println("");
		System.out.println(" 1. 장바구니에 담기 \t 2. 장바구니보기  \t 3. 주문수정  \t 4. 주문삭제  \t  5. 결제   \t 6. 사용자페이지");
		System.out.println("");
		int seletedOrderMenu = keyboard.nextInt();
		
		if(seletedOrderMenu == 1){
			
			Controllers.getOrderController().requestInputCarts();
			
		} else if(seletedOrderMenu == 2){
			
			Controllers.getOrderController().requestCartsList();
			
		} else if(seletedOrderMenu == 3){
			
			Controllers.getOrderController().requestUpdateCarts();
			
		} else if(seletedOrderMenu == 4){
			
			Controllers.getOrderController().requestDeleteShoes();
			
		} else if(seletedOrderMenu == 5){
			
			Controllers.getOrderController().requestPayMent();
			
		} else if(seletedOrderMenu == 6){
			
			Controllers.getUserController().requestshowUserPage();
		}
		
		Controllers.getOrderController().requestShowOrderMenu2(seletedOrderMenu);
				
	}

}
