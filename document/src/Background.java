import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Background{
	private static Controller controller = new Controller();
	private static MessageAndError returnMessage;
	private static String command;
	
	public static void main(String arg[])
	{	
		System.out.println("���������");
		while(true)
		{
			InputStreamReader in = null;
			BufferedReader br = null;
			in = new InputStreamReader(System.in);
			br = new BufferedReader(in);
			try {
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			returnMessage = controller.parseCommand(command);

			parseReturnMessage(returnMessage);
		}
	}

	private static void parseReturnMessage(MessageAndError Message) {
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
				System.out.println(controller.GetReturnMsg());
				break;
			case EXIT:
				System.exit(0);
			default:
				break;
		}
	}
}
