
import org.easymock.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class loginTest {
	
	private static final int TIMEOUT=100;
	@SuppressWarnings("deprecation")
	@Test(timeout = TIMEOUT)
	public void testLoginIn()
	{
		UserManager mc = EasyMock.createMock(UserManager.class);
		EasyMock.expect(mc.userLogin("admin", "12345")).andReturn(new User("1","1"));
		EasyMock.replay(mc);
		Controller c = new Controller();
		assertEquals("LogIn","SUCCESS",c.receive("1"));
	}	
}
