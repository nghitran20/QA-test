import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OpenWeatherMapPage {
    private WebDriver driver;
    public OpenWeatherMapPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignInButton(){
        By signInButton = By.cssSelector("a[href$='/users/sign_in']");
        driver.findElement(signInButton).click();

    }
}
