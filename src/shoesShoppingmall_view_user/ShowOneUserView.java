package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.User;

public class ShowOneUserView {

	private Scanner keyboard;

	public ShowOneUserView()
	{
		keyboard = new Scanner(System.in);
	}

	public void printOneUser(String loginId)
	{

	}

	public void printOneUser(User user) {
		System.out.println("[ 특정사용자목록 ]");

		if(user == null)
		{
			System.out.println("사용자를 찾지 못하였습니다.");
		}
		else
		{
			System.out.println("유저번호 \t ID \t PW \t 이름 \t 성별 \t 금액 \t 포인트 \t 쿠폰");

			System.out.print(user.getUserNumber() + "\t");
			System.out.print(user.getUserId() + "\t");
			System.out.print(user.getUserPassword() + "\t");
			System.out.print(user.getUserName() + "\t");
			System.out.print(user.getUserGender() + "\t");
			System.out.print(user.getMoney() + "\t");
			System.out.print(user.getPoint() + "\t");
			System.out.println(user.getCoupon());
		}

	}

	public void updateMenu() {
		// TODO Auto-generated method stub
		System.out.println("[ 사용자 수정 모드 ]");
		System.out.println("1.사용자 수정 \t 2.사용자 삭제 \t 3.사용자 관리모드로");
		int number = keyboard.nextInt();

		//return number;
		Controllers.getAdminController().requestSelectOneUser3(number);
		
		

	}

	public void printOneUser2(User user) {
		System.out.println("ID \t PW \t 이름 \t 성별 \t 금액 \t 포인트 \t 쿠폰");

		System.out.print(user.getUserId() + "\t");
		System.out.print(user.getUserPassword() + "\t");
		System.out.print(user.getUserName() + "\t");
		System.out.print(user.getUserGender() + "\t");
		System.out.print(user.getMoney() + "\t");
		System.out.print(user.getPoint() + "\t");
		System.out.println(user.getCoupon());
		
	}

}
