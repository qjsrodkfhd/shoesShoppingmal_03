package shoesShoppingmall_dao;

import java.util.ArrayList;

import shoesShoppingmall_domain.Login;
import shoesShoppingmall_domain.OrderShoes;
import shoesShoppingmall_domain.User;
import shoesShoppingmall_repository.AdminRepository;
import shoesShoppingmall_repository.LoginRepository;
import shoesShoppingmall_repository.OrderRepository;
import shoesShoppingmall_repository.UserRepository;

public class LoginDao {

	private LoginRepository loginRepository;
	
	
	public LoginDao()
	{
		loginRepository = new LoginRepository();
	}
	
	
	public LoginRepository getLoginRepository() {
		return loginRepository;
	}


	//로그인
	public boolean login(User user) {
		
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();

		for(int i = 0; i < users.size(); i++)
		{
			if(user.getUserId().equals(users.get(i).getUserId()) && user.getUserPassword().equals(users.get(i).getUserPassword()))
			{
				Login login = new Login(user.getUserId(), user.getUserPassword());
				LoginRepository.setLogin(login);
				success = true;
				break;
			}
		}


		return success;
	}
	
	//관리자로 로그인
	public boolean adminlogin(User user) {
		
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();

		if(AdminRepository.getAdminId().equals(user.getUserId()))
		{
			if(AdminRepository.getAdminPassword().equals(user.getUserPassword()))
			{
				success = true;
			}
			else
			{
				success = false;
			}

		}

		return success;
	}

	//로그아웃
	public boolean logout() {
		
		boolean success = false;

		LoginRepository.setLogin(null);

		ArrayList<OrderShoes> newOrders = new ArrayList<OrderShoes>();		
		OrderRepository.setOrders(newOrders);
		OrderRepository.setOrderNumber(0);	

		success = true;

		return success;

	}


	public Login getLoginInfo() {
		
		Login loginInfo = loginRepository.getLogin();
		
		return loginInfo;
	}
	
}
