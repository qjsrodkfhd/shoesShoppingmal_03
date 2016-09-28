package shoesShoppingmall_dao;

import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_domain.Login;
import shoesShoppingmall_domain.User;
import shoesShoppingmall_repository.UserRepository;

public class UserDao {

	private Scanner keyboard;

	public UserDao()
	{
		keyboard = new Scanner(System.in);
		new UserRepository();
	}

	//사용자 등록부분
	public boolean insertUser(User user) {
		boolean success = false;

		UserRepository.setUserNumber(UserRepository.getUserNumber()+1);

		user.setUserNumber(UserRepository.getUserNumber());

		ArrayList<User> currentUsers = UserRepository.getUsers();
		currentUsers.add(user);

		success = true;

		return success;
	}

	//전체 리스트
	public ArrayList<User> readAllUser() {
		ArrayList<User> users = UserRepository.getUsers();

		return users;
	}

	//
	public User readOneUser(int userNumber) {
		ArrayList<User> users = UserRepository.getUsers();
		User user = null;
		for(int i = 0; i < users.size(); i++)
		{
			if(userNumber == users.get(i).getUserNumber())
			{
				user = users.get(i);
				break;
			}
		}
		return user;
	}

	//회원가입 중복체크
	public boolean checkLoginId(User user){

		boolean success = false;

		for(int i = 0; i < UserRepository.getUsers().size(); i++){

			if(user.getUserId().equals(UserRepository.getUsers().get(i).getUserId())){

				success = true;
				break;

			}

		}

		return success;

	}

	public void deleteUser(int userNumber) {
		ArrayList<User> users = UserRepository.getUsers();

		for(int i = 0 ; i < users.size(); i++)
		{
			if(users.get(i).getUserNumber() == userNumber)
			{
				users.remove(i);
				break;
			}
		}

	}

	public User updateMyPage(String loginId) {
		ArrayList<User> users = UserRepository.getUsers();
		User user = null;

		int index = 0;
		for(int i = 0 ; i < users.size(); i++)
		{
			if(users.get(i).getUserId().equals(loginId))
			{
				user = users.get(i);
				break;
			}
		}

		return user;

	}
	
	public boolean updateUser(String loginId, User updateUser) {
		ArrayList<User> users = UserRepository.getUsers();
		boolean success = false;

		for(int i = 0 ; i < users.size(); i++)
		{
			if(users.get(i).getUserId().equals(loginId))
			{
				users.get(i).setUserPassword(updateUser.getUserPassword());
				users.get(i).setUserName(updateUser.getUserName());
				users.get(i).setUserGender(updateUser.getUserGender());
				success = true;
				break;
			}
		}

		return success;
	}

	public User readOneUser(String loginId) {
		User user = null;

		for(int i = 0; i < UserRepository.getUsers().size(); i++)
		{
			if(UserRepository.getUsers().get(i).getUserId().equals(loginId))
			{
				user = UserRepository.getUsers().get(i);
				break;
			}
		}

		return user;
	}


	public boolean updateUserPw(int userNumber, String pw) {
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();
		
		for(int i = 0; i < users.size(); i++)
		{
			if(userNumber == users.get(i).getUserNumber())
			{
				users.get(i).setUserPassword(pw);
				success = true;
				break;
			}
		}
		
		
		return success;
	}

	public boolean updateUserName(int userNumber, String name) {
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();
		
		for(int i = 0; i < users.size(); i++)
		{
			if(userNumber == users.get(i).getUserNumber())
			{
				users.get(i).setUserName(name);
				success = true;
				break;
			}
		}
		
		
		return success;
	}

	public boolean updateUserGender(int userNumber, String gender) {
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();
		
		for(int i = 0; i < users.size(); i++)
		{
			if(userNumber == users.get(i).getUserNumber())
			{
				users.get(i).setUserGender(gender);
				success = true;
				break;
			}
		}
		
		
		return success;
	}

	public boolean chargeCash(Login login, int point) {
		String Id = login.getLoginId();
		boolean success = false;
		ArrayList<User> users = UserRepository.getUsers();
		
		for(int i = 0; i < users.size(); i++)
		{
			if(Id.equals(users.get(i).getUserId()))
			{
				users.get(i).setMoney(point);
				success = true;
				break;
			}
		}
		
		return success;
		
	}

}
