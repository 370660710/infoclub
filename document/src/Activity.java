
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
		return activityName;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public String getStartTime() {
		return startTime;
	}
	
	public String activitysToString(){
		return new String(activityName + "\t" + joinTime + "\t\t" + startTime);
	}
}
