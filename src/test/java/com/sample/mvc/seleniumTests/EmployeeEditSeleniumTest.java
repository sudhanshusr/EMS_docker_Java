package com.sample.mvc.seleniumTests;




import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeEditSeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://172.27.59.96:8080/EMS_Hibernate1/list";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEdit() throws Exception {
    driver.get(baseUrl + "");
   
    driver.findElement(By.xpath("(//a[contains(text(),'edit')])[1]")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Ruuuu");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("Viiiii");
    driver.findElement(By.id("EditEmployee")).click();
 
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }

 
}

