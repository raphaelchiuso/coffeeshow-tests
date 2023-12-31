import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
        waitMilliseconds(1000);
    }

    public void tearDown() {
        waitMilliseconds(1000);
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

    public void clickWebElementByInnerText(String tag, String innerText){
        var webElement = driver.findElement(By.xpath("//"+ tag+ "[text()='"+innerText+"']"));
        webElement.click();
    }

    public void waitMilliseconds(long duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillInputElementById(String id, String content){
        var webElement = driver.findElement(By.id(id));
        webElement.sendKeys(content);
    }

    public void fillInputElementByName(String name, String content){
        var webElement = driver.findElement(By.name(name));
        waitMilliseconds(500);
        new Actions(driver).keyDown(webElement, Keys.CONTROL).sendKeys("a").keyUp(webElement, Keys.CONTROL).perform();
        waitMilliseconds(500);
        new Actions(driver).sendKeys(Keys.BACK_SPACE).perform();
        waitMilliseconds(500);
        webElement.sendKeys("\b");
        waitMilliseconds(500);
        webElement.sendKeys(content);
    }

    public Faker createFakerInstance(){
        return new Faker();
    }

    public WebElement getWebElementByInnerText(String tag, String content){
        return driver.findElement(By.xpath("//"+tag+"[text()='"+content+"']"));
    }

    public int getTableRowsSizeByClassName(String className){
        WebElement tabela = driver.findElement(By.className(className));
        List<WebElement> linhas = tabela.findElements(By.tagName("tr"));
        return linhas.size();
    }
}
