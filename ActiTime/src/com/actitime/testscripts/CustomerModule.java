package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.objectRepository.EnterTimeTrackPage;
import com.actitime.objectRepository.TaskListPage;

public class CustomerModule extends BaseClass {
@Test
public void testCreatCustomer() throws EncryptedDocumentException, IOException {
	FileLib f=new FileLib();
	String customerName = f.getExcelValue("createCustomer", 1, 5);
	String customerDescription = f.getExcelValue("createCustomer", 1, 6);
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.getTasktab().click();
	
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	
	t.getNewCustomerOption().click();
	
	t.getEnterCustomertbx().sendKeys(customerName);
	
	t.getEnterCustomerDescriptiontbx().sendKeys(customerDescription);
	
	t.getSelectCustomerDropDown().click();
	
	t.getOurCompanyOption().click();
	
	t.getCreateCustomerBtn().click();
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerCreated(), customerName));
	String ActualCustomer = t.getActualCustomerCreated().getText();
	Assert.assertEquals(ActualCustomer, customerName);
}
	
}
