package configuration;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseClass {
    public static AndroidDriver driver;
    @BeforeClass
    public static void bb(){
        if (driver==null){
            driver=Config.setUp(LISTDEV.PIXELNATIVE);
        }
    }
    @AfterClass
    public static void a() throws InterruptedException {
        Thread.sleep(10000);
        if (driver!=null){
            driver.quit();
        }
    }
}
