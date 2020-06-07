package pageObjects;

import static io.appium.java_client.touch.offset.ElementOption.element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class apiDemosPage {
	public apiDemosPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	private WebElement viewtag;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
	private WebElement dragDrop;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	private WebElement from;
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_3")
	private WebElement to;
	
	public WebElement getView() {
		return viewtag;
	}
	
	public WebElement getdragDrop() {
		return dragDrop;
	}
	public void DragnDrop(AndroidDriver<AndroidElement> driver) {
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		t.longPress(element(from)).moveTo(element(to)).release().perform();
		
	}
	
	

}
