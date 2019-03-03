import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class NotificationBlocker {
    public static void main(String[] args) {
        try
        {
            FirefoxProfile firefoxProfile=new FirefoxProfile();
            firefoxProfile.setPreference("dom.webnotifications.enable",false);
            firefoxProfile.setPreference("geo.enabled",true);
            WebDriver webDriver=new FirefoxDriver();
            webDriver.get("https://www.koovs.com/");


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
