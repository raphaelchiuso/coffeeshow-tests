import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestHelper {

    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://coffee-show.vercel.app/");
    }

    public void tearDown() {
        driver.quit();
    }

    public void clickButtonById(String id){
        var button = driver.findElement(By.id(id));
        button.click();
    }

    public void clickButtonByClassName(String className){
        var button = driver.findElement(By.className(className));
        button.click();
    }

    public WebElement getWebElementById(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement getWebElementByClass(String className){
        return driver.findElement(By.className(className));
    }

    public void clickWebElementByInnerText(String innerText){
        var webElement = driver.findElement(By.xpath("//p[text()='"+innerText+"']"));
        webElement.click();
    }

    public WebDriverWait createWebDriverWaitByDuration(long duration){
        return new WebDriverWait(driver, Duration.ofMillis(duration));
    }

    public void fillInputElementById(String id, String content){
        var webElement = driver.findElement(By.id(id));
        webElement.sendKeys(content);
    }
}
