package HybridApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HybridApps.GeneralcapabilitiesHybrid;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore extends GeneralcapabilitiesHybrid {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void Start() throws MalformedURLException {
		
		driver = cap();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@Test
	public void gs() {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Somala");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		 //driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		driver.findElements(MobileBy.AndroidUIAutomator(" UiSelector().text(\"ADD TO CART\")")).get(0).click();
		driver.findElements(MobileBy.AndroidUIAutomator(" UiSelector().text(\"ADD TO CART\")")).get(0).click();
		
		//driver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))")).get(0).click();
		//driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(1).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		 String oneamount = driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"$160.97\")")).getText();
		 String oneamount1 = driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"$120.0\")")).getText();
		 System.out.println(oneamount);
		 System.out.println(oneamount1);
		 String amount = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		 System.out.println("Total Purchase Amount:"+amount);
		
		 String p1=oneamount.substring(1);//160.97
		 String p2=oneamount1.substring(1);//120.0
		 String totalprice= amount.substring(2);//280.97
	
		 Double prod1 =Double.parseDouble(p1);
		 System.out.println(prod1);
		 
		 Double prod2 = Double.parseDouble(p2);
		 System.out.println(prod2);
		 
		 Double prod3 = Double.parseDouble(totalprice);
		 System.out.println(prod3);
		 
		 Double TOTAL=prod1+prod2;
		 System.out.println(TOTAL);
		 if (TOTAL.equals(prod3)) {
			System.out.println("Cost matching");
		}
		 else {
			System.out.println("Cost not matching");
		}
		
		
	}
}
