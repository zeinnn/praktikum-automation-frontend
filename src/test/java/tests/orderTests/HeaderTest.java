package tests.orderTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class HeaderTest extends TestBase {
    @Test
    @DisplayName("Если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката»")
    void scooterLogoTest(){
        step("Открыть страницу", () -> {
            mainPage.openPage();
            cookie.clickCookieButton();
        });
        step("Нажать кнопку создания заказа в хедере", () -> {
            header.orderButtonClick();
        });
        step("Кликнуть по иконке 'Самокат' в хедере", () -> {
            header.scooterLogoClick();
        });
    }

}
