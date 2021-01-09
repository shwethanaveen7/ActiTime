package com.actitime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
    @FindBy(xpath="//div[.='Add New']")
    private WebElement AddNewBtn;
    
    @FindBy(xpath="//div[@class='item createNewCustomer']")
    private WebElement NewCustomerOption;
    
    @FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
    private WebElement EnterCustomertbx;
    
    @FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
    private WebElement EnterCustomerDescriptiontbx;
    
    @FindBy(xpath="//div[@class='emptySelection']")
    private WebElement SelectCustomerDropDown;
    
    @FindBy(xpath="//div[.='Our company' and @class='itemRow cpItemRow ']")
	private WebElement OurCompanyOption;
    
    @FindBy(xpath="//div[.='Create Customer']")
    private WebElement CreateCustomerbtn;
    
    @FindBy(xpath="//div[@class='titleEditButtonContainer']")
    private WebElement ActualCustomerCreated;
    
    public TaskListPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);	
    	}

    	public WebElement getAddNewBtn() {
    		return AddNewBtn;
    	}

    	public WebElement getNewCustomerOption() {
    		return NewCustomerOption;
    	}

    	public WebElement getEnterCustomertbx() {
    		return EnterCustomertbx;
    	}

    	public WebElement getEnterCustomerDescriptiontbx() {
    		return EnterCustomerDescriptiontbx;
    	}

    	public WebElement getSelectCustomerDropDown() {
    		return SelectCustomerDropDown;
    	}

    	public WebElement getOurCompanyOption() {
    		return OurCompanyOption;
    	}

    	public WebElement getCreateCustomerBtn() {
    		return CreateCustomerbtn;
    	}
    	public WebElement getActualCustomerCreated() {
    		return ActualCustomerCreated;
    	}

}