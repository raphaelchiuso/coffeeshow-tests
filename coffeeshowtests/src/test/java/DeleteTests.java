import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteTests {
    private final String deleteItemButtonId = "delete";
    private final String deleteItemModalId = "chakra-modal-:R1qpf6:";
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
}
