import activitiesObjects.SettingObject;
import configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNative extends BaseClass {
    static SettingObject object;

    @BeforeClass
    public static void bef() {

        object = new SettingObject(driver);
    }

    @Test
    public void testSetting1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void testSettingTempF() {
        object.temSelect(SettingObject.TEMP.F);
    }
  /*  @Test
    public void testSettingTempC() {
        object.temSelect(SettingObject.TEMP.C);
    }
*/
    @Test
    public void testSettingSpeedMPH() {

        object.selectSpeedMetric(SettingObject.SPEED.MPH);
    }
    @Test
    public void testSettingSpeedM() {

        object.selectSpeedMetric(SettingObject.SPEED.M);
    }

 /*   @Test
    public void testSettingTime12() {

        object.timeSelect(SettingObject.TIME.TWELVE);
    }
    @Test
    public void testSettingTime24() {

        object.timeSelect(SettingObject.TIME.TWENTY_FOUR);
    }*/

}
