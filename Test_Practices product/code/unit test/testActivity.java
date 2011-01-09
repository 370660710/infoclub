

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BaiXunHui 
 * testActivity.java
 * TODO
 * 
 * Andy
 * ÏÂÎç08:25:20
 */

/**
 * @author Andy
 *
 */
public class testActivity {

	private static final int TIMEOUT=100;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Activity#Activity(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testActivity() {
		Activity sampleActivity = new Activity("activityName","joinTime", "startTime");
		assertNotNull(sampleActivity);
	}

	/**
	 * Test method for {@link Activity#getName()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testGetName() {
		Activity sampleActivity = new Activity("activityName","joinTime", "startTime");
		assertEquals("activityName",sampleActivity.getName());
	}

	/**
	 * Test method for {@link Activity#getJoinTime()}.
	 */
	@Test (timeout = TIMEOUT)
	public void testGetJoinTime() {
		Activity sampleActivity = new Activity("activityName","joinTime", "startTime");
		assertEquals("joinTime",sampleActivity.getJoinTime());
	}

	/**
	 * Test method for {@link Activity#getStartTime()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testGetStartTime() {
		Activity sampleActivity = new Activity("activityName","joinTime", "startTime");
		assertEquals("startTime",sampleActivity.getStartTime());
	}

	/**
	 * Test method for {@link Activity#activitysToString()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testActivitysToString() {
		Activity sampleActivity = new Activity("activityName","joinTime", "startTime");
		String expectedString=new String("activityName" + "\t" + "joinTime" + "\t\t" + "startTime");
		assertEquals(expectedString,sampleActivity.activitysToString());
	}

}
