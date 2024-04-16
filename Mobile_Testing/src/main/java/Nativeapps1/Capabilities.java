package Nativeapps1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.asm.Advice.Return;


public class Capabilities {
	
public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
	
	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	  dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Somala");
	  dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	  dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
	  dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
	  dc.setCapability(MobileCapabilityType.NO_RESET, true);
	  
	  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc); 
	  return driver;
		  
}
        
}

