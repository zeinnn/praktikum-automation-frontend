package elements.header;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

@Getter

public class HeaderSelectors {

    private SelenideElement yandexLogo = $(By.className("Header_LogoYandex__3TSOI")),

    samokatLogo = $(byClassName("Header_LogoScooter__3lsAR"));
}
