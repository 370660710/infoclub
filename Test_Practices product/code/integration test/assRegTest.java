
import org.easymock.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class assRegTest {
	private static final int TIMEOUT=100;
	@Test(timeout = TIMEOUT)
	public void testAssReg()
	{
		UserManager mc = EasyMock.createMock(UserManager.class);		
		EasyMock.expect(mc.associationRegister("admin", "12345")).andReturn(true);
		EasyMock.replay(mc);
		Controller c = new Controller();
		assertEquals("LogIn","SUCCESS",c.receive("3"));
	}	
}
