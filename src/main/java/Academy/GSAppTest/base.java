package Academy.GSAppTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class base {
	private static AppiumDriverLocalService service;
	private static AndroidDriver<AndroidElement> driver;
	

	public static AppiumDriverLocalService startServer() {
		boolean flag =checkIfServerIsRunnning(4723);
		if(!flag) {
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
 
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\startEmulator.bat");
		Thread.sleep(6000l);
	}
	public static AndroidDriver<AndroidElement> Capabilities(String app) throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\GSAppTest\\global.properties");
		prop.load(fis);
		
		File f=new File("src");
		File fs = new File(f,(String) prop.get(app));
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("chromedriverExecutable","C:\\chromedriver.exe");
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		startEmulator();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, System.getProperty("deviceName"));
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.get("Automation"));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"4000");//cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());//cap.setCapability("android.permission.WRITE_SECURE_SETTINGS", "true");
		driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void screenShot(String s) throws IOException
	{
		File scrnshtFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshtFile, new File("C:\\Users\\SUBH\\Desktop\\Testing Projects\\eclipse\\GSAppTest\\test-output\\"+s+".png"));
	}

}
