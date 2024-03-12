package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class MainPageSelectors {

    SelenideElement bigString = $(byClassName("Home_Header__iJKdX"));
}
