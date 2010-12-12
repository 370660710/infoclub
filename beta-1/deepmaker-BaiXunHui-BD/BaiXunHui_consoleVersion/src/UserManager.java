/**  
* @Title: UserManager.java
* @Package (default package)
* @Description: A class that manage the users
* @author HuangKaiwen  
* @date 2010-12-6 13:09:05
* @version V0.1  
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
* @ClassName: UserManager
* @Description: Offer the method to operate the users
* @author HuangKaiwen
* @date 2010-12-6 13:20:48
*
* ${tags}
*/
public class UserManager {
	
	private	Map<String,User> userList = new HashMap<String,User>();
	private int userListSize;
	
	public UserManager(){
		userListSize = 0;
	}
	
	/**
	* @Title: userRegister(String userName, String password)
	* @Description: register user
	* @param  all
	* @return boolean
	* @throws void
	*/
	public boolean userRegister(String userName, String password)
	{
		if (userList.containsKey(userName)) 
		{
			System.out.println("�û����Ѵ��ڣ�����������");
			return false;
		}
		else
		{
			User newUser = new User(userName, password);
			userList.put(userName, newUser);
			userListSize ++;
			System.out.printf("�û���%s �ɹ�ע�ᣬ����Ϊ�� %s", userName, password);
			showAllNameandPassword();
			return true;
		}
	}
	
	/**
	* @Title: changePassword(String userName, String password, String newPassword)
	* @Description: change the password of user
	* @param  all
	* @return boolean
	* @throws void
	*/
	public boolean changePassword(String userName, String password, String newPassword)
	{
		if (!userList.containsKey(userName)) {
			System.out.println("�û��������ڣ�����������"); 
			return false; 
		}
		else if (!userList.get(userName).ComparePassword(password)) {
			System.out.print("���������������������\n"); 
			return false; 
		}
		else 
		{
			userList.get(userName).SetPassword(newPassword);
			System.out.printf("�û�:%s �ɹ��޸����룬������Ϊ��%s", userName, newPassword);
			showAllNameandPassword();
			return true; 
		}
	}
	
	/**
	* @Title: showAllNameandPassword()
	* @Description: show all name and password
	* @param  all
	* @return void
	* @throws void
	*/
	private void showAllNameandPassword()
	{
		 for (Iterator<String> iterator = userList.keySet().iterator(); iterator.hasNext();) 
		 {
			   Object obj = iterator.next();
			   System.out.println("\nkey=" + obj + " value=" + userList.get(obj).getName()+ " " + userList.get(obj).getPassword());
		 }
	}
	
	/**
	* @Title: associationRegister(String userName, String password)
	* @Description: register a association
	* @param  all
	* @return boolean
	* @throws void
	*/
	public boolean associationRegister(String userName, String password)
	{
		if (userList.containsKey(userName)) 
		{
			System.out.println("�������Ѵ��ڣ�����������");
			return false;
		}
		else
		{
			Association newAssociation = new Association(userName, password);
			userList.put(userName, newAssociation);
			userListSize ++;
			System.out.printf("���ţ�%s �ɹ�ע�ᣬ����Ϊ�� %s", userName, password);
			showAllNameandPassword();
			return true;
		}
	}

	/**
	* @Title: userLogin(String userName, String password)
	* @Description: user login
	* @param  all
	* @return User
	* @throws void
	*/
	public User userLogin(String userName, String password)
	{
		if (userList.get(userName) != null && userList.get(userName).getPassword().equals(password))
			return userList.get(userName);
		else 
			return null;
	}

	/**
	* @Title: findUserByName(String userName)
	* @Description: find user by name
	* @param  all
	* @return User
	* @throws void
	*/
	public User findUserByName(String userName) {
		return userList.get(userName);
	}
}
