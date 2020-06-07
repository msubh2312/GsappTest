package Academy.GSAppTest;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.page1;

public class shop extends base{
	public static AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("rawtypes")
	public static TouchAction t;
	public static page1 pg1;
	public static utilities uti;
	public static AppiumDriverLocalService service;
	

	@Test
	public static void page1Test() throws InterruptedException, IOException {
		 service=startServer();
			driver = Capabilities("GeneralStoreApp");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.hideKeyboard();
			t=new TouchAction(driver);
			 pg1=new page1(driver);
			 uti=new utilities(driver);
		t.tap(tapOptions().withElement(element(pg1.getGender()))).perform();
		t.tap(tapOptions().withElement(element(pg1.getDropDown()))).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		t.tap(tapOptions().withElement(element(pg1.getCountry()))).perform();	
		t.tap(tapOptions().withElement(element(pg1.LetsShopBtn))).perform();	
		System.out.println(pg1.toast.getAttribute("name"));
		pg1.getName().sendKeys("Subh");
		t.tap(tapOptions().withElement(element(driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))))).perform();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))"));public static void page2Test() throws InterruptedException, IOException {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"PG 3\"));");
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		uti.addItem(count, "PG 3");
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Air Jordan 9 Retro\"));");
		int count1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		uti.addItem(count1, "Air Jordan 9 Retro");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		double price1, total = 0;
		int count2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0; i<count2;i++) {
			String texts1= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			price1 =Double.parseDouble(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
			if(texts1.equalsIgnoreCase("Air Jordan 9 Retro")||texts1.equalsIgnoreCase("PG 3"))
			{
				System.out.println(texts1+" : $"+price1);
				total+=price1;
				
			}
		}
		double total1=Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(2));
		//Assert.assertFalse(total==total1);
		System.out.println("Total : $"+total);
		t.longPress(longPressOptions().withElement(element(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")))).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElement(By.id("android:id/message")).getText());
		t.tap(tapOptions().withElement(element(driver.findElement(By.id("android:id/button1"))))).perform();
		t.tap(tapOptions().withElement(element(driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"))))).perform();
		Thread.sleep(7000l);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(7000l);
		System.out.println(driver.findElement(By.xpath("//img[@id='hplogo']")).getAttribute("alt"));
		Assert.assertEquals(driver.findElement(By.cssSelector("img#hplogo")).getAttribute("alt"), "Google");
		driver.findElement(By.name("q")).sendKeys("hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000l);
		driver.context("NATIVE_APP");
		service.stop();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		
		
		
	}
}

