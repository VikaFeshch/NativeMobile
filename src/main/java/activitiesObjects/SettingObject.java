package activitiesObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingObject {
    static AndroidDriver driver;

    public SettingObject(AndroidDriver driver) {

        this.driver = driver;
    }

    By timeFormatButton = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");
    By temperatureButton = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By speedButton = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By listSpeedMetrics = By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
    By notificationBut = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusBarBut = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By doneBut = By.id("com.weather.forecast.weatherchannel:id/tvDone");

 /*   public void clickDoneBut(){
        MobileElement doneButton = (MobileElement) driver.findElement(doneBut);
        doneButton.click();
    }*/
    public void selectSpeedMetric(SPEED speed) {
        MobileElement tempButton = (MobileElement) driver.findElement(speedButton);
        if (!tempButton.getText().equals(speed.getSp())) {
            tempButton.click();
            MobileElement listMetrics=(MobileElement) new WebDriverWait(driver,10)
                    .until(ExpectedConditions.presenceOfElementLocated(listSpeedMetrics));

            for (MobileElement l : listMetrics.findElements(By.className("android.widget.LinearLayout"))) {
                if(l.findElement(By.className("android.widget.TextView")).getAttribute("text").equals(speed.getSp())){
                    l.click();
                    break;
                }
            }
        }
    }

    public void temSelect(TEMP temp) {
        MobileElement tempButton = (MobileElement) driver.findElement(temperatureButton);
        switch (temp) {
            case C -> {
                if (tempButton.getAttribute("checked").equals("true")) {
                    tempButton.click();
                }
            }
            case F -> {
                if (tempButton.getAttribute("checked").equals("false")) {
                    tempButton.click();
                }
            }
        }
    }
    public void statusBarSelect(SETCHECKBOX setStatBarBut) {
        MobileElement statBarButton = (MobileElement) driver.findElement(statusBarBut);
        switch (setStatBarBut) {
            case TRUE  -> {
                if (statBarButton.getAttribute("checked").equals("false")) {
                    statBarButton.click();
               }
            }
            case FALSE -> {
                if (statBarButton.getAttribute("checked").equals("true")) {
                    statBarButton.click();
                }
            }
        }
    }
    public void notifSelect(SETCHECKBOX setNotifBut) {
        MobileElement notifButton = (MobileElement) driver.findElement(notificationBut);
        switch (setNotifBut) {
            case TRUE  -> {
                if (notifButton.getAttribute("checked").equals("false")) {
                    notifButton.click();
                }
            }
            case FALSE -> {
                if (notifButton.getAttribute("checked").equals("true")) {
                    notifButton.click();
                }
            }
        }
    }
    public void timeSelect(TIME time){
        MobileElement timeButton = (MobileElement) driver.findElement(timeFormatButton);
        switch (time){
            case TWELVE -> {
                if(timeButton.getAttribute("checked").equals("false")){
                    timeButton.click();
                }
            }
            case TWENTY_FOUR -> {
                if(timeButton.getAttribute("checked").equals("true")){
                    timeButton.click();
                }
            }
        }
    }

    public enum TIME{
        TWELVE, TWENTY_FOUR;
    }
    public enum TEMP {
        C, F;
    }

    public enum SPEED {
        MPH("mph"),KM("km/h"), M("m/s"), KNOTS("knots"), FTS("ft/s");

        public String getSp() {
            return sp;
        }

        String sp;

        SPEED(String s) {
            sp = s;
        }
    }

    public enum SETCHECKBOX{
        TRUE,FALSE;
    }
}
