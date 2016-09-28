package shoesShoppingmall_main;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_Controllers.LoginController;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		LoginController loginController = Controllers.getLoginController();
		loginController.requestMainLogin();
		
	}

}
