package com.sample.mvc.seleniumTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class abc {
  private WebDriver driver;
  private String baseUrl;
 
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.redbus.in/Booking/SelectBus.aspx?fromCityId=130&toCityId=462_2&doj=13-Jan-2015&busType=Any&opId=0&doj1=16-Jan-2015";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCheck() throws Exception {
    driver.get(baseUrl + "/EmployeeApplication/");
    driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();

  }

  
}
