

/**
* @ClassName: Activity
* @Description: Contain the basic information and operation of activity
* @author LiChengqian JiangJiarong 
* @date 2010-12-6 16:40:44
*
* ${tags}
*/
public class Activity {

	private String activityName; 
	private	String joinTime; 
	private	String startTime;
	
	public	Activity(String activityName, String joinTime, String startTime) {
		this.activityName = activityName;
		this.joinTime = joinTime;
		this.startTime = startTime;
	}

	public String getName() {
		return this.activityName;
	}
	public String getJoinTime() {
		return this.joinTime;
	}
	public String getStartTime() {
		return this.startTime;
	}
	
	public String activitysToString(){
		return new String(this.activityName + "\t" + this.joinTime + "\t\t" + this.startTime);
	}
}
