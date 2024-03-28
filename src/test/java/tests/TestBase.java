package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import elements.DatePicker;
import elements.cookie.Cookie;
import elements.header.Header;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.order.OrderPage;
import pages.track.TrackPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class TestBase {


    public Header header = new Header();

    public MainPage mainPage = new MainPage();

    public OrderPage orderPage = new OrderPage();

    public TrackPage trackPage = new TrackPage();

    public Cookie cookie = new Cookie();

    public DatePicker datePicker = new DatePicker();

    public Faker faker = new Faker(new Locale("ru"));


    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files (x86)/Yandex/YandexBrowser/Application/browser.exe");
        WebDriver driver = new ChromeDriver(options);
        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 100000;
    }
    void addListeners(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



}
