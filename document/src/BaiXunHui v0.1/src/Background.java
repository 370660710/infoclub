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
* @date 2010-12-5 22:44：53
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
		System.out.println("\t\t\t欢迎来到百讯会 e0.1\n" +
				"命令：" +
				"用户登录--1\t用户注册--2\t修改用户密码--21\t" +
				"社团注册--3\n修改社团密码--31 \t添加社团活动--4\t查询社团活动--5\t" +
				"退出--0");
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
			System.out.println("请输入命令：");
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
				System.out.println(controller.GetReturnMessage());
				break;
			case EXIT:
				System.exit(0);
			default:
				break;
		}
	}
}
