package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.User;

public class UpdateUserView {
	
	private static Scanner keyboard;
	
	public UpdateUserView()
	{
		keyboard = new Scanner(System.in);
	}


	public int getNumber() {
		
		int number = 0;
		while(true)
		{
			System.out.println("1.수정하기  2.사용자페이지로 돌아가기");
			number = keyboard.nextInt();
			
			if(number == 1)
			{
				System.out.println("수정하기");
				break;
			}
			else if(number == 2)
			{
				System.out.println("사용자페이지로 돌아가기");
				break;
				
			}else
			{
				System.out.println("잘못입력하셨습니다.");
			}	
		}
		
		
		return number;
	}

	public static void getUpdateUserSelect(int userNumber) {
		System.out.println("1.PW, 2.이름, 3.성별, 4.돌아가기");
		int number = keyboard.nextInt();
		if(number == 1)
		{
			getUpdateUserPw(userNumber);
			
		}
		else if(number == 2)
		{
			getUpdateUserName(userNumber);
			
		}
		else if(number == 3)
		{
			getUpdateUserGender(userNumber);
			
		}
		else if(number == 4)
		{			
			Controllers.getAdminController().requestAdminPage();
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			Controllers.getAdminController().requestAdminPage();
		}
			
		
	}


	private static void getUpdateUserGender(int userNumber) {
		System.out.println("수정할 성별를 입력하세요");
		String gender = keyboard.next();
		boolean success = Controllers.getUserController().requestUpdateGender(userNumber,gender);
		if(success)
		{
			System.out.println("성별변경성공");
		}
		else
		{
			System.out.println("성별변경실패");
		}
	}


	private static void getUpdateUserName(int userNumber) {
		System.out.println("수정할 이름를 입력하세요");
		String name = keyboard.next();
		boolean success = Controllers.getUserController().requestUpdateName(userNumber,name);
		if(success)
		{
			System.out.println("이름변경성공");
		}
		else
		{
			System.out.println("이름변경실패");
		}
		
	}


	private static void getUpdateUserPw(int userNumber) {
		// TODO Auto-generated method stub
		System.out.println("수정할 PW를 입력하세요");
		String pw = keyboard.next();
		boolean success = Controllers.getUserController().requestUpdatePw(userNumber,pw);
		if(success)
		{
			System.out.println("pw변경성공");
		}
		else
		{
			System.out.println("pw변경실패");
		}
	}


	public void getUpdateUserSelect(User user) {
		System.out.println("1.PW, 2.이름, 3.성별, 4.돌아가기");
		int number = keyboard.nextInt();
		if(number == 1)
		{
			getUpdateUserPw(user.getUserNumber());
			
		}
		else if(number == 2)
		{
			getUpdateUserName(user.getUserNumber());
			
		}
		else if(number == 3)
		{
			getUpdateUserGender(user.getUserNumber());
			
		}
		else if(number == 4)
		{			
			Controllers.getUserController().requestshowUserPage();
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			Controllers.getUserController().requestshowUserPage();
		}
		
	}


	

	

}
