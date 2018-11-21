import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class ApiKeysTab {
    private WebDriver driver;
    public ApiKeysTab(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnApiKeys(){
        By apiKeys = By.cssSelector("a[href$='/api_keys']");
        driver.findElement(apiKeys).click();
    }

    public void addApiKeys (String input) {
        By name = By.id("api_key_form_name");
        By commitButton = By.name("commit");
        driver.findElement(name).sendKeys(input);
        driver.findElement(commitButton).click();
    }

    public void updateApiKey(String apiKeyName, String input) throws InterruptedException {

        By textField = By.cssSelector(".required #edit_key_form_name");
        By edit = By.xpath("//*[@id='edit_key_modal']/div/div/div[3]/button[2]");
        By location = By.xpath("//table[@class='table api-keys']//pre[text()='"+ apiKeyName +"']/../..//a[1]");
            driver.findElement(location).click();
            driver.findElement(textField).sendKeys(input);
            driver.findElement(edit).click();
        }

    public void deleteApiKeys (String apiKeyName) {
        driver.findElement(By.xpath("//table[@class='table api-keys']//pre[text()='"+ apiKeyName +"']/../..//a[2]")).click();
        driver.switchTo().alert().accept();
    }
}

