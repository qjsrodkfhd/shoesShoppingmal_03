package shoesShoppingmall_view_shoes;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class DeleteShoesView {
	
	private Scanner keyboard;
	
	public DeleteShoesView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void deleteShoes(){
		
		System.out.println(" [등록한 신발 삭제 페이지입니다.] ");
		System.out.println("");
		System.out.println(" 삭제하실 제품번호를 입력해 주세요: ");
		int shoesNumber = keyboard.nextInt();
		
		//컨트롤로 요청
		Controllers.getShoesController().requestShoesDelete2(shoesNumber);
	
	}
}
