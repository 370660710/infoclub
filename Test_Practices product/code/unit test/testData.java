import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;



public class testData {

	private static final int TIMEOUT= 100;
	@Test (timeout = TIMEOUT)
	public void testAddDays()
	{
		Date testDate = new Date(2010,12,31);
		testDate.AddDays(4);
		Date comDate = new Date(2011,1,4);
		assertTrue("AddDays",testDate.equals(comDate));
	}
	
	@Test(timeout = TIMEOUT)
	public void testEquals()
	{
		Date testDate = new Date(2010,1,1);
		Date comDate = new Date(2010,1,10);
		assertTrue("Equals(the same day)",testDate.equals(testDate));
		assertFalse("NotEquals",testDate.equals(comDate));
	}
	
	@Test(timeout = TIMEOUT)
	public void testCalcDay()
	{
		Date testDate = new Date(0,1,12);
		assertEquals("12days",12,testDate.CalcDays());
	}
	
	@Test(timeout = TIMEOUT)
	public void testDateIntIntInt() {
		Date date1=new Date(2000,1,1);
		Date date2=new Date(2000,1,1);
		assertTrue(date1.equals(date2));
	}

	@Test(timeout = TIMEOUT)
	public void testDate() {
		Date date1=new Date(2000,1,1);
		Date date2=new Date();
		assertTrue(date1.equals(date2));
	}

	@Test(timeout = TIMEOUT)
	public void testGetDay() {
		Date date=new Date(2012,1,2);
		assertEquals(date.GetDay(),2);
	}

	@Test(timeout = TIMEOUT)
	public void testGetMonth() {
		Date date=new Date(2012,1,2);
		assertEquals(date.GetMonth(),1);
	}

	@Test(timeout = TIMEOUT)
	public void testGetYear() {
		Date date=new Date(2012,1,2);
		assertEquals(date.GetYear(),2012);
	}

	@Test(timeout = TIMEOUT)
	public void testDaysInMonth() {
		Date date=new Date(2000,2,2);
		assertEquals(29,date.DaysInMonth());		
	}

	@Test(timeout = TIMEOUT)
	public void testDaysInMonthInt() {
		Date date=new Date(2000,1,2);
		assertEquals(date.DaysInMonth(2),29);
	}

	@Test(timeout = TIMEOUT)
	public void testIsLeapYear() {
		Date date=new Date(2000,1,2);
		assertTrue(date.IsLeapYear());
	}

	//@Ignore("bug not fixed")
	@Test(timeout = TIMEOUT)
	public void testDayOfWeek() {
		Date date=new Date(2011,1,7);
		assertEquals("Friday",date.dayOfWeek());
	}

	@Test(timeout = TIMEOUT)
	public void testWeekName() {
		Date date=new Date(2011,1,7);
		assertEquals(date.WeekName(5),"Friday");
	}
}
