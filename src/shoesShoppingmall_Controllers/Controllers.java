package shoesShoppingmall_Controllers;

public class Controllers {
	
	private static LoginController loginController;
	private static UserController userController;
	private static AdminController adminController;
	private static OrderController orderController;
	private static ShoesController shoesController;
	
	public Controllers()
	{		
		
		loginController = new LoginController();
		userController = new UserController();
		adminController = new AdminController();
		orderController = new OrderController();
		shoesController = new ShoesController();
	}
	
	public static OrderController getOrderController() {
		return orderController;
	}

	public static ShoesController getShoesController()
	{
		return shoesController;
	}
	
	public static AdminController getAdminController()
	{
		return adminController;
	}
	
	
	public static LoginController getLoginController()
	{
		return loginController;
	}
	
	public static UserController getUserController()
	{
		return userController;
	}

	
	
}
