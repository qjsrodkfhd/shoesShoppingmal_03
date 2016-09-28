package shoesShoppingmall_Controllers;

import java.util.ArrayList;

import shoesShoppingmall_dao.UserDao;
import shoesShoppingmall_domain.Login;
import shoesShoppingmall_domain.Shoes;
import shoesShoppingmall_domain.User;
import shoesShoppingmall_view.AlertView;
import shoesShoppingmall_view_shoes.SelectOneShoesView;
import shoesShoppingmall_view_shoes.ShowAllShoesView;
import shoesShoppingmall_view_user.ChargeCashView;
import shoesShoppingmall_view_user.RegisterLoginView;
import shoesShoppingmall_view_user.SelectOneUserView;
import shoesShoppingmall_view_user.ShowOneUserView;
import shoesShoppingmall_view_user.ShowUserPageView;
import shoesShoppingmall_view_user.UpdateUserView;

public class UserController {

	private static UserDao userDao;

	public UserController()
	{
		userDao = new UserDao();
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	//회원가입
	public static void requestRegisterUser() {

		RegisterLoginView registerLoginView = new RegisterLoginView();
		registerLoginView.registerUser();
	}
	public void requestRegisterUser2(User user)
	{

		//로그인 중복 체크
		boolean success = requestCheckLogin(user);

		AlertView alert = new AlertView();

		if(success)//중복된 아이디가 있다.
		{

			alert.alert(" 중복된 아이디가 존재합니다. ");
			requestRegisterUser();

		}
		else//중복된 아이디가 없으면 로그인
		{
			userDao.insertUser(user);

			if(success){

				alert.alert(" 회원가입에 실패하였습니다. ");

			} else{

				alert.alert(" 회원가입에 성공하였습니다. ");

			}

		}

		Controllers.getLoginController().requestMainLogin();

	}

	//id 중복 체크
	public boolean requestCheckLogin(User user){

		boolean success = false;

		success = userDao.checkLoginId(user);

		return success;
	}

	//사용자
	public void requestshowUserPage()
	{
		requestshowAllShoes();
		ShowUserPageView showUserPageView = new ShowUserPageView();
		showUserPageView.showMainUserPage();
	}
	
	public void requestshowAllShoes() {
		ArrayList<Shoes> Shoes = Controllers.getShoesController().shoesList();
		ShowAllShoesView allShoesView = new ShowAllShoesView(Shoes);
		allShoesView.AllShowShoes();		
	}

	public void requestshowUserPage2(int number)
	{

		if(number == 1)
		{
			System.out.println("제품상세조회");
			requestSelectShoesOne();
			requestshowUserPage();
		}
		else if(number == 2)
		{
			System.out.println("장바구니");
			Controllers.getOrderController().requestShowOrderMenu();

		}
		else if(number == 3)
		{
			System.out.println("충전하기 - 미구현");
			requestChargeCash();
			requestshowUserPage();
		}
		else if(number == 4)
		{
			System.out.println("인기순위 - 미구현");
			requestshowUserPage();
		}
		else if(number == 5)
		{
			System.out.println("게시판");
			requestshowUserPage();
		}
		else if(number == 6)
		{
			System.out.println("회원정보조회및수정");
			requestUpdateUser();
			requestshowUserPage();
		}
		else if(number == 7)
		{
			System.out.println("로그아웃");
			Controllers.getLoginController().requestLogout();
		}
		else if(number == 8)
		{
			System.out.println("종료");
			System.exit(0);
		}
		else
		{
			System.out.println("잘못입력하셨습니다.");
			requestshowUserPage();
		}
	}


	public void requestChargeCash() {
		
		ChargeCashView chargePointView = new ChargeCashView();
		chargePointView.chargeCash();		
	}
	
	public void requestChargeCash2(int point) {
		Login login = Controllers.getLoginController().requestLoginInfo();
		boolean success = userDao.chargeCash(login, point);
		if(success)
		{
			AlertView alert = new AlertView();
			alert.alert(point + "Cash 충전완료");
		}
		else
		{
			AlertView alert = new AlertView();
			alert.alert("충전실패");
		}
		
	}

	public void requestUpdateUser() {
		
		Login login = Controllers.getLoginController().requestLoginInfo();
		User user = Controllers.getUserController().requestShowOneUser(login);
		ShowOneUserView showOneUserView = new ShowOneUserView();
		showOneUserView.printOneUser2(user);
		UpdateUserView updateUserView = new UpdateUserView();
		updateUserView.getUpdateUserSelect(user);
		
	}

	public void requestDeleteUser(int userNumber) {

		userDao.deleteUser(userNumber);

	}


	public void requestSelectShoesOne() {
		SelectOneShoesView selectShoesOneView = new SelectOneShoesView();
		selectShoesOneView.oneSelectedShoes();
		

	}

	public ArrayList<User> requestReadAllUser() {
		ArrayList<User> user = userDao.readAllUser();
		return user;
	}

	public User requestShowOneUser(Login login) 
	{
		String Id = login.getLoginId();
		ArrayList<User> user = userDao.readAllUser();
		User findUser = null;
		
		for(int i = 0; i < user.size(); i++)
		{
			if(Id.equals(user.get(i).getUserId()))
			{
				findUser = user.get(i);
			}
		}

		return findUser;
	}


	public boolean requestUpdatePw(int userNumber, String pw) {
		boolean success = false;

		success= userDao.updateUserPw(userNumber, pw);

		return success;

	}

	public boolean requestUpdateName(int userNumber, String name) {
		boolean success = false;

		success= userDao.updateUserName(userNumber, name);

		return success;

	}

	public boolean requestUpdateGender(int userNumber, String gender) {
		boolean success = false;

		success= userDao.updateUserGender(userNumber, gender);

		return success;

	}

	public User requestShowOneUser(int userNumber) {
		ArrayList<User> user = userDao.readAllUser();
		User findUser = null;
		
		for(int i = 0; i < user.size(); i++)
		{
			if(userNumber == user.get(i).getUserNumber())
			{
				findUser = user.get(i);
			}
		}

		return findUser;
	}



}
