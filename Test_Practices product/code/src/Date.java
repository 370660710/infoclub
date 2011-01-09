
public class Date {
	public Date(int year,int month,int day)
	{
		this.year=year;
		this.month = month;
		this.day = day;
	}
	public Date()
	{
		year=2000;
		month=1;
		day=1;
	}
	public int GetDay()
	{
		return day;
	}
	public int GetMonth()
	{
		return month;
	}
	public int GetYear()
	{
		return year;
	}
	public int DaysInMonth()
	{
		int[] daysInMonth={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(IsLeapYear())daysInMonth[2]=29;
		return daysInMonth[month];
	}
	public int DaysInMonth(int month)
	{
		int[] daysInMonth={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(IsLeapYear())daysInMonth[2]=29;
		return daysInMonth[month];
	}
	public boolean IsLeapYear()
	{
		return year%400==0 || year%100!=0 && year % 4==0;
	}
	public String dayOfWeek()
	{
		int calcDays=CalcDays();
		int calcDays20110109=CalcDays(2011,1,9);
		int difference=((calcDays-calcDays20110109)/7+7)/7;		
		return WeekName(difference);
	}
	public String WeekName(int num)
	{
		String[] weekName={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		return weekName[num];
	}

//////////////////////////////////////////////////////////////////	
	public int CalcDays()
	{
		int ret=day,i;
		for(i=1;i<month;i++)ret+=DaysInMonth(i);		
		ret+=365*year+(year+1)/4-(year+1)/100+(year+1)/400;
		return ret;
	}
	public int CalcDays(int year,int month,int day)
	{
		int ret=day,i;
		for(i=1;i<month;i++)ret+=DaysInMonth(i);		
		ret+=365*year+(year+1)/4-(year+1)/100+(year+1)/400;
		return ret;
	}
	public void NextDay()
	{
		day++;
		if(day>DaysInMonth())NextMonth();
	}
	public void NextMonth()
	{
		month++;
		if(month>=13)NextYear();
		day=1;
	}
	public void NextYear()
	{
		day=1;
		month=1;
		year++;
	}
	public String ToString()
	{
		String ret="";
		ret=IntToString(year)+"/"+IntToString(month)+"/"+IntToString(day);
		return ret;
	}
	public String IntToString(int num)
	{
		String ret="";
		while(num>=0)
		{
			ret=num%10+'0'+ret;
			num/=10;
		}
		return ret;
	}
	public boolean equals(Date o)
	{
		return year==o.GetYear() && month==o.GetMonth() && day==o.GetDay();
	}
	public void AddDays(int days)
	{
		int i;
		for(i=0;i<days;i++)NextDay();	
	}
	private int year,month,day;
}
