package com.sample.mvc.seleniumTests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class EmployeeDeleteSeleniumTest {
  /**private WebDriver driver;*/
  private HtmlUnitDriver driver;
  private String baseUrl;
  private String ipAddress;
  @Before
  public void setUp() throws Exception {
    /**driver = new FirefoxDriver();*/
	driver=new HtmlUnitDriver();
    ipAddress =  System.getProperty("ipAddress"); 
	baseUrl = ipAddress+"/EmployeeApplication/list";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEdit() throws Exception {
    driver.get(baseUrl + "");
   
    driver.findElement(By.xpath("(//a[contains(text(),'delete')])[1]")).click();

   
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }

 
}
 