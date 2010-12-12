package instance;

public class User
{
	private String userName;
	private String email;
	private String phone;
	private String userQQ;
		
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	public String getUserQQ() {
		return this.userQQ;
	}
}