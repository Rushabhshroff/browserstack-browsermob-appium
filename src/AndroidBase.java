import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBase {

    public static AppiumDriver driver;
    public UiAutomator2Options options;
    public HashMap<String, Object> browserstackOptions;

    @BeforeMethod
    public void setUp() throws MalformedURLException
    {
        BrowserMob.StartProxy();
        options = new UiAutomator2Options();
        driver = new AndroidDriver(new URL("http://localhost:47474"),options);

        System.out.println("Driver launched successfully");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        System.out.println("Driver quit successfully");
    }
}






