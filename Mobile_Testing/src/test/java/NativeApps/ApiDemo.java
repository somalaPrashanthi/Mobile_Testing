package NativeApps;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.inject.spi.Element;

import Nativeapps1.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;
//some static imports for Touch Actions.
import static io.appium.java_client.touch.TapOptions.tapOptions;
//static import for long press.
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//static imports for elements.
import static io.appium.java_client.touch.offset.ElementOption.element;
//static imports for time.
import static java.time.Duration.ofSeconds;

public class ApiDemo extends Capabilities {
	
AndroidDriver<AndroidElement> driver;
	
	
	@BeforeTest
	public  void bt() throws MalformedURLException {
		
		 driver = cap();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = false)
	public void abc() throws InterruptedException {
		
		System.out.println("Prashanthi emulator opened");
		
		
		  driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
		  driver.findElement(MobileBy.AccessibilityId("Custom View")).click();
		  
		  driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		  Thread.sleep(2000);
		  driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
	}

	@Test(enabled = false)
	
	public void Preference() {
		
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		//There are two ways by which we can use text.
		
				//Xpath Method:
				//driver.findElement(MobileBy.xpath(“//*[@text=‘WiFi settings’]“)).click();
				
				
				//The next method that we use is using AndroidUIAutomator.
				//We use AndroidUIAutomator to identify an element using an attribute.
				//We use UiSelector method for selecting the attribute.
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
				driver.findElement(MobileBy.id("android:id/edit")).sendKeys("PrashanthiS");
				driver.findElement(MobileBy.id("android:id/button2")).click();
				
				
				
			}
			
			@Test(enabled = false)
			public void notification() {
				
				driver.openNotifications();
				driver.findElements(MobileBy.className("android.widget.ImageView")).get(3).click();
				driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
				
			}
			
			
			@Test(enabled = false)
			public void views() {
				
				System.out.println("API demo is Opened");
				
				driver.findElement(MobileBy.AccessibilityId("Views")).click();
				
				//If we want to scroll then we need three things
				//1. AndroidUIAutomator
				//2. UiScrollable
				//3. UiSelector
				//If you want to scroll to a particular element then you have to use scrollIntoView.
				
				//driver.findElement(MobileBy.AndroidUIAutomator(“new UiScrollable(new UiSelector()).scrollIntoView(text(\“WebView\“))“));
				
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"))"));
				
			}
			
			@Test(enabled = false)
			public void Recentapp() {
				
				//If we want to check that the elements are present or not then we use clickable & to check it is clickable we use:
				//UiSelector method & AndroidUIAutomator
				driver.findElement(MobileBy.AccessibilityId("Views")).click();
				AndroidElement Click = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
				
				//Click.getSize();
				System.out.println(Click.getSize());
				//driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
				
			}
			
			@Test(enabled = false)
			public void swipe() {
				
				driver.findElement(MobileBy.AccessibilityId("Views")).click();
				driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
				driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
				AndroidElement date = driver.findElement(MobileBy.AccessibilityId("12"));
				AndroidElement date1 = driver.findElement(MobileBy.AccessibilityId("5"));
				
				TouchAction ta = new TouchAction(driver);
				
				ta.longPress(longPressOptions().withElement(element(date)).withDuration(ofSeconds(5))).moveTo(element(date1)).release().perform();
				
			}

			@Test(enabled = false)
			public void drag_drop() {
				
				driver.findElement(MobileBy.AccessibilityId("Views")).click();
				driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
				AndroidElement ball1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
				AndroidElement ball2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
				
				TouchAction ta1 = new TouchAction(driver);
				
			ta1.longPress(longPressOptions().withElement(element(ball1)).withDuration(ofSeconds(5))).moveTo(element(ball2)).release().perform();
			
				
			}
			
			
			@Test(enabled = false)
			public void longPress() {
				
				driver.findElement(MobileBy.AccessibilityId("Views")).click();
				driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
				driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
				AndroidElement Fish = driver.findElements(MobileBy.className("android.widget.TextView")).get(4);
				
				TouchAction ta2 = new TouchAction(driver);
				
				ta2.longPress(longPressOptions().withElement(element(Fish)).withDuration(ofSeconds(10))).release().perform();
				
			}
			
			@Test(enabled = true)
			public void message() throws InterruptedException {
				
				driver.findElement(MobileBy.AccessibilityId("OS")).click();
				driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
				driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
				driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
				driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello Prashanthi");
				driver.findElement(MobileBy.AccessibilityId("Send")).click();
				
				//app package of the app which we want to open.
				driver.activateApp("com.google.android.apps.messaging");
				String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
				
				System.out.println(text);
//				driver.activateApp(“io.appium.android.apis”);
//				driver.pressKey(new KeyEvent(AndroidKey.BACK));
//				driver.pressKey(new KeyEvent(AndroidKey.BACK));
//				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
				driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
				Thread.sleep(3000);
				driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			
				
			}
		}
