package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import elements.cookie.Cookie;
import elements.header.Header;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.order.OrderPage;
import pages.track.TrackPage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.UIManager.put;

public class TestBase {

    public Header header = new Header();

    public MainPage mainPage = new MainPage();

    public OrderPage orderPage = new OrderPage();

    public TrackPage trackPage = new TrackPage();

    public Cookie cookie = new Cookie();


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
