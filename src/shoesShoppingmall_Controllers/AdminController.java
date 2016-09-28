package shoesShoppingmall_Controllers;

import java.util.ArrayList;

import shoesShoppingmall_dao.AdminDao;
import shoesShoppingmall_domain.Shoes;
import shoesShoppingmall_domain.User;
import shoesShoppingmall_view.AlertView;
import shoesShoppingmall_view_admin.AdminPageView;
import shoesShoppingmall_view_shoes.SelectOneShoesView;
import shoesShoppingmall_view_shoes.ShowAllShoesView;
import shoesShoppingmall_view_user.SelectOneUserView;
import shoesShoppingmall_view_user.ShowAllUserView;
import shoesShoppingmall_view_user.ShowOneUserView;
import shoesShoppingmall_view_user.UpdateUserView;

public class AdminController {
	private AdminDao adminDao;
	private int userNumber;
	
	public AdminController()
	{
		adminDao = new AdminDao();
	}

	public void requestAdminPage()
	{
		AdminPageView adminPageView = new AdminPageView();
		adminPageView.showMainAdminPage();
	}
	
	public void requestAdminPage2(int selectedMenu){

		if(selectedMenu == 1)
		{
			System.out.println("제품관리");
			requestShoesManegement();

		}
		else if(selectedMenu == 2)
		{
			System.out.println("사용자관리");
			requestUserManegement();
		}
		else if(selectedMenu == 3)
		{
			System.out.println("추가기능");
		}
		else if(selectedMenu == 4)
		{
			System.out.println("게시판관리");
			requestAdminPage();
		}
		else if(selectedMenu == 5)
		{
			System.out.println("로그인메뉴로");
			Controllers.getLoginController().requestMainLogin();
		}
		else if(selectedMenu == 6)
		{
			System.out.println("종료");
			System.exit(0);
		}
		else
		{
			System.out.println("잘못입력");
			requestAdminPage();
		}
	}

	//신발 전체 리스트
	public void requestShoesManegement() 
	{

		ArrayList<Shoes> Shoes = Controllers.getShoesController().shoesList();
		ShowAllShoesView allShoesView = new ShowAllShoesView(Shoes);
		allShoesView.AllShowShoes();

		Controllers.getShoesController().requestAdminPage();

	}
	
	public void requestShoesManegement2() 
	{

		ArrayList<Shoes> Shoes = Controllers.getShoesController().shoesList();
		ShowAllShoesView allShoesView = new ShowAllShoesView(Shoes);
		allShoesView.AllShowShoes();
	}

	public void requestUserManegement() {		

		ArrayList<User> users = Controllers.getUserController().requestReadAllUser();
		ShowAllUserView showAllUserView = new ShowAllUserView(users);
		showAllUserView.printAll();
		showAllUserView.menu();
	}
	public void requestUserManegement2(int selectedMenu)
	{

		if(selectedMenu == 1)
		{
			System.out.println("특정사용자보기");
			requestSelectOneUser();
		}
		else if(selectedMenu == 2)
		{
			System.out.println("관리자페이지로");
			requestAdminPage();
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			requestUserManegement();
		}

	}


	public void requestSelectOneUser() {

		SelectOneUserView selectOneUserView = new SelectOneUserView();
		selectOneUserView.getUserNumber();
	}
	public void requestSelectOneUser2(int userNumber)
	{
		this.userNumber = userNumber;
		ShowOneUserView showOneUserView = new ShowOneUserView();
		//User user = userDao.readOneUser(userNumber);
		User user = Controllers.getUserController().requestShowOneUser(userNumber);
		showOneUserView.printOneUser(user);
		showOneUserView.updateMenu();
	}
	public void requestSelectOneUser3(int updateNumber)
	{
		

		//System.out.println("1.사용자 수정 \t 2.사용자 삭제 \t 3.사용자 관리모드로");
		if(updateNumber == 1)
		{
			UpdateUserView updateUserView = new UpdateUserView();
			UpdateUserView.getUpdateUserSelect(userNumber);
			
			//userDao.updateUser(userNumber);
			
		}
		else if(updateNumber == 2)
		{

			//Controllers.getUserController().r
			//userDao.deleteUser(userNumber);
			Controllers.getUserController().requestDeleteUser(userNumber);
		}
		else if(updateNumber == 3)
		{
			requestUserManegement();
		}
		else
		{
			AlertView alertView = new AlertView();
			alertView.alert("잘못입력하셨습니다.");
		}

		requestUserManegement();
	}

	public void requestShowUpdateMenu() {
		SelectOneShoesView selectOneShoesView = new SelectOneShoesView();
		selectOneShoesView.showUpdateMenu();
		
	}

}
