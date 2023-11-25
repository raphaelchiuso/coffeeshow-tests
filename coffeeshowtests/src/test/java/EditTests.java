import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class EditTests {
    private final String editItemButtonId = "update";
    private final String editItemModalId = "chakra-modal-:R1qpf6:";
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
}
