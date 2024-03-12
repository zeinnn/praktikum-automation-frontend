package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends  MainPageSelectors {

    public MainPage openPage(){
        open("https://qa-scooter.praktikum-services.ru/");
        getBigString().shouldHave(text("Самокат "));
        return this;

    }
}
