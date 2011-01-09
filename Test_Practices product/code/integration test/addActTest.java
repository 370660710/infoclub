
import org.easymock.EasyMock;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.hamcrest.core.Is;
public class addActTest {
	
	private static final int TIMEOUT=100;
	@Test(timeout = TIMEOUT)
	public void testAddAct()
	{
		Association mc = EasyMock.createMock(Association.class);
		EasyMock.expect(mc.addActivity("1758", "2010/12/10","2010/12/24")).andReturn(true);
		EasyMock.replay(mc);
		Controller c = new Controller();
		assertEquals("LogIn","SUCCESS",c.receive("4"));
	}	
}
