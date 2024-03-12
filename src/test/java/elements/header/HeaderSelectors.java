package elements.header;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

@Getter

public class HeaderSelectors {

    private SelenideElement yandexLogo = $(By.className("Header_LogoYandex__3TSOI")),

    scooterLogo = $(byClassName("Header_LogoScooter__3lsAR")),

    headerDisclaimer = $(".Header_Disclaimer__3VEni"),

    orderButton = $(byXpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']")),

    orderStatusButton = $(byXpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Header_Link__1TAG7']")),

    orderNumberField = $(byXpath(".//input[@placeholder = 'Введите номер заказа']")),

    goButton = $(byXpath(".//button[text() = 'Go!']"));

}
