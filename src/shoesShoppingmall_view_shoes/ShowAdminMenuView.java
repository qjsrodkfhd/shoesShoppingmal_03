package shoesShoppingmall_view_shoes;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class ShowAdminMenuView {

	private Scanner keyboard;

	public ShowAdminMenuView(){
		
		keyboard = new Scanner(System.in);

	}
	
	public void ShowAdminMenu(){
		
		System.out.println("1. 신발등록" + "\t" + "2.신발 상세 정보" + "\t" + "3.등록된 신발 삭제" + "\t" +"4. 관리자 페이지 ");
		
		int selectedAdminMeue = keyboard.nextInt();
		
		Controllers.getShoesController().requestAdminPage2(selectedAdminMeue);
		
	}
}
