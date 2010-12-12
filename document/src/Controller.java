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

	//�������������н���
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
	
	//��ѯ�û���صĻ	
	private MessageAndError queryAssociationActivity() {
		System.out.println("�������������֣�");
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
	
	
    //���ӻ
	private MessageAndError associationAddActivity() {
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
				return MessageAndError.SUCCESS;
			return MessageAndError.ERROR_ADD;
		}
		else
			System.out.println("��ǰ�û����������û�");			
		return MessageAndError.ERROR_ADD;
	}
    
	//�û���¼
	private MessageAndError userLogin() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
		setParameter(1);
		
		currentUser = userManager.userLogin(Parameter[0], Parameter[1]);
		if (currentUser != null )
			return MessageAndError.SUCCESS;

		return MessageAndError.ERROR_LOGIN;
	} 
	
    //���Ÿ�������
	private MessageAndError associationChangePassword() {
		System.out.println("�������������֣�");
		setParameter(0);
		System.out.println("���������ŵ�¼���룺");
		setParameter(1);
		System.out.println("�������µ����룺");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_CHANGEPW;
	}
    
	//����ע��
	private MessageAndError associationRegister() {
		System.out.println("�������������֣�");
		setParameter(0);
		System.out.println("���������ŵ�¼���룺");
		setParameter(1);
		if (userManager.associationRegister(Parameter[0], Parameter[1]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_REGISTER;
	}
    
	//�û���������
	private MessageAndError userChangePassword() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
		setParameter(1);
		System.out.println("�������µ����룺");
		setParameter(2);
		if (userManager.changePassword(Parameter[0], Parameter[1], Parameter[2]))
			return MessageAndError.SUCCESS;
		return MessageAndError.ERROR_CHANGEPW;
	}
    
	//�û�ע��
	private MessageAndError userRegister() {
		System.out.println("�������û����֣�");
		setParameter(0);
		System.out.println("�������û���¼���룺");
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

    //���ַ���ת��Ϊʱ����
    public Time StringToTime(String string){
		return null;
		
	}
    
    //�õ����ص���Ϣ
	public String GetReturnMessage(){
		return returnMessage;
		
	}
	
}
