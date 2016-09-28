package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class SelectOneUserView {
	
	private Scanner keyboard;
	
	public SelectOneUserView()
	{
		keyboard = new Scanner(System.in);
	}

	public void getUserNumber() {
		System.out.println("[ 특정 사용자 보기 ]");
		System.out.print("조회하실 사용자 번호 입력 : ");
		int userNumber = keyboard.nextInt();
		
		//컨트롤로 요청
		//return userNumber;
		Controllers.getAdminController().requestSelectOneUser2(userNumber);
	}

}
