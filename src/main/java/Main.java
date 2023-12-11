import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class Main extends Data {

    @Test
    public void Test1() {
        Data data = new Data();
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@type=\"search\"]")).sendKeys("discord", Keys.RETURN);
        WebElement discordLoginButton = driver.findElement(By.xpath("//h3[contains(text(), \"Discord | Your Place to Talk and Hang Out\")]"));
        discordLoginButton.click();
        WebElement loginButton = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = \"appButton-2_tWQ1\"]")));
        loginButton.click();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(data.login);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(data.pass, Keys.RETURN);
    }

    @Test
    public void builderTest(){
        UserModel user1 = UserModel.builder()
                .age("14");
    }
}