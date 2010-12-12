/**  
* @Title: Background.java
* @Package (default package)
* @Description: Operation background of service
* @author JiangJiarong ZhangChi  
* @date 2010-12-5 13:09:05
* @version V0.1  
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @ClassName: Background
* @Description: The background of the service
* @author JiangJiarong
* @date 2010-12-5 22:44��53
*
* ${tags}
*/
public class Background
{
	private static Controller controller = new Controller();
	private static MessageAndError formattedMessage;
	private static String inputCommand;
	
	/**
	* @Title: main(String arg[])
	* @Description: main function
	* @param  all
	* @return void
	* @throws void
	*/
	public static void main(String arg[])
	{	
		showWelcomeMessage();
		serve();
	}
	
	/**
	* @Title: showWelcomeMessage()
	* @Description: show welcome message
	* @param  all
	* @return void
	* @throws void
	*/
	private static void showWelcomeMessage()
	{
		System.out.println("\t\t\t��ӭ������Ѷ�� e0.1\n" +
				"���" +
				"�û���¼--1\t�û�ע��--2\t�޸��û�����--21\t" +
				"����ע��--3\n�޸���������--31 \t������Ż--4\t��ѯ���Ż--5\t" +
				"�˳�--0");
	}
	
	/**
	* @Title: serve()
	* @Description: offer the interface of the program
	* @param  all
	* @return void
	* @throws IOException
	*/
	private static void serve()
	{
		while(true)
		{
			System.out.println("���������");
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(input);
			try {
				inputCommand = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			returnServeMessage();
		}
	}
	
	/**
	* @Title: returnServeMessage()
	* @Description: return the serve message
	* @param  all
	* @return void
	* @throws void
	*/
	private static void returnServeMessage()
	{
		formattedMessage=controller.receive(inputCommand);
		returnCommandMessage(formattedMessage);
	}
	
	/**
	* @Title: returnCommandMessage(MessageAndError Message)
	* @Description: return the message response of command
	* @param  all
	* @return void
	* @throws void
	*/
	private static void returnCommandMessage(MessageAndError Message) {
		switch(Message)
		{
			case SUCCESS:
				System.out.println("�����ɹ����!");
				break;
			case ERROR_COMMAND:
				System.out.println("�޷�ʶ�������!");
				break;
			case ERROR_LOGIN:
				System.out.println("��¼ʧ�ܣ��û��������벻��ȷ!");
				break;
			case ERROR_REGISTER:
				System.out.println("ע��ʧ�ܣ��û����Ѵ��ڻ��������ȷ!");
				break;
			case ERROR_CHANGEPW:
				System.out.println("�޸�����ʧ��!");
				break;
			case ERROR_DELETE:
				System.out.println("ɾ���ʧ��!");
				break;
			case ERROR_ADD:
				System.out.println("��ӻʧ��!");
				break;
			case ERROR_QUERY:
				System.out.println("��ѯ�ʧ��!");
				break;
			case SUCCESS_MESSAGE:
				System.out.println("����\t�\t����ʱ��\t\t��ʼʱ��");
				System.out.println(controller.GetReturnMessage());
				break;
			case EXIT:
				System.exit(0);
			default:
				break;
		}
	}
}
