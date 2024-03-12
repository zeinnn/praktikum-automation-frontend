package tests.orderTests;

import elements.header.Header;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class OrderTests extends TestBase {

    @Test
    @DisplayName("Если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката»")
    void scooterLogoTest(){
        mainPage.openPage();
        header.orderButtonClick()
                .scooterLogoClick();

    }
}
