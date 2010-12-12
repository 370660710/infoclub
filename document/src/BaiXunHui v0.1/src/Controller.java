/**  
* @Title: Controller.java
* @Package (default package)
* @Description: control and operate the other class and method
* @author JiangJiarong  
* @date 2010-12-10 13:38:47
* @version V0.1  
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @ClassName: Controller
* @Description: control and operate the other class and method
* @author JiangJiarong
* @date 2010-12-7 13:39:29
*
* ${tags}
*/
public class Controller 
{
	private User currentUser;
	private	UserManager userManager = new UserManager();
	private	String returnMessage;
	private String Parameter[] = new String[4];
	
	public Controller()
	{
		returnMessage = "";
	};
	
	/**
	* @Title: receive(String command)
	* @Description: receive the command and parse
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	public MessageAndError receive(String command) 
	{
		if(command.equals("1"))
			return userLogin();
		if(command.equals("2"))
			return userRegister();
		if(command.equals("21"))
			return userChangePassword();
		if(command.equals("3"))
			return associationRegister();
		if(command.equals("31"))
			return associationChangePassword();
		if(command.equals("4"))
			return associationAddActivity();
		if(command.equals("5"))
			return queryAssociationActivity();
		if(command.equals("0"))
			return MessageAndError.EXIT;
		return MessageAndError.ERROR_COMMAND;
	}
	
	/**
	* @Title: queryAssociationActivity()
	* @Description: query the activities of the association
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError queryAssociationActivity() {
		setFindUserByNameParameter();
		User queryUser = userManager.findUserByName(Parameter[0]);
		if(queryUser != null && queryUser instanceof Association)
		{
			Activity[] queryResult = ((Association) currentUser).queryActivity();
			for(int i = 0; i < queryResult.length; i++)
				returnMessage = returnMessage + Parameter[0]+ "\t" + queryResult[i].activitysToString() + "\n" ;
			return MessageAndError.SUCCESS_MESSAGE;
		}
		else
			return MessageAndError.ERROR_COMMAND;
	}
	
	/**
	* @Title: setFindUserByNameParameter()
	* @Description: set the parameters of the function FindUserByName
	* @param  all
	* @return void
	* @throws void
	*/
	private void setFindUserByNameParameter()
	{
		System.out.println("请输入社团名字：");
		receiveParameter(0);
	}
	
	/**
	* @Title: associationAddActivity()
	* @Description: add the activities of the association
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError associationAddActivity() 
	{
		if(currentUser == null)
		{
			System.out.println("请先登录");
			return MessageAndError.ERROR_ADD;
		}
		else if(currentUser instanceof Association)
		{
			setAddActivityParameter();
			if(((Association) currentUser).addActivity(Parameter[0], Parameter[1], Parameter[2]))
				return MessageAndError.SUCCESS;
			else
				return MessageAndError.ERROR_ADD;
		}
		else
		{
			System.out.println("当前用户不是社团用户");			
			return MessageAndError.ERROR_ADD;
		}
	}
	
	/**
	* @Title: setAddActivityParameter()
	* @Description: set the parameters of the function AddActivity
	* @param  all
	* @return void
	* @throws void
	*/
	private void setAddActivityParameter()
	{
		System.out.println("请输入活动名字：");
		receiveParameter(0);
		System.out.println("请输入活动报名时间：");
		receiveParameter(1);
		System.out.println("请输入活动开始时间：");
		receiveParameter(2);	
	}
    
	/**
	* @Title: userLogin()
	* @Description: user login
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError userLogin() {	
		setUserLoginParameter();
		currentUser = userManager.userLogin(Parameter[0], Parameter[1]);
		if (currentUser != null )
			return MessageAndError.SUCCESS;
		else 
			return MessageAndError.ERROR_LOGIN;
	} 
	
	/**
	* @Title: setUserLoginParameter()
	* @Description: set the parameters of the function UserLogin
	* @param  all
	* @return void
	* @throws void
	*/
	private void setUserLoginParameter()
	{
		System.out.println("请输入用户名字：");
		receiveParameter(0);
		System.out.println("请输入用户登录密码：");
		receiveParameter(1);
	}
	
	/**
	* @Title: associationChangePassword()
	* @Description: change the password of the association
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError associationChangePassword() {
		setChangePasswordParameter();
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		else
			return MessageAndError.ERROR_CHANGEPW;
	}
	
	/**
	* @Title: associationRegister()
	* @Description: register a new association
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError associationRegister() {
		System.out.println("请输入社团名字：");
		receiveParameter(0);
		System.out.println("请输入社团登录密码：");
		receiveParameter(1);
		if (userManager.associationRegister(Parameter[0], Parameter[1]))
			return MessageAndError.SUCCESS;
		else 
			return MessageAndError.ERROR_REGISTER;
	}
    
	/**
	* @Title: userChangePassword()
	* @Description: change the password of a user
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError userChangePassword() {
		setChangePasswordParameter();
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		else
			return MessageAndError.ERROR_CHANGEPW;
	}
	
	/**
	* @Title: setChangePasswordParameter()
	* @Description: set the parameters of the function ChangePassword
	* @param  all
	* @return void
	* @throws void
	*/
	private void setChangePasswordParameter()
	{
		System.out.println("请输入用户或社团的名字：");
		receiveParameter(0);
		System.out.println("请输入用户或社团的登录密码：");
		receiveParameter(1);
		System.out.println("请输入新的密码：");
		receiveParameter(2);
	}
    
	/**
	* @Title: userRegister()
	* @Description: register a new user
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private MessageAndError userRegister() {
		setRegisterParameter();
		if (userManager.userRegister(Parameter[0], Parameter[1]))
			return MessageAndError.SUCCESS;
		else 
			return MessageAndError.ERROR_REGISTER;
	}
	
	/**
	* @Title: setRegisterParameter()
	* @Description: set the parameters of the function Register
	* @param  all
	* @return void
	* @throws void
	*/
	private void setRegisterParameter()
	{
		System.out.println("请输入用户名字：");
		receiveParameter(0);
		System.out.println("请输入用户登录密码：");
		receiveParameter(1);
	}
	
	/**
	* @Title: receiveParameter(int num )
	* @Description: receive the input of parameter of a function
	* @param  all
	* @return MessageAndError
	* @throws void
	*/
	private void receiveParameter(int num ) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(input);
		try {
			Parameter[num] = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    //将字符串转换为时间类
    public Time StringToTime(String string){
		return null;
		
	}
    
    /**
	* @Title: GetReturnMessage()
	* @Description: get the returnMessage
	* @param  all
	* @return String
	* @throws void
	*/
	public String GetReturnMessage(){
		return this.returnMessage;
	}
	
}
