package shoesShoppingmall_view_admin;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class AdminPageView {

	private Scanner keyboard;
	public AdminPageView()
	{
		keyboard = new Scanner(System.in);
	}
	
	public void showMainAdminPage() {
		
		System.out.println("[ 관리자 페이지 메뉴 ]");
		System.out.println("1. 제품관리 \t 2. 사용자관리 \t 3. 추가기능\t 4.게시글관리 \t 5.로그인메뉴로 \t 6.종료");
		System.out.print("입력 : ");
		int selectedMenu = keyboard.nextInt();
		
		//컨트롤로 요청
		Controllers.getAdminController().requestAdminPage2(selectedMenu);
//		return selectedMenu;
		
	}

}
