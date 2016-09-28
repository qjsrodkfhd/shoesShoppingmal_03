package shoesShoppingmall_repository;

import java.util.ArrayList;

import shoesShoppingmall_domain.User;

public class UserRepository {
	
	private static ArrayList<User> users;
	private static int userNumber;
	
	public UserRepository(){
		
		users = new ArrayList<User>();
		userNumber = 0;
		
	}

	public static int getUserNumber() {
		
		return userNumber;
		
	}

	public static void setUserNumber(int userNumber) {
		
		UserRepository.userNumber = userNumber;
		
	}

	public static ArrayList<User> getUsers() {
		
		return users;
		
	}
	

}
