/**  
* @Title: Association.java
* @Package (default package)
* @Description: The association class include the association operation
* @author WangMengqiong  
* @date 2010-12-8 17:02:21
* @version V0.1  
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @ClassName: Association
* @Description: Association info
* @author JiangJiarong
* @date 2010-12-5 22:44:12
*
* ${tags}
*/
public class Association extends User
{
	private	Map<String,Activity> activityList = new HashMap<String,Activity>();
	private int activityListSize;
	
	public Association(String newUserName, String newPassword)
	{
		super(newUserName, newPassword);
		activityListSize = 0;
	}
	
	/**
	* @Title: addActivity(String activityName, String joinTime, String startTime)
	* @Description: add a activity to the association
	* @param  all
	* @return boolean
	* @throws void
	*/
	public boolean addActivity(String activityName, String joinTime, String startTime)
	{
		if (activityList.containsKey(activityName)) 
		{
			System.out.println("活动名已存在，请重新输入");
			return false;
		}
		else
		{
			Activity newActivity = new Activity(activityName, joinTime, startTime);
			activityList.put(activityName, newActivity);
			activityListSize ++;
			System.out.printf("活动：%s 成功添加，报名时间为： %s ，开始时间为： %s", activityName, joinTime, startTime);
			showActivity();
			return true;
		}
	}
	
	/**
	* @Title: showActivity()
	* @Description: show all activities
	* @param  all
	* @return void
	* @throws void
	*/
	private void showActivity()
	{
		 for (Iterator<String> iterator = activityList.keySet().iterator(); iterator.hasNext();) 
		 {
			   Object obj = iterator.next();
			   System.out.println("\nkey=" + obj + " value=" + activityList.get(obj).getName()+ " " + activityList.get(obj).getJoinTime() + " " + activityList.get(obj).getStartTime());
		 }
	}

	/**
	* @Title: queryActivity()
	* @Description: show welcome message
	* @param  all
	* @return Activity[]
	* @throws void
	*/
	public Activity[] queryActivity() 
	{
		Activity[] result = new Activity[activityList.size()];
		int activityCount = 0;
		for (Iterator<String> iterator = activityList.keySet().iterator(); iterator.hasNext(); activityCount++) 
		{
			   Object obj = iterator.next();
			   result[activityCount] = (Activity)activityList.get(obj);
		 }
		return result;		
	}
}

