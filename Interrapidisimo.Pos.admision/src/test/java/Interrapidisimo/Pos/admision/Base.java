package Interrapidisimo.Pos.admision;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	private static WindowsDriver driver;
	Properties loadProperty = new Properties();

	  public Base (WindowsDriver driver){
	        this.driver = driver;
	    }

	  public WindowsDriver connectionDriver() throws IOException {
	        try {
	            loadProperty.load(new FileReader("Params.properties"));
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("pos", loadProperty.getProperty("appDir"));
	            capabilities.setCapability("platformName","Windows");
	            capabilities.setCapability("deviceName", "WindowsPC");
	            driver = new WindowsDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        } catch (Exception e) {
	            System.out.println("Fallo el driver");
	            e.printStackTrace();
	        }
	        return driver;
	    }

	public static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public static void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public static void click(By locator) {
		driver.findElement(locator).click();
	}

	public static boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

//	public static void closeDriver() throws IOException, InterruptedException {
//		Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
//		process.waitFor();
//		process.destroy();
//	}
}