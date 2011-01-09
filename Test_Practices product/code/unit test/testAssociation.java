
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BaiXunHui 
 * testAssociation.java
 * TODO
 * 
 * Andy
 * ÏÂÎç08:30:25
 */

/**
 * @author Andy
 *
 */
public class testAssociation {

	/**
	 * @throws java.lang.Exception
	 */
	private static final int TIMEOUT=100;
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
	 * Test method for {@link Association#Association(java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testAssociation() {
		Association sampleAssociation=new Association("userName","passWord");
		assertNotNull(sampleAssociation);
	}

	/**
	 * Test method for {@link Association#addActivity(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testAddActivity() {
		Association sampleAssociation=new Association("userName","passWord");
		boolean result = sampleAssociation.addActivity("activityName","startTime","joinTime");
		assertEquals(true,result);
	}

	/**
	 * Test method for {@link Association#queryActivity()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testQueryActivity() {
		Association sampleAssociation=new Association("userName","passWord");
		assertNotNull(sampleAssociation.queryActivity());
	}

}
