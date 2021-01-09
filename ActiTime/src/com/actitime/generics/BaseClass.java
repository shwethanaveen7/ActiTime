package com.actitime.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.objectRepository.EnterTimeTrackPage;
import com.actitime.objectRepository.LoginPage;

import java.io.IOException;
import java.util.concurrent.*;

public class BaseClass {
static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
public WebDriver driver; //Declaration outside the class
@BeforeClass
public void openBrowser() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
@AfterClass
public void CloseBrowser() {
	driver.close();
}
@BeforeMethod
public void login() throws IOException {
	FileLib f=new FileLib();
	String un = f.getPropertyValue("username");
	String pw = f.getPropertyValue("password");
	driver.get(f.getPropertyValue("url"));
	LoginPage l=new LoginPage(driver);
	l.setLogin(un,pw);
}
@AfterMethod
	public void logout() {
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.setLogoutlink();
	}
}
