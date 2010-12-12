import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Controller {
	private User currentUser;
	private	UserManager userManager = new UserManager();
	private	String returnMsg;
	private String Parameter[] = new String[4];
//	private boolean iscurrentUserAssociation = false;
	public Controller(){
		returnMsg = "";
	};

	//将输入的命令进行解析
	public MsgAndError parseCommand(String command) {
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
			return MsgAndError.EXIT;
		return MsgAndError.SUCCESS;
	}
		
	private MsgAndError queryAssociationActivity() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		User queryUser = userManager.findUserByName(Parameter[0]);
		if(queryUser != null && queryUser instanceof Association){
			Activity[] queryResult = ((Association) currentUser).queryActivity();
			for(int i = 0; i < queryResult.length; i++)
				returnMsg = returnMsg + Parameter[0]+ "\t" 
					+ queryResult[i].activitysToString() + "\n" ;
			return MsgAndError.SUCCESS_MSG;
		}
		return MsgAndError.ERROR_QUERY;
	}

	private MsgAndError associationAddActivity() {
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
				return MsgAndError.SUCCESS;
			return MsgAndError.ERROR_ADD;
		}
		else
			System.out.println("当前用户不是社团用户");			
		return MsgAndError.ERROR_ADD;
	}

	private MsgAndError userLogin() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		
		currentUser = userManager.userLogin(Parameter[0], Parameter[1]);
		if (currentUser != null )
			return MsgAndError.SUCCESS;

		return MsgAndError.ERROR_LOGIN;
	}

	private MsgAndError associationChangePassword() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		System.out.println("请输入社团登录密码：");
		setParameter(1);
		System.out.println("请输入新的密码：");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_CHANGEPW;
	}

	private MsgAndError associationRegister() {
		System.out.println("请输入社团名字：");
		setParameter(0);
		System.out.println("请输入社团登录密码：");
		setParameter(1);
		if (userManager.associationRegister(Parameter[0], Parameter[1]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_REGISTER;
	}

	private MsgAndError userChangePassword() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		System.out.println("请输入新的密码：");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_CHANGEPW;
	}

	private MsgAndError userRegister() {
		System.out.println("请输入用户名字：");
		setParameter(0);
		System.out.println("请输入用户登录密码：");
		setParameter(1);
		if (userManager.userRegister(Parameter[0], Parameter[1]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_REGISTER;
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


	public Time StrToTime(String string){
		return null;
		
	}
	public String GetReturnMsg(){
		return returnMsg;
		
	}
	
}
