import org.openqa.selenium.WebDriver;

public class TestRunner {
    @org.testng.annotations.Test
    public void runTest() throws InterruptedException {
        ChromeDriverForTest  chromeDriverForTest = new ChromeDriverForTest();
        WebDriver driver = chromeDriverForTest.getDriver();
        String url = "https://openweathermap.org/";
        //Home Page
        OpenWeatherMapPage OpenWeatherMapPage = new OpenWeatherMapPage(driver);
        driver.navigate().to(url);
        OpenWeatherMapPage.clickSignInButton();
        //Sign In
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInWithValidUserPass("wizetest1@gmail.com","autotest");


        // Add/update/delete API Keys
        ApiKeysTab apiKeysTab = new ApiKeysTab(driver);
        apiKeysTab.clickOnApiKeys();
        apiKeysTab.addApiKeys("hehehihi");
        apiKeysTab.updateApiKey("7a967236d9c018cfc08ccc9f10859df8", "1");
        apiKeysTab.deleteApiKeys("8c1791206c21c24cee68d574d7695f29");

        driver.close();

        //Sign In with invalid email and pass
        driver.navigate().to(url);
        OpenWeatherMapPage.clickSignInButton();
        signInPage.signInWithInvalidUserPass("wizetest","autotest1111");
    }
}
