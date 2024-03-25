package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
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


public class TestBase {


    public Header header = new Header();

    public MainPage mainPage = new MainPage();

    public OrderPage orderPage = new OrderPage();

    public TrackPage trackPage = new TrackPage();

    public Cookie cookie = new Cookie();

    public DatePicker datePicker = new DatePicker();


    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:/Users/smith/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        //WebDriver driver = new ChromeDriver(options);
        Configuration.baseUrl = "https://qa-scooter.praktikum-services.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        options.setCapability("browserVersion", "121.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
    void addListeners(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



}
