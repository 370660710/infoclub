import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Field;
import org.junit.*;

public class testUser {	
	private static final int TIMEOUT=100;
	@Test(timeout = TIMEOUT)
	public void testUserConstruct() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		User testUser = new User("Done","12345");		
		Class sampleUserClass = testUser.getClass();
		Field field1 = sampleUserClass.getDeclaredField("userName");
		Field field2 = sampleUserClass.getDeclaredField("password");
		field1.setAccessible(true);
		field2.setAccessible(true);
		assertEquals("name","Done",field1.get(testUser));
		assertEquals("password","12345",field2.get(testUser));
	}
	
	@Test(timeout = TIMEOUT)
	public void testUserComparePassword()
	{
		User testUser = new User("Done","12345");
		assertTrue("passwordCompare",testUser.ComparePassword("12345"));
	}
	
	@Test(timeout = TIMEOUT)
	public void testUserSetPassword()
	{
		User testUser = new User("Done","12345");
		testUser.SetPassword("abcde");
		assertTrue("serPassword",testUser.ComparePassword("abcde"));
	}
	
}
