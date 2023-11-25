import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteTests {
    private final String deleteItemButtonId = "delete";
    private final String deleteItemModalId = "chakra-modal-:R1qpf6:";
    private final String deleteItemConfirmationModalClassName = "chakra-modal__content";
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
    @DisplayName("Should open delete items modal.")
    void shouldOpenEditItemsModal(){
        testHelper.clickButtonById(deleteItemButtonId);
        assertThat(testHelper.getWebElementById(deleteItemModalId).isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Should open delete item confirmation modal.")
    void shouldOpenEditMenuOnProductEditItemClick(){
        var webDriverWait = testHelper.createWebDriverWaitByDuration(500);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("css-13t1uiu")));
        testHelper.clickButtonById(deleteItemButtonId);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("css-1mj7xoy")));
        testHelper.clickButtonByClassName("css-1mj7xoy");
        assertThat(testHelper.getWebElementByClass(deleteItemConfirmationModalClassName).isDisplayed()).isTrue();
    }
}
