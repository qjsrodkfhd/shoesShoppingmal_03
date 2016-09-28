package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class ShowUserPageView {
	
	private Scanner keyboard;
	
	public ShowUserPageView()
	{
		keyboard = new Scanner(System.in);
	}

	public void showMainUserPage() {
		System.out.println("[ 사용자 페이지 모드 ]");
		System.out.println("1.제품상세조회 \t 2.장바구니 \t 3.충전하기 \t 4.인기순위"
				+ "\t 5.게시판 \t 6.회원정보조회및수정 \t 7.로그아웃 \t 8.종료");
		System.out.print("입력 : ");
		int selectedMenu = keyboard.nextInt();
		
		Controllers.getUserController().requestshowUserPage2(selectedMenu);
	}

}
