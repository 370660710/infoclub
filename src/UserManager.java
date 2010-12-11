import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Set;


public class UserManager {
	private	Map<String,User> userList = new HashMap<String,User>();
	private int userListSize;
	
	public UserManager(){
		userListSize = 0;
	}
	
	public boolean userRegister(String userName, String password) {
		if (userList.containsKey(userName)) {
			System.out.println("用户名已存在，请重新输入");
			return false;
		}	
		User p = new User(userName, password);
		userList.put(userName, p);
		userListSize ++;
		System.out.printf("用户：%s 成功注册，密码为： %s", userName, password);
		ptint();
		return true; 		
	}
	
	//用户修改密码
	boolean changePassword(String userName, String password, String newPassword)
	{
		if (!userList.containsKey(userName)) {
			System.out.println("用户名不存在，请重新输入"); 
			return false; 
		}
		if (!userList.get(userName).ComparePassword(password)) {
			System.out.print("密码输入错误，请重新输入\n"); 
			return false; 
		}
		
		userList.get(userName).SetPassword(newPassword);
		System.out.printf("用户:%s 成功修改密码，新密码为：%s", userName, newPassword);
		ptint();
		return true; 
	}
	
	private void ptint(){
		 for (Iterator<String> i = userList.keySet().iterator(); i.hasNext();) {
			   Object obj = i.next();
			   //System.out.println(obj);// 循环输出key
			   System.out.println("\nkey=" + obj + " value=" + 
					   userList.get(obj).getName()+ " " + userList.get(obj).getPassword());
		 }
	}
	

	public boolean associationRegister(String userName, String password) {
		if (userList.containsKey(userName)) {
			System.out.println("社团名已存在，请重新输入");
			return false;
		}	
		Association p = new Association(userName, password);
		userList.put(userName, p);
		userListSize ++;
		System.out.printf("社团：%s 成功注册，密码为： %s", userName, password);
		ptint();
		return true; 
	}

	public User userLogin(String userName, String password) {
		if (userList.get(userName) != null) {
			if(userList.get(userName).getPassword().equals(password))
				return userList.get(userName);
		}
		return null;
	}

	public User findUserByName(String userName) {
		return userList.get(userName);
	}

}
