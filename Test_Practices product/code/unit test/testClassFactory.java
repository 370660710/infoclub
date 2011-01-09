import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * BaiXunHui 
 * testClassFactory.java
 * TODO
 * 
 * Andy
 * ÉÏÎç12:19:40
 */

/**
 * @author Andy
 *
 */
public class testClassFactory {

	private static final int TIMEOUT= 100;
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
	 * Test method for {@link ClassFactory#bornDate()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornDate() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornDate() instanceof Date);
		
	}

	/**
	 * Test method for {@link ClassFactory#bornDate(int, int, int)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornDateIntIntInt() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornDate(1,1,1) instanceof Date);
	}

	/**
	 * Test method for {@link ClassFactory#bornUser(java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornUser() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornUser("name","password") instanceof User);
	}

	/**
	 * Test method for {@link ClassFactory#bornUserManager()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornUserManager() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornUserManager() instanceof UserManager);
	}

	/**
	 * Test method for {@link ClassFactory#bornTime()}.
	 */
	@Ignore("bug not fixed")
	@Test(timeout = TIMEOUT)
	public void testBornTime() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornTime() instanceof Time);
	}

	/**
	 * Test method for {@link ClassFactory#bornController()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornController() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornController() instanceof Controller);
	}

	/**
	 * Test method for {@link ClassFactory#bornBackground()}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornBackground() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornBackground() instanceof Background);
	}

	/**
	 * Test method for {@link ClassFactory#bornAssociation(java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornAssociation() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornAssociation("name","password") instanceof Association);
	}

	/**
	 * Test method for {@link ClassFactory#bornActivity(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test(timeout = TIMEOUT)
	public void testBornActivity() {
		ClassFactory sampleClassFactory = new ClassFactory();
		assertTrue(sampleClassFactory.bornActivity("name","starttime","jointime") instanceof Activity);
	}

}
