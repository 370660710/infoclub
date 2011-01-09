package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class login extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/baixunhui/index.jsp");
		selenium.click("link=登录");
		selenium.waitForPageToLoad("30000");
		selenium.type("userName", "123");
		selenium.type("password", "111");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		selenium.type("userName", "123");
		selenium.type("password", "123");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
