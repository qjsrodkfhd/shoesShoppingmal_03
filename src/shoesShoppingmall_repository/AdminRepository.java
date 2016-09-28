package shoesShoppingmall_repository;

public class AdminRepository {
	
	private static String adminId;
	private static String adminPassword;
	private static int price;
	
	
	public AdminRepository() {
		
		this.adminId = "admin";
		this.adminPassword = "admin";
		this.price = 0;
		
	}


	public static String getAdminId() {
		
		return adminId;
		
	}


	public static String getAdminPassword() {
		
		return adminPassword;
		
	}
	
	
}
