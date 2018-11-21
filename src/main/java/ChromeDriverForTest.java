import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverForTest {
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NghiTran\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
