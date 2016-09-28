package shoesShoppingmall_view_user;

import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.User;

public class ShowAllUserView {

	private ArrayList<User> users = null;
	private Scanner keyboard;
	public ShowAllUserView(ArrayList<User> users) {
		this.users = users;
		keyboard = new Scanner(System.in);
	}

	public void printAll() {
		System.out.println("[ 전체사용자목록 ]");
		System.out.println("유저번호 \t ID \t PW \t 이름 \t 성별 \t 금액 \t 포인트 \t 쿠폰");
		if(users.size() == 0)
		{
			System.out.println("사용자가 없습니다.");
		}
		else
		{
			for(int i = 0; i < users.size(); i++)
			{
				System.out.print(users.get(i).getUserNumber() + "\t");
				System.out.print(users.get(i).getUserId() + "\t");
				System.out.print(users.get(i).getUserPassword() + "\t");
				System.out.print(users.get(i).getUserName() + "\t");
				System.out.print(users.get(i).getUserGender() + "\t");
				System.out.print(users.get(i).getMoney() + "\t");
				System.out.print(users.get(i).getPoint() + "\t");
				System.out.println(users.get(i).getCoupon());
			}
		}
			
	}

	public void menu() {	
		
		System.out.println("[ 사용자관리메뉴 ]");
		System.out.println("1.특정사용자보기 \t 2.관리자페이지로 이동.");
		int selectedNumber = keyboard.nextInt();
		
		//컨트롤로 요청
		//return selectedNumber;
		Controllers.getAdminController().requestUserManegement2(selectedNumber);
		
	}

}
