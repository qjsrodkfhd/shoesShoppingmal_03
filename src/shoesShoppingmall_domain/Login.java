package shoesShoppingmall_domain;

public class Login {

	private String loginId;
	private String loginPassword;
	
	public Login(String id, String pw){
		this.loginId = id;
		this.loginPassword = pw;
		
		
		
	}

	public String getLoginId() {
		
		return loginId;
		
	}

	public void setLoginId(String loginId) {
		
		this.loginId = loginId;
		
	}

	public String getLoginPassword() {
		
		return loginPassword;
		
	}

	public void setLoginPassword(String loginPassword) {
		
		this.loginPassword = loginPassword;
		
	}
	
	
}
