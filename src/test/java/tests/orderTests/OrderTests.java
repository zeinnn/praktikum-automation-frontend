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
    @DisplayName("Проверка заказа по не существующему номеру")
    void fakeOrderNumber(TestInfo info){
        step("Open page", () -> {
            mainPage.openPage();
            cookie.clickCookieButton();
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

    @Test
    @DisplayName("Заказ самоката через  кнопку Заказать в хедере")
    void headerOrder(){
        step("Открыть страницу", () -> {
            mainPage.openPage();
            cookie.clickCookieButton();
        });

        step("Нажать кнопку Заказать в хедере", () -> {
            header.orderButtonClick();
        });
        step("Ввести {{string}} в поле Имя", () -> {
            orderPage.fillNameField("Дмитрий");
        });

        step("Ввести {{string}} в поле Фамилия", () -> {
            orderPage.fillSurnameField("Иванов");
        });

        step("Ввести адрес в поле Адрес", () -> {
            orderPage.fillAddressField("Проезд Северный 1");
        });

        step("Ввести телефон в поле Телефон", () -> {
            orderPage.fillPhoneField("79619057777");
        });


        step("Выбрать станцию метро", () -> {
            orderPage.fillSubwayField("Бульвар Рокоссовского", "background-color: rgb(217, 43, 44);");
        });

        step("Нажать кнопку Далее", () -> {
            orderPage.clickNextButton();
        });





    }
}
