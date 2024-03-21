package tests.orderTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import elements.header.Header;
import groovyjarjarpicocli.CommandLine;
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

        step("Заполнить форму Для кого самокат", () -> {
            orderPage.fillFirstOrderForm("Алексей",
                    "Дмитриев",
                    "Проезд Северный",
                    "Красные Ворота", "background-color: rgb(217, 43, 44);",
                    "89619056666");
        });

        step("Нажать кнопку Далее", () -> {
            orderPage.clickNextButton();
        });

        step("Заполнить форму Про аренду", () -> {
           orderPage.chooseDayOfWeek("понедельник, 25-е марта 2024 г.");
            orderPage.chooseRentDate("семеро суток");
            orderPage.chooseScooterColorGrey();
            orderPage.fillCommentaryField("Тест");
        });

        step("Нажать кнопку Заказать", () -> {
            orderPage.clickOrderButton();
        });

        step("Нажать кнопку Да", () -> {
            orderPage.clickYesOrderButton();
        });

        step("Найти созданный заказ в поиске", () -> {
            orderPage.clickYesOrderButton();
        });

        step("Сравнить ожидаемые и фактические результаты заказа", () -> {
            orderPage.clickYesOrderButton();
        });
    }
    @Test()
    @DisplayName("Проверка того, что тайтл старницы не пустой и не undefined")
    void titleTest(){
        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить title", () -> {
            mainPage.getTitle().shouldNotBe(Condition.empty);
        });



    }
}
