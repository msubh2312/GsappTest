package Academy.GSAppTest;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.apiDemosPage;

public class ApiDemos extends base {
	public static AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("rawtypes")
	public static TouchAction t;
	public static apiDemosPage adp;
	public static AppiumDriverLocalService service;

	@Test
	public void DragDropTest() throws IOException, InterruptedException
	{
		service=startServer();
		driver = Capabilities("ApiDemoApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.hideKeyboard();
		t=new TouchAction(driver);
		 adp=new apiDemosPage(driver);
		
		t.tap(tapOptions().withElement(element(adp.getView()))).perform();
		t.tap(tapOptions().withElement(element(adp.getdragDrop()))).perform();
		//t.longPress(element(driver.findElements(By.className("android.view.View")).get(0))).moveTo(element(driver.findElements(By.className("android.view.View")).get(1))).release().perform();
		adp.DragnDrop(driver);
		service.stop();
	}
	

}
