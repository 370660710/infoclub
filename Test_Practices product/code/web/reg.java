package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class reg extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testReg() throws Exception {
		selenium.open("/baixunhui/index.jsp");
		selenium.click("link=注册");
		selenium.waitForPageToLoad("30000");
		selenium.type("userName", "zzz");
		selenium.type("password", "123");
		selenium.type("confirmpassword", "123");
		selenium.type("email", "zzz");
		selenium.type("phone", "123");
		selenium.type("qq", "123");
		selenium.click("//input[@value='提交']");
		selenium.waitForPageToLoad("30000");
		selenium.type("userName", "xxx");
		selenium.type("password", "123");
		selenium.type("confirmpassword", "123");
		selenium.type("email", "xxx");
		selenium.type("phone", "123");
		selenium.type("qq", "123");
		selenium.click("//input[@value='提交']");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
