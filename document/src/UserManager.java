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
			System.out.println("�û����Ѵ��ڣ�����������");
			return false;
		}	
		User p = new User(userName, password);
		userList.put(userName, p);
		userListSize ++;
		System.out.printf("�û���%s �ɹ�ע�ᣬ����Ϊ�� %s", userName, password);
		ptint();
		return true; 		
	}
	
	//�û��޸�����
	boolean changePassword(String userName, String password, String newPassword)
	{
		if (!userList.containsKey(userName)) {
			System.out.println("�û��������ڣ�����������"); 
			return false; 
		}
		if (!userList.get(userName).ComparePassword(password)) {
			System.out.print("���������������������\n"); 
			return false; 
		}
		
		userList.get(userName).SetPassword(newPassword);
		System.out.printf("�û�:%s �ɹ��޸����룬������Ϊ��%s", userName, newPassword);
		ptint();
		return true; 
	}
	
	private void ptint(){
		 for (Iterator<String> i = userList.keySet().iterator(); i.hasNext();) {
			   Object obj = i.next();
			   //System.out.println(obj);// ѭ�����key
			   System.out.println("\nkey=" + obj + " value=" + 
					   userList.get(obj).getName()+ " " + userList.get(obj).getPassword());
		 }
	}
	

	public boolean associationRegister(String userName, String password) {
		if (userList.containsKey(userName)) {
			System.out.println("�������Ѵ��ڣ�����������");
			return false;
		}	
		Association p = new Association(userName, password);
		userList.put(userName, p);
		userListSize ++;
		System.out.printf("���ţ�%s �ɹ�ע�ᣬ����Ϊ�� %s", userName, password);
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
