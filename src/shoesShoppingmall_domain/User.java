package shoesShoppingmall_domain;

public class User {

	private int userNumber; 
	private String userId;
	private String userPassword;
	private String userName;
	private String userGender;
	private int money;
	private int point;
	private int coupon;
	
	public User(){
		
	}

	public User(String userId, String userPassword, String userName, String userGender) {
		
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		
	}

	public User(String id, String pw) {
		userId = id;
		userPassword = pw;
	}

	public User(String pw, String name, String gender) {
		userPassword = pw;
		userName = name;
		userGender = gender;
	}

	public int getUserNumber() {
		
		return userNumber;
		
	}

	public void setUserNumber(int userNumber) {
		
		this.userNumber = userNumber;
		
	}

	public String getUserId() {
		
		return userId;
		
	}

	public void setUserId(String userId) {
		
		this.userId = userId;
		
	}

	public String getUserPassword() {
		
		return userPassword;
		
	}

	public void setUserPassword(String userPassword) {
		
		this.userPassword = userPassword;
		
	}

	public String getUserName() {
		
		return userName;
		
	}

	public void setUserName(String userName) {
		
		this.userName = userName;
		
	}

	public String getUserGender() {
		
		return userGender;
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public void setUserGender(String userGender) {
		
		this.userGender = userGender;
		
	}
	
}
