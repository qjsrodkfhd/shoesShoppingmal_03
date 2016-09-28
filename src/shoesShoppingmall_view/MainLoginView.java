package shoesShoppingmall_view;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.User;

public class MainLoginView {

	private Scanner keyboard;
	
	public MainLoginView()
	{
		keyboard = new Scanner(System.in);
	}
	//메인페이지
	//public int showMainPage() {
	public void showMainPage() {
		
		
		System.out.println("[메인 페이지]");
		System.out.println("1.로그인 \t 2.회원가입");
		System.out.print("입력 : ");
		int number = keyboard.nextInt();
		
		//수동으로 컨트롤러 호출
		Controllers.getLoginController().requestMainLogin2(number);
		//return number;
		
	}

	public void login() {
		System.out.println("[ 로그인 모드 ]");
		System.out.print("ID : ");
		String id = keyboard.next();
		System.out.print("PW : ");
		String pw = keyboard.next();
		
		User user = new User(id,pw);
		
		//컨트롤러 요청
		Controllers.getLoginController().requestLogin2(user);
		//return user;
		
	}


}
