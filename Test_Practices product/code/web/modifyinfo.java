package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class modifyinfo extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testModifyinfo() throws Exception {
		selenium.open("/baixunhui/index.jsp");
		selenium.click("link=登录");
		selenium.waitForPageToLoad("30000");
		selenium.type("userName", "123");
		selenium.type("password", "123");
		selenium.click("submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=查看帐户信息");
		selenium.selectWindow("name=mainFrame");
		selenium.click("link=我的帐户");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=修改我的E-mail地址");
		selenium.waitForPageToLoad("30000");
		selenium.type("newEmail", "456");
		selenium.click("//input[@value='提交']");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=退出登录");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
