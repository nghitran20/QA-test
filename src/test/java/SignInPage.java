import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    private By userName = By.id("user_email");
    private By passWord = By.id("user_password");
    private By submitButton = By.name("commit");

    public void signInWithValidUserPass(String name, String pw){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(passWord).sendKeys(pw);
        driver.findElement(submitButton).click();

        By success = By.className("primary-font");
        String expectResult = "My Home";
        String actualResult = driver.findElement(success).getText();
        assertEquals(actualResult, expectResult, "Actual result should be same as expect result");
    }

    public void signInWithInvalidUserPass(String name, String pw){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(passWord).sendKeys(pw);
        driver.findElement(submitButton).click();

        By fail = By.className("panel-heading");
        String expectResult = "Alert";
        String actualResult = driver.findElement(fail).getText();
        assertEquals(actualResult, expectResult, "Actual result should be same as expect result");
    }
}
