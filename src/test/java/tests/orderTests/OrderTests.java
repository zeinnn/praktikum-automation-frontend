package tests.orderTests;

import com.github.javafaker.Faker;
import elements.header.Header;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class OrderTests extends TestBase {

    Faker faker = new Faker();

    @Test
    @DisplayName("Если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката»")
    void scooterLogoTest(){
        step("Открыть страницу", () -> {
            mainPage.openPage();
        });
        step("Нажать кнопку создания заказа в хедере", () -> {
            header.orderButtonClick();
        });
        step("Кликнуть по иконке 'Самокат' в хедере", () -> {
            header.scooterLogoClick();
        });
    }

    @Test
    @DisplayName("Проверка заказа по не существующему номеру")
    void fakeOrderNumber(TestInfo info){
        step("Open page", () -> {
            mainPage.openPage();
        });

        step("Кликнуть по кнопке 'Статус заказа' ", () -> {
            header.clickOrderStatusButton();
        });

        step("Кликнуть по кнопке 'Статус заказа' ", () -> {
            header.clickOrderStatusButton();
        });

        step("Ввести в поле 'Введите статус заказа' несуществующий номер заказа", () -> {
            header.fillOrderNumberField("1");
        });

        step("Нажать кнопку Go", () -> {
            header.clickGoButton();
        });

        step("Проверить, что есть заглушка not found", () -> {
            trackPage.checkNotFound();
        });



    }
}
