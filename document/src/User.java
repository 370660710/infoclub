
public class User {

	private String userName; 
	private	String password; 
	
	public	User(String newUserName,String newPassword)	{
		this.userName=newUserName;
		this.password=newPassword;
	}
	public	boolean ComparePassword(String password) {
		return password.equals(this.password); 
	}
	public	void SetPassword(String newPassword) {
		password=newPassword;
	}
	public String getName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

}
