/**  
* @Title: User.java
* @Package (default package)
* @Description: Contain the basic information and operation of user
* @author LiuDebo  
* @date 2010-12-6 23:14:25
* @version V0.1  
*/

/**
* @ClassName: User
* @Description: Contain the basic information and operation of user
* @author LiuDebo
* @date 2010-12-6 23:14:25
*
* ${tags}
*/
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
		this.password=newPassword;
	}
	public String getName() {
		return this.userName;
	}
	public String getPassword() {
		return this.password;
	}
}
