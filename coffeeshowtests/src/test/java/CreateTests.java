import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTests {
    private final String addItemButtonId = "create";
    private final String addItemModalId = "chakra-modal-:R7b5sm:";
    private final TestHelper testHelper = new TestHelper();

    @BeforeEach
    public void setUp() {
        testHelper.setUp();
    }

    @AfterEach
    public void tearDown() {
        testHelper.tearDown();
    }

    @Test
    @DisplayName("Should open add item modal on create button click.")
    void ShouldOpenAddItemModalOnCreateButtonClick(){
        testHelper.clickButtonById(addItemButtonId);
        assertThat(testHelper.getWebElementById(addItemModalId).isDisplayed()).isTrue();
    }
}
