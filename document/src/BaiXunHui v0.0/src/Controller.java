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

	//�������������н���
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
		System.out.println("�������������֣�");
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
			System.out.println("���ȵ�¼");
		if(currentUser instanceof Association){
			System.out.println("���������֣�");
			setParameter(0);
			System.out.println("����������ʱ�䣺");
			setParameter(1);
			System.out.println("��������ʼʱ�䣺");
			setParameter(2);
			if(((Association) currentUser).addActivity(Parameter[0], Parameter[1], Parameter[2]))
				return MsgAndError.SUCCESS;
			return MsgAndError.ERROR_ADD;
		}
		else
			System.out.println("��ǰ�û����������û�");			
		return MsgAndError.ERROR_ADD;
	}

	private MsgAndError userLogin() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
		setParameter(1);
		
		currentUser = userManager.userLogin(Parameter[0], Parameter[1]);
		if (currentUser != null )
			return MsgAndError.SUCCESS;

		return MsgAndError.ERROR_LOGIN;
	}

	private MsgAndError associationChangePassword() {
		System.out.println("�������������֣�");
		setParameter(0);
		System.out.println("���������ŵ�¼���룺");
		setParameter(1);
		System.out.println("�������µ����룺");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_CHANGEPW;
	}

	private MsgAndError associationRegister() {
		System.out.println("�������������֣�");
		setParameter(0);
		System.out.println("���������ŵ�¼���룺");
		setParameter(1);
		if (userManager.associationRegister(Parameter[0], Parameter[1]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_REGISTER;
	}

	private MsgAndError userChangePassword() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
		setParameter(1);
		System.out.println("�������µ����룺");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MsgAndError.SUCCESS;
		return MsgAndError.ERROR_CHANGEPW;
	}

	private MsgAndError userRegister() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
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
