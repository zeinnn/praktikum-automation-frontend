package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import elements.header.Header;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    public Header header = new Header();

    public MainPage mainPage = new MainPage();


    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    void addListeners(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
