package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.User;

public class RegisterLoginView {
	
	private Scanner keyboard;
	
	public RegisterLoginView()
	{
		keyboard = new Scanner(System.in);
	}
	
	//회원가입 정보를 입력받는 곳
	public void registerUser() {
		System.out.println("[ 회원가입 모드 ]");
		System.out.print("ID : ");
		String id = keyboard.next();
		
		System.out.print("PW : ");
		String pw = keyboard.next();
		
		System.out.print("이름 : ");
		String name = keyboard.next();
		
		System.out.print("성별 : ");
		String gender = keyboard.next();
		
		User user = new User(id,pw,name,gender);
		
		//컨트롤로 요청
		//return user;
		Controllers.getUserController().requestRegisterUser2(user);
	}

}
