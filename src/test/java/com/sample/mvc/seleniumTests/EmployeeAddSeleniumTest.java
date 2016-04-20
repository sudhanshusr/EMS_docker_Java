package com.sample.mvc.seleniumTests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class EmployeeAddSeleniumTest {
	/**private WebDriver driver;*/
	private HtmlUnitDriver driver;
	private String baseUrl;
	private String ipAddress;

	@Before
	public void setUp() throws Exception {
		/**driver = new FirefoxDriver();*/
		driver=new HtmlUnitDriver();
		ipAddress =  System.getProperty("ipAddress"); 
		baseUrl = ipAddress+"/EmployeeApplication/jsp/add.jsp";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCheck() throws Exception {
		driver.get(baseUrl + "");
	    driver.findElement(By.name("code")).clear();
	    driver.findElement(By.name("code")).sendKeys("423");
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Rahul");
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys("Pune");
	    driver.findElement(By.id("SubmitEmployee")).click();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

}
