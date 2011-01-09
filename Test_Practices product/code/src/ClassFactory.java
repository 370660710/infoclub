/**
* @ClassName: ClassFactory
* @Description: born class needed form this class
* @author LiChengqian
* @date 2010-1-2 23:23:04
*
* ${tags}
*/

public class ClassFactory {
	public static Date bornDate()
	{
		Date date=new Date();
		return date;		
	}
	public static Date bornDate(int year,int month,int day)
	{
		Date date=new Date(year,month,day);
		return date;		
	}
	public static User bornUser(String name,String password)
	{
		User user=new User(name,password);
		return user;
	}
	public static UserManager bornUserManager()
	{
		UserManager userManager=new UserManager();
		return userManager;
	}
	public static Time bornTime()
	{
		Time time=new Time();
		return time;
	}
	public static Controller bornController()
	{
		Controller controller=new Controller();
		return controller;
	}
	public static Background bornBackground()
	{
		Background background=new Background();
		return background;
	}
	public static Association bornAssociation(String name, String password)
	{
		Association association=new Association(name,password);
		return association;
	}
	public static Activity bornActivity(String activityName, String joinTime, String startTime)
	{
		Activity activity=new Activity(activityName,joinTime,startTime);
		return activity;
	}
}
