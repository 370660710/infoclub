import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Background{
	private static Controller controller = new Controller();
	private static MessageAndError returnMessage;
	private static String command;
	
	public static void main(String arg[])
	{	
		System.out.println("请输入命令：");
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
				System.out.println("操作成功完成!");
				break;
			case ERROR_COMMAND:
				System.out.println("无法识别的命令!");
				break;
			case ERROR_LOGIN:
				System.out.println("登录失败，用户名或密码不正确!");
				break;
			case ERROR_REGISTER:
				System.out.println("注册失败，用户名已存在或参数不正确!");
				break;
			case ERROR_CHANGEPW:
				System.out.println("修改密码失败!");
				break;
			case ERROR_DELETE:
				System.out.println("删除活动失败!");
				break;
			case ERROR_ADD:
				System.out.println("添加活动失败!");
				break;
			case ERROR_QUERY:
				System.out.println("查询活动失败!");
				break;
			case SUCCESS_MESSAGE:
				System.out.println("社团\t活动\t报名时间\t\t开始时间");
				System.out.println(controller.GetReturnMsg());
				break;
			case EXIT:
				System.exit(0);
			default:
				break;
		}
	}
}
