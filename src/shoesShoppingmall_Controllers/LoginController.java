package shoesShoppingmall_Controllers;

import shoesShoppingmall_dao.LoginDao;
import shoesShoppingmall_domain.Login;
import shoesShoppingmall_domain.User;
import shoesShoppingmall_view.AlertView;
import shoesShoppingmall_view.MainLoginView;

public class LoginController {
	private LoginDao loginDao;
	
	public LoginController()
	{
		loginDao = new LoginDao();
	}
	
	public LoginDao getLoginDao()
	{
		return loginDao;
	}

	//메인페이지를 로그인과 회원가입을 선택받는 함수
	public void requestMainLogin() {
		
		MainLoginView mainLoginView = new MainLoginView();
		mainLoginView.showMainPage();
	}
	
	//
	public void requestMainLogin2(int selectedMenu) {
		
		if(selectedMenu == 1)
		{
			requestLogin();
		}
		else if(selectedMenu == 2)
		{
			UserController.requestRegisterUser();
		}
		else
		{
			AlertView alert = new AlertView();
			alert.alert("잘못입력하셨습니다.");
			requestMainLogin();
		}	
		
	}

	//로그인
	private void requestLogin() {
		
		MainLoginView mainLoginView = new MainLoginView();
		mainLoginView.login();
	}
	
	//
	public void requestLogin2(User user) {
		
		boolean success = loginDao.adminlogin(user);
		if(success)
		{
			AlertView alert = new AlertView();
			alert.alert("관리자모드로 이동합니다..");
			Controllers.getAdminController().requestAdminPage();
		}
		else
		{
			success = loginDao.login(user);
			if(success)
			{
				AlertView alert = new AlertView();
				alert.alert("로그인에 성공하였습니다.");
				Controllers.getUserController().requestshowUserPage();
			}
			else
			{
				AlertView alert = new AlertView();
				alert.alert("로그인에 실패하였습니다.");
				requestMainLogin();
			}
			
		}
		
	}

	//로그아웃
	public void requestLogout() {
		
		loginDao.logout();
		Controllers.getLoginController().requestMainLogin();
		
	}
	
	public Login requestLoginInfo()
	{
		Login loginInfo = loginDao.getLoginInfo();
		
		return loginInfo;
	}

}
