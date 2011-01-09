import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class testUserManager {

	private static final int TIMEOUT=100;
	@Test(timeout = TIMEOUT)
	public void testUsersRegister()
	{
		UserManager testUserManager = new UserManager();
		assertTrue("Registe",testUserManager.userRegister("Done", "12345"));
		assertFalse("Registe",testUserManager.userRegister("Done", "12345"));
	}
	
	@Test(timeout = TIMEOUT)
	public void testUsersChangePassword()
	{

		UserManager testUserManager = new UserManager();
		testUserManager.userRegister("Done", "12345");
		testUserManager.userRegister("Well", "00000");
		assertFalse("ChangePw",testUserManager.changePassword("vnekwsl", "00000", "54321"));
		assertFalse("ChangePw",testUserManager.changePassword("Done", "123", "11"));
		assertTrue("ChangePw",testUserManager.changePassword("Done", "12345", "11111"));
		assertTrue("CheckChangedPw",testUserManager.findUserByName("Done").ComparePassword("11111"));
	}
}
