import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHelper {

    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000");
    }

    public void tearDown() {
        driver.quit();
    }

    public void clickButtonById(String id){
        var buttonEdit = driver.findElement(By.id(id));
        buttonEdit.click();
    }

    public void clickButtonByClassName(String className){
        var buttonEdit = driver.findElement(By.className(className));
        buttonEdit.click();
    }

    public WebElement getWebElementById(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement getWebElementByClass(String className){
        return driver.findElement(By.className(className));
    }

    public void fillInputElementById(String id, String content){
        var webElement = driver.findElement(By.id(id));
        webElement.sendKeys(content);
    }
}
