import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * BaiXunHui 
 * testController.java
 * TODO
 * 
 * Andy
 * ÏÂÎç11:36:20
 */

/**
 * @author Andy
 *
 */
public class testController {

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
	 * Test method for {@link Controller#Controller()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testController() {
		Controller sampleController = new Controller();
		assertNotNull(sampleController);
	}

	/**
	 * Test method for {@link Controller#receive(java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testReceive() {
		Controller sampleController = new Controller();
		assertEquals(MessageAndError.EXIT,sampleController.receive("0"));
	}

	/**
	 * Test method for {@link Controller#StringToTime(java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testStringToTime() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link Controller#GetReturnMessage()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testGetReturnMessage() {
		Controller sampleController = new Controller();
		assertEquals("",sampleController.GetReturnMessage());
	}

}
