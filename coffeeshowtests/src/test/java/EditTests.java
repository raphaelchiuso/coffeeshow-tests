import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

public class EditTests {
    private final String editItemButtonId = "update";
    private final String editItemModalId = "chakra-modal-:R1qpf6:";
    private final String editItemMenuModalClassName = "chakra-modal__content";
    private final String inputFieldName = "name";
    private final String inputFieldPrice = "price";
    private final String submitEditButtonClassName = "chakra-button";
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
    @DisplayName("Should open edit items modal.")
    void shouldOpenEditItemsModal(){
        testHelper.clickButtonById(editItemButtonId);
        assertThat(testHelper.getWebElementById(editItemModalId).isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Should open edit menu on item click.")
    void shouldOpenEditMenuOnProductEditItemClick(){
        testHelper.clickButtonById(editItemButtonId);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonByClassName("css-szjio1");
        testHelper.waitMilliseconds(1000);
        assertThat(testHelper.getWebElementByClass(editItemMenuModalClassName).isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Should save an edit to Name Input.")
    void shouldSaveAnEditionOnNameInputField(){
        var fakeString = testHelper.createFakerInstance().number().digits(6);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonById(editItemButtonId);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonByClassName("css-szjio1");
        testHelper.waitMilliseconds(1000);
        testHelper.fillInputElementByName(inputFieldName, fakeString);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonByClassName(submitEditButtonClassName);
        testHelper.waitMilliseconds(1000);
        assertThat(testHelper.getWebElementByInnerText("td", fakeString).isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Should save an edit to Price Input.")
    void shouldSaveAnEditionOnPriceInputField(){
        var fakeString = testHelper.createFakerInstance().number().randomDouble(2, 40, 53);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonById(editItemButtonId);
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonByClassName("css-szjio1");
        testHelper.waitMilliseconds(1000);
        testHelper.fillInputElementByName(inputFieldPrice, valueOf(fakeString));
        testHelper.waitMilliseconds(1000);
        testHelper.clickButtonByClassName(submitEditButtonClassName);
        testHelper.waitMilliseconds(1000);
        assertThat(testHelper.getWebElementByInnerText("td", valueOf(fakeString)).isDisplayed()).isTrue();
    }
}
