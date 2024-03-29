package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends  MainPageSelectors {

    public MainPage openPage(){
        open("https://qa-scooter.praktikum-services.ru/");
        getBigString().shouldHave(text("Самокат\n" +
                "на пару дней\n" +
                "Привезём его прямо к вашей двери,\n" ));
        getBigString().shouldBe(visible);

        return this;

    }
}
