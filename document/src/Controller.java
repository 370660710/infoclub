import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Controller {
	private User currentUser;
	private	UserManager userManager = new UserManager();
	private	String returnMessage;
	private String Parameter[] = new String[4];
//	private boolean iscurrentUserAssociation = false;
	public Controller(){
		returnMessage = "";
	};

	//将输入的命令进行解析
	public MessageAndError parseCommand(String command) {
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
		return MessageAndError.SUCCESS;

	}
	
	//查询用户相关的活动	
	private MessageAndError queryAssociationActivity() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		User queryUser = userManager.findUserByName(Parameter[0]);
		if(queryUser != null && queryUser instanceof Association){
			Activity[] queryResult = ((Association) currentUser).queryActivity();
			for(int i = 0; i < queryResult.length; i++)
				returnMessage = returnMessage + Parameter[0]+ "\t" 
					+ queryResult[i].activitysToString() + "\n" ;
			return MessageAndError.SUCCESS_MESSAGE;
		}
		return MessageAndError.ERROR_QUERY;
	}
	
	
    //增加活动
	private MessageAndError associationAddActivity() {
		if(currentUser == null)
			System.out.println("请先登录");
		if(currentUser instanceof Association){
			System.out.println("请输入活动名字：");
			setParameter(0);
			System.out.println("请输入活动报名时间：");
			setParameter(1);
			System.out.println("请输入活动开始时间：");
			setParameter(2);
			if(((Association) currentUser).addActivity(Parameter[0], Parameter[1], Parameter[2]))
				return MessageAndError.SUCCESS;
			return MessageAndError.ERROR_ADD;
		}
		else
			System.out.println("当前用户不是社团用户");			
		return MessageAndError.ERROR_ADD;
	}
    
	//用户登录
	private MessageAndError userLogin() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		
		currentUser = userManager.userLogin(Parameter[0], Parameter[1]);
		if (currentUser != null )
			return MessageAndError.SUCCESS;

		return MessageAndError.ERROR_LOGIN;
	} 
	
    //社团更改密码
	private MessageAndError associationChangePassword() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		System.out.println("请输入社团登录密码：");
		setParameter(1);
		System.out.println("请输入新的密码：");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_CHANGEPW;
	}
    
	//社团注册
	private MessageAndError associationRegister() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		System.out.println("请输入社团登录密码：");
		setParameter(1);
		if (userManager.associationRegister(Parameter[0], Parameter[1]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_REGISTER;
	}
    
	//用户更改密码
	private MessageAndError userChangePassword() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		System.out.println("请输入新的密码：");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_CHANGEPW;
	}
    
	//用户注册
	private MessageAndError userRegister() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		if (userManager.userRegister(Parameter[0], Parameter[1]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_REGISTER;
	}

	private void setParameter(int num ) {
		InputStreamReader in = null;
		BufferedReader br = null;
		in = new InputStreamReader(System.in);
		br = new BufferedReader(in);
		try {
			Parameter[num] = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    //将字符串转换为时间类
    public Time StringToTime(String string){
		return null;
		
	}
    
    //得到返回的信息
	public String GetReturnMessage(){
		return returnMessage;
		
	}
	
}
