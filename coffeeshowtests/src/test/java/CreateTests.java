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
    private final String createItemButtonClassName = "chakra-button";
    private final String addItemModalId = "chakra-modal-:R1qpf6:";
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

    @Test
    @DisplayName("Should not create an item with empty fields")
    void ShouldNotCreateItemWithEmptyFields(){
        testHelper.clickButtonById(addItemButtonId);
        testHelper.clickButtonByClassName(createItemButtonClassName);
        assertThat(testHelper.getWebElementByClass("chakra-form__error-message").isDisplayed()).isTrue();
    }
}
