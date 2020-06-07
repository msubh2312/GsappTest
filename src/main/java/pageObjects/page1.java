package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class page1 {

	public page1(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement gender;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement dropDown;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
	public WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShopBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement namefield;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	public WebElement toast;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> productList;
	
	public WebElement getDropDown() {
		return dropDown;
		
	}
	public WebElement getGender() {
		return gender;
		
	}
	public WebElement getName() {
		return namefield;
		
	}
	
	public WebElement getCountry() {
		return country;
		
	}
	
	
	
	

}
