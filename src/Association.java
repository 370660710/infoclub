import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Association extends User{
	private	Map<String,Activity> activityList = new HashMap<String,Activity>();
	private int activityListSize;
	public Association(String newUserName, String newPassword) {
		super(newUserName, newPassword);
		activityListSize = 0;
	}
	
	public boolean addActivity(String activityName, String joinTime, String startTime){
		if (activityList.containsKey(activityName)) {
			System.out.println("活动名已存在，请重新输入");
			return false;
		}	
		Activity p = new Activity(activityName, joinTime, startTime);
		activityList.put(activityName, p);
		activityListSize ++;
		System.out.printf("活动：%s 成功添加，报名时间为： %s ，开始时间为： %s", 
				activityName, joinTime, startTime);
		ptint();
		return true; 	
	}
	
	private void ptint(){
		 for (Iterator<String> i = activityList.keySet().iterator(); i.hasNext();) {
			   Object obj = i.next();
			   System.out.println("\nkey=" + obj + " value=" + 
					   activityList.get(obj).getName()+ " " + activityList.get(obj).getJoinTime()
					   + " " + activityList.get(obj).getStartTime());
		 }
	}

	public Activity[] queryActivity() {
		Activity[] result = new Activity[activityList.size()];
		int activityCount = 0;
		for (Iterator<String> i = activityList.keySet().iterator(); i.hasNext(); activityCount++) {
			   Object obj = i.next();
			   result[activityCount] = (Activity)activityList.get(obj);
		 }
		return result;		
	}
}

