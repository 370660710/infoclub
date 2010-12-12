/**  
* @Title: Time.java
* @Package (default package)
* @Description: Traditional date file
* @author LiChengqian
* @date 2010-12-6 16:02:29
* @version V0.1  
*/

/**
* @ClassName: Time
* @Description: Contain the basic information and operation of activity
* @author LiChengqian JiangJiarong 
* @date 2010-12-6 16:04：15
*
* ${tags}
*/
class Time
{
	private int daysOfMonth[]; 
	private int day,month,year,hour,minute;
	
	public Time()
	{		
		daysOfMonth[1] = 31; 
		daysOfMonth[2] = 28; 
		daysOfMonth[3] = 31; 
		daysOfMonth[4] = 30; 
		daysOfMonth[5] = 31; 
		daysOfMonth[6] = 30; 
		daysOfMonth[7] = 31; 
		daysOfMonth[8] = 31; 
		daysOfMonth[9] = 30; 
		daysOfMonth[10] = 31; 
		daysOfMonth[11] = 30; 
		daysOfMonth[12] = 31; 
	}

	/**
	* @Title: dateSet(String date)
	* @Description: set data
	* @param  all
	* @return boolean
	* @throws void
	*/
	public boolean dateSet(String date)
	{
		if(!dateFormatCheck(date))
			return false;
		date = dateReform(date);
		if(date == "")
			return false;
		dateStringToInt(date);
		setDaysOfFebruary();
		if(!dateExist())
			return false;	
		return true;
	}	

	/**
	* @Title: dateFormatCheck(String x)
	* @Description: check the format of date
	* @param  all
	* @return boolean
	* @throws void
	*/
	private boolean dateFormatCheck(String x)
	{
		if (x.length() != 16) 
		{
			System.out.printf("日期输入错误:字符串长度错误\n");
			return false; 
		}
		if (x.charAt(4) != '/' || x.charAt(7) != '/' || x.charAt(10) != '/' || x.charAt(13) != '/') 
		{
			System.out.printf("日期格式输入错误\n");
			return false; 
		}
		return true;
	}

	/**
	* @Title: main(String arg[])
	* @Description: main function
	* @param  all
	* @return void
	* @throws void
	*/
	private String dateReform(String date)
	{		
		String DateInNumForm =  date.substring(0, 4) +
								date.substring(5, 7) +
								date.substring(8, 10) +
								date.substring(11);
		int i;
		for (i = 0; i<12; i++)
		if (DateInNumForm.charAt(i)<'0' || DateInNumForm.charAt(i)>'9')  
		{
			System.out.printf("日期输入错误:有非数字出现\n");
			return "";
		}
		return DateInNumForm;
	}

	/**
	* @Title: dateStringToInt(String x)
	* @Description: change the date form string to int
	* @param  all
	* @return void
	* @throws void
	*/
	private void dateStringToInt(String x)
	{
		year = (x.charAt(0) - '0') * 1000 + (x.charAt(1) - '0') * 100 + (x.charAt(2) - '0') * 10 + x.charAt(3) - '0'; 
		month = (x.charAt(4) - '0') * 10 + x.charAt(5) - '0'; 
		day = (x.charAt(6) - '0') * 10 + x.charAt(7) - '0'; 
		hour = (x.charAt(8) - '0') * 10 + x.charAt(9) - '0'; 
		minute = (x.charAt(10) - '0') * 10 + x.charAt(11) - '0'; 
	}

	/**
	* @Title: dateExist()
	* @Description: check whether the date is legal
	* @param  all
	* @return boolean
	* @throws void
	*/
	private boolean dateExist()
	{		
		if (month > 12 || month < 1) 
		{ 
			System.out.printf("日期输入错误：月份输入错误\n");
			return false; 
		}
		
		if (day > daysOfMonth[month] || day < 1) 
		{
			System.out.printf("日期输入错误：日份输入错误\n");
			return false; 
		}
		if (hour > 23 || hour < 0) 
		{
			System.out.printf("日期输入错误：小时数输入错误\n");
			return false; 
		}
		if (minute > 59 || minute < 0) 
		{ 
			System.out.printf("日期输入错误：分钟数输入错误\n");
			return false; 
		}
		return true;
	}

	/**
	* @Title: setDaysOfFebruary()
	* @Description: set the days of February
	* @param  all
	* @return void
	* @throws void
	*/
	private void setDaysOfFebruary()
	{
		if (year%400 == 0 || year%4 == 0 && year%100 != 0)
			daysOfMonth[2] = 29; 
		else 
			daysOfMonth[2] = 28; 
	}
}