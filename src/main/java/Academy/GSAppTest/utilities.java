package Academy.GSAppTest;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class utilities {

	private AndroidDriver<AndroidElement> driver;

	public utilities(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	public void addItem(int count, String item) {
		for(int i=0; i<count;i++) {
			String texts1= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(texts1.equalsIgnoreCase(item))
			{
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
	}

}
