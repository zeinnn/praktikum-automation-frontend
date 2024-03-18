package elements.cookie;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Cookie {

    private final String COOKIE_BUTTON_TEXT = "да все привыкли";

    private final String COOKIE_MESSAGE_TEXT = "И здесь куки! В общем, мы их используем.";

    SelenideElement cookieConfirmButton = $(byId("rcc-confirm-button")),

    cookieText = $(byClassName("App_CookieText__1sbqp"));


    public Cookie clickCookieButton() {
        if(cookieConfirmButton.exists()){
            cookieConfirmButton.shouldHave(Condition.text(COOKIE_BUTTON_TEXT));
            cookieText.shouldHave(Condition.text(COOKIE_MESSAGE_TEXT));
        cookieConfirmButton.click();
        }
        return this;
    }
}
